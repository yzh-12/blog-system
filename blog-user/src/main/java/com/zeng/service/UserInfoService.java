package com.zeng.service;

import com.zeng.entities.bo.UserDetailInfoBo;
import com.zeng.entities.po.UserInfoPo;
import com.zeng.entities.vo.CreateUserVo;
import com.zeng.entities.vo.JoinVipVo;

public interface UserInfoService {

    UserInfoPo getUserInfoByUserId(String userId);

    UserDetailInfoBo getUserDetailInfo(String userId);

    int addUserInfo(UserInfoPo userInfo);

    boolean createUser(CreateUserVo createUserVo);

    boolean joinToVip(JoinVipVo joinVipVo);
}
