package com.zeng.entity.vo;

import lombok.Data;

@Data
public class MessageSendVo {
    private String nickName;
    private Integer sendType;
    private String destination;
    private String templateId;
    private Integer isSend;
}
