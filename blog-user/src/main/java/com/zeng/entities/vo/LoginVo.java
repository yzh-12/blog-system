package com.zeng.entities.vo;

import javax.validation.constraints.NotNull;

import com.zeng.constant.IdentityTypeConst;

import lombok.Data;

@Data
public class LoginVo {
    @NotNull(message = "identity type can not be null.")
    private IdentityTypeConst identityType;
    private String identifier;
    private String credential;
}
