package com.zeng.service.serviceImpl;

import cn.hutool.core.lang.Pair;
import com.zeng.dao.RolePermissionDao;
import com.zeng.entities.bo.PermissionBo;
import com.zeng.entities.bo.RolePermissionBo;
import com.zeng.entities.po.RolePermissionPo;
import com.zeng.service.RoleResourceService;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RoleResourceServiceImpl implements RoleResourceService {

    private RolePermissionDao rolePermissionDao;

    public RoleResourceServiceImpl(RolePermissionDao rolePermissionDao) {
        this.rolePermissionDao = rolePermissionDao;
    }

    @Override
    public RolePermissionBo getRoleResourceByUserId(String userId) {
        List<RolePermissionPo> rolePermissionList = rolePermissionDao.qryRoleResourceByUserId(userId);
        Map<Pair<String, String>, List<PermissionBo>> groupResult = rolePermissionList.stream().collect(Collectors.groupingBy(e -> Pair.of(e.getRoleId(), e.getRoleName()), Collectors.mapping(e -> {
            PermissionBo permission = new PermissionBo();
            permission.setPermissionId(e.getPermissionId());
            permission.setPermissionName(e.getPermissionName());
            return permission;
        }, Collectors.toList())));

        RolePermissionBo result = new RolePermissionBo();
        Iterator<Map.Entry<Pair<String, String>, List<PermissionBo>>> iterator = groupResult.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Pair<String, String>, List<PermissionBo>> entry = iterator.next();
            Pair<String, String> pair = entry.getKey();
            result.setRoleId(pair.getKey());
            result.setRoleName(pair.getValue());
            result.setPermissionList(entry.getValue());
        }
        return result;
    }
}
