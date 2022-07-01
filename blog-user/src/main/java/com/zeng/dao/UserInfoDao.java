package com.zeng.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeng.entities.po.UserInfoPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoDao extends BaseMapper<UserInfoPo> {
}
