package com.zeng.service.serviceImpl;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeng.constant.IdentityTypeConst;
import com.zeng.dao.UserAuthsDao;
import com.zeng.entities.po.UserAuthsPo;
import com.zeng.entities.vo.LoginVo;
import com.zeng.exception.LoginException;
import com.zeng.exception.PwdUpdateException;
import com.zeng.factory.BaseIdentity;
import com.zeng.factory.IdentityFactory;
import com.zeng.service.UserAuthsService;
import com.zeng.utils.DateUtil;
import com.zeng.utils.ObjUtil;
import com.zeng.utils.PasswordUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Service
public class UserAuthsServiceImpl extends ServiceImpl<UserAuthsDao, UserAuthsPo> implements UserAuthsService {

    private UserAuthsDao userAuthsDao;

    private IdentityFactory identityFactory;


    public UserAuthsServiceImpl(UserAuthsDao userAuthsDao, IdentityFactory identityFactory) {
        this.userAuthsDao = userAuthsDao;
        this.identityFactory = identityFactory;
    }

    @Override
    public int addUserAuths(UserAuthsPo userAuthsPo) {
        LocalDateTime now = DateUtil.getNowLocalDateTime();
        userAuthsPo.setCreateTime(now);
        userAuthsPo.setUpdateTime(now);
        return userAuthsDao.insert(userAuthsPo);
    }

    @Override
    public String login(LoginVo loginInfo) {
        if (StpUtil.isLogin()) {
            throw new LoginException("account is login already.");
        }
        BaseIdentity identity = identityFactory.productIdentity(loginInfo);
        String userId = identity.login(loginInfo);
        if (StrUtil.isEmptyIfStr(userId)) {
            return null;
        }
        StpUtil.login(loginInfo.getIdentifier());
        SaSession session = StpUtil.getSession();
        session.set("user_id", userId);
        return userId;
    }

    @Override
    public boolean logout() {
        StpUtil.checkLogin();
        if (StpUtil.isLogin()) {
            StpUtil.logout();
            return true;
        }
        return false;
    }

    @Override
    public boolean checkPwd(String userId, String pwd) {
        if (ObjUtil.equalsNull(userId, pwd)) {
            return false;
        }
        QueryWrapper<UserAuthsPo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        wrapper.eq("identity_type", IdentityTypeConst.USERNAME_PASSWORD.key());
        UserAuthsPo result = userAuthsDao.selectOne(wrapper);
        String credential = result.getCredential();
        return PasswordUtil.checkpw(pwd, credential);
    }

    @Transactional
    @Override
    public boolean changePwd(String userId, String newPwd) {
        if (ObjUtil.equalsNull(userId, newPwd)) {
            return false;
        }
        UpdateWrapper<UserAuthsPo> wrapper = new UpdateWrapper<>();
        wrapper.eq("user_id", userId);
        wrapper.eq("identity_type", IdentityTypeConst.USERNAME_PASSWORD.key());
        wrapper.set("credential", PasswordUtil.hashpw(newPwd));
        wrapper.set("update_time", DateUtil.getNowLocalDateTime());
        int update = userAuthsDao.update(null, wrapper);
        if (update != 1) {
            throw new PwdUpdateException("password changed error.");
        }
        StpUtil.logout();
        return true;
    }
}
