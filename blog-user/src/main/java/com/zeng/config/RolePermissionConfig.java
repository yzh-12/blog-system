package com.zeng.config;

import cn.dev33.satoken.stp.StpInterface;
import com.google.common.collect.Lists;
import com.zeng.entities.bo.PermissionBo;
import com.zeng.entities.bo.RolePermissionBo;
import com.zeng.service.RoleResource;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class RolePermissionConfig implements StpInterface {

    private RoleResource roleResource;

    public RolePermissionConfig(RoleResource roleResource) {
        this.roleResource = roleResource;
    }

    @Override
    public List<String> getPermissionList(Object userId, String s) {
        RolePermissionBo result = roleResource.getRoleResourceByUserId(((String) userId));
        return result.getPermissionList().stream().map(PermissionBo::getPermissionName).collect(Collectors.toList());
    }

    @Override
    public List<String> getRoleList(Object userId, String s) {
        RolePermissionBo result = roleResource.getRoleResourceByUserId(((String) userId));
        return Lists.newArrayList(result.getRoleName());
    }
}
