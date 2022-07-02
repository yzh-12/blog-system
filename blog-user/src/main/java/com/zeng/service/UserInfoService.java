package com.zeng.service;

import com.zeng.entities.po.UserInfoPo;

public interface UserInfoService {

    UserInfoPo getUserInfoByUserId(String userId);

    int addUserInfo(UserInfoPo userInfo);
}
