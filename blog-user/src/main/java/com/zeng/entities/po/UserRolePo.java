package com.zeng.entities.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user_role")
public class UserRolePo {
    @TableId
    private String userId;
    private String roleId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
