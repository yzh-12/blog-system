package com.zeng.entities.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.zeng.constant.GenderConst;
import com.zeng.constant.IdentityTypeConst;

import com.zeng.constant.RoleConst;
import lombok.Data;

@Data
public class CreateUserVo {
    @NotNull(message = "user name can not be null.")
    @NotEmpty(message = "user name can not be empty.")
    private String userName;
    @NotNull(message = "nick name can not be null.")
    @NotEmpty(message = "nick name can not be empty.")
    private String nickName;
    @NotNull(message = "sex can not be null.")
    private GenderConst sex;
    private String phoneNumber;
    private String email;
    private String avatarUrl;
    @NotNull(message = "identity type can not be null.")
    private IdentityTypeConst identityType;
    private String identifier;
    private String credential;
    @NotNull(message = "role can not be null.")
    private RoleConst role;
}
