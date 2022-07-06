package com.zeng.entities.bo;

import lombok.Data;

import java.util.List;

@Data
public class RolePermissionBo {
    private String roleId;
    private String roleName;
    private List<PermissionBo> permissionList;
}


