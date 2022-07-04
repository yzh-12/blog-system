package com.zeng.factory;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zeng.constant.IdentityTypeConst;
import com.zeng.dao.UserAuthsDao;
import com.zeng.entities.po.UserAuthsPo;
import com.zeng.entities.vo.LoginVo;
import com.zeng.exception.BusinessException;
import com.zeng.utils.PasswordUtil;
import org.springframework.stereotype.Component;

@Component
public class UserNamePwdIdentity implements BaseIdentity {

    private UserAuthsDao userAuthsDao;

    public UserNamePwdIdentity(UserAuthsDao userAuthsDao) {
        this.userAuthsDao = userAuthsDao;
    }

    @Override
    public String login(LoginVo loginInfo) throws BusinessException {
        QueryWrapper<UserAuthsPo> wrapper = new QueryWrapper<>();
        wrapper.eq("identity_type", loginInfo.getIdentityType().key());
        wrapper.eq("identifier", loginInfo.getIdentifier());
        UserAuthsPo userAuthsPo = userAuthsDao.selectOne(wrapper);
        if (userAuthsPo == null) {
            throw new BusinessException("Account does not exist.");
        }
        if (!PasswordUtil.checkpw(loginInfo.getCredential(), userAuthsPo.getCredential())) {
            throw new BusinessException("password incorrect.");
        }
        return userAuthsPo.getUserId();
    }

    @Override
    public IdentityTypeConst getIdentityType() {
        return IdentityTypeConst.USERNAME_PASSWORD;
    }
}
