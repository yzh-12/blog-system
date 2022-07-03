package com.zeng.entities.po;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("user_auths")
public class UserAuthsPo {
    @TableId(value = "user_auth_id", type = IdType.ASSIGN_UUID)
    private String userAuthId;
    private String userId;
    private Integer identityType;
    private String identifier;
    private String credential;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
