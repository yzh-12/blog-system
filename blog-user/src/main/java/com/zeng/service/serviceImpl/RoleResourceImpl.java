package com.zeng.service.serviceImpl;

import com.zeng.dao.PermissionDao;
import com.zeng.entities.po.PermissionPo;
import com.zeng.service.RoleResource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleResourceImpl implements RoleResource {

    private PermissionDao permissionDao;

    public RoleResourceImpl(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    @Override
    public List<PermissionPo> getAllPermission() {
        return null;
    }
}
