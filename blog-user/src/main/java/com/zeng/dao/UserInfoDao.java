package com.zeng.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeng.entities.po.UserInfoPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInfoDao extends BaseMapper<UserInfoPo> {

    int countUserInfoRepeat(@Param("userName") String userName, @Param("phoneNumber") String phoneNumber, @Param("email") String email);
}
