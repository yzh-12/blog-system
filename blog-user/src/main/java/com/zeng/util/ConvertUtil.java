package com.zeng.util;

import java.time.LocalDateTime;

import com.zeng.entities.po.UserAuthsPo;
import com.zeng.entities.po.UserInfoPo;
import com.zeng.entities.vo.CreateUserVo;
import com.zeng.utils.DateUtil;

import cn.hutool.core.lang.Pair;

public final class ConvertUtil {

    public static Pair<UserInfoPo, UserAuthsPo> convert(CreateUserVo param) {
        UserInfoPo userInfo = new UserInfoPo();
        UserAuthsPo userAuhts = new UserAuthsPo();
        userInfo.setUserName(param.getUserName());
        userInfo.setNickName(param.getNickName());
        userInfo.setSex(param.getSex().key());
        userInfo.setPhoneNumber(param.getPhoneNumber());
        userInfo.setEmail(param.getEmail());
        userInfo.setAvatarUrl(param.getAvatarUrl());

        userAuhts.setIdentityType(param.getIdentityType().key());
        userAuhts.setIdentifier(param.getIdentifier());
        userAuhts.setCredential(param.getCredential());

        LocalDateTime now = DateUtil.getNowLocalDateTime();
        userInfo.setCreateTime(now);
        userInfo.setUpdateTime(now);
        userAuhts.setUpdateTime(now);
        userAuhts.setCreateTime(now);

        return Pair.of(userInfo, userAuhts);
    }
}
