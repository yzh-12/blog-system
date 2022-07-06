package com.zeng.entities.bo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDetailInfoBo {
    private String userId;
    private String userName;
    private String nickName;
    private int sex;
    private String phoneNumber;
    private String email;
    private String avatarUrl;
    private RolePermissionBo rolePermissionInfo;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
