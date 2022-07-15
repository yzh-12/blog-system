package com.zeng.service;

import com.zeng.entity.vo.MessageSendVo;

import java.util.List;

public interface MessageSendService {

    int addMessageSend(MessageSendVo sendMessage);

    int addBatchMessageSend(List<MessageSendVo> sendMessageList);
}
