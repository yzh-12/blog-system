package com.zeng.feign;

import com.zeng.feign.vo.MessageSendVo;
import com.zeng.web.domain.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("blog-message")
public interface MessageClient {

    @PostMapping("/message/message/send/batch")
    public BaseResult<Object> createBatchMessageSend(List<MessageSendVo> vos);

}
