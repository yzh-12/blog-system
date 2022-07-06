package com.zeng.entities.vo;

import com.zeng.constant.RoleConst;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class JoinVipVo {
    private String userId;
    @NotNull
    private String fee;
    @NotNull
    private RoleConst role;
}
