package com.zeng.service;

import com.zeng.entities.bo.UserDetailInfoBo;
import com.zeng.entities.po.UserInfoPo;
import com.zeng.entities.po.UserRolePo;
import com.zeng.entities.vo.ChangePwdVo;
import com.zeng.entities.vo.CreateUserVo;
import com.zeng.entities.vo.JoinVipVo;

import java.util.List;

public interface UserInfoService {

    UserInfoPo getUserInfoByUserId(String userId);

    UserDetailInfoBo getUserDetailInfo(String userId);

    int addUserInfo(UserInfoPo userInfo);

    boolean createUser(CreateUserVo createUserVo);

    boolean joinToVip(JoinVipVo joinVipVo);

    boolean changePwd(ChangePwdVo pwdVo);

    List<UserRolePo> getExpirationUser(int expirationDay);
}
