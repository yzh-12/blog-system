package com.zeng.service.serviceImpl;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeng.dao.UserAuthsDao;
import com.zeng.entities.po.UserAuthsPo;
import com.zeng.entities.vo.LoginVo;
import com.zeng.factory.BaseIdentity;
import com.zeng.factory.IdentityFactory;
import com.zeng.service.UserAuthsService;
import com.zeng.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
