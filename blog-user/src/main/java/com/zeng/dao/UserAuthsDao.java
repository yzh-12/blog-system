package com.zeng.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeng.entities.po.UserAuthsPo;

@Mapper
public interface UserAuthsDao extends BaseMapper<UserAuthsPo> {

}
