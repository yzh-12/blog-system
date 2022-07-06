package com.zeng.dao;

import com.zeng.entities.bo.RolePermissionBo;
import com.zeng.entities.po.RolePermissionPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RolePermissionDao {

    List<RolePermissionBo> qryAllRolePermission();

    List<RolePermissionPo> qryRoleResourceByUserId(String userId);
}
