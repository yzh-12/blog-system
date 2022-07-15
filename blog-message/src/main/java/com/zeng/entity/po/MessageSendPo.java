package com.zeng.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("message_send")
public class MessageSendPo {
    @TableId(value = "message_send_id", type = IdType.ASSIGN_UUID)
    private String messageSendId;
    private String nickName;
    private Integer sendType;
    private String destination;
    private String templateId;
    private Integer isSend;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
