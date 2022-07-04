package com.zeng.dao;

import com.zeng.entities.bo.RolePermissionBo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RolePermissionDao {

    List<RolePermissionBo> qryAllRolePermission();

    // TODO: 2022/7/4  
    int insertRoleWithPermission();

}
