package com.zeng.service;

import com.zeng.entities.po.UserInfoPo;
import com.zeng.entities.vo.CreateUserVo;

public interface UserInfoService {

    UserInfoPo getUserInfoByUserId(String userId);

    int addUserInfo(UserInfoPo userInfo);

    boolean createUser(CreateUserVo createUserVo);
}
