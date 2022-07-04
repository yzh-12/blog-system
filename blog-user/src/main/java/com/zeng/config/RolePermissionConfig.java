package com.zeng.config;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RolePermissionConfig implements StpInterface {

    // TODO: 2022/7/4  

    @Override
    public List<String> getPermissionList(Object loginId, String s) {
        return null;
    }

    @Override
    public List<String> getRoleList(Object loginId, String s) {
        return null;
    }
}
