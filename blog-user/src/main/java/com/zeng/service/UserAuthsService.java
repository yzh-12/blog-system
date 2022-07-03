package com.zeng.service;

import com.zeng.entities.po.UserAuthsPo;
import com.zeng.entities.vo.LoginVo;

public interface UserAuthsService {

    int addUserAuths(UserAuthsPo userAuthsPo);

    boolean login(LoginVo loginInfo);

}
