package com.zeng.service;

import com.zeng.entities.po.PermissionPo;

import java.util.List;

public interface RoleResource {

    List<PermissionPo> getAllPermission();
}
