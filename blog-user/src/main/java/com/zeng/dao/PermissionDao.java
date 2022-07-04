package com.zeng.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeng.entities.po.PermissionPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionDao extends BaseMapper<PermissionPo> {
}
