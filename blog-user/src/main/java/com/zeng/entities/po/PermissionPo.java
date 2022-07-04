package com.zeng.entities.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("permission")
public class PermissionPo {
    @TableId(value = "permission_id", type = IdType.ASSIGN_ID)
    private String permissionId;
    private String permissionName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
