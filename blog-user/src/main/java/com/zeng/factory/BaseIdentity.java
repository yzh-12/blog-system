package com.zeng.factory;

import com.zeng.constant.IdentityTypeConst;
import com.zeng.entities.vo.LoginVo;
import com.zeng.exception.BusinessException;

public interface BaseIdentity {
    String login(LoginVo loginInfo) throws BusinessException;

    IdentityTypeConst getIdentityType();
}
