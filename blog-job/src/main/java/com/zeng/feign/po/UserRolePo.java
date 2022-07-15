package com.zeng.feign.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserRolePo {
    private String userId;
    private String roleId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private LocalDateTime expirationTime;
}
