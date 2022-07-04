package com.zeng.entities.bo;

import lombok.Data;

import java.util.List;

@Data
public class RolePermissionBo {
    private String roleId;
    private String permissionId;
    private List<Permission> permissionList;

    @Data
    class Permission {
        private String roleName;
        private String permissionName;
    }
}


