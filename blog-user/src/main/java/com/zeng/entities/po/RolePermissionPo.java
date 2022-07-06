package com.zeng.entities.po;

import lombok.Data;

@Data
public class RolePermissionPo {
    private String userId;
    private String roleId;
    private String permissionId;
    private String roleName;
    private String permissionName;
}
