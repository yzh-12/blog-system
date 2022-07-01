package com.zeng.entities.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@TableName("user_info")
@Data
public class UserInfoPo {
    @TableId(value = "user_id", type = IdType.AUTO)
    private String userId;
    private String userName;
    private String nickName;
    private int sex;
    private String phoneNumber;
    private String email;
    private String avatarUrl;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
