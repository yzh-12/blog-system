package com.zeng.controller;

import com.zeng.entity.vo.MessageSendVo;
import com.zeng.service.MessageSendService;
import com.zeng.web.controller.BaseController;
import com.zeng.web.domain.BaseResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController extends BaseController {

    private MessageSendService messageSendService;

    public MessageController(MessageSendService messageSendService) {
        this.messageSendService = messageSendService;
    }

    @GetMapping("vip")
    public BaseResult<Object> sendVipExpirationMessage(String userId, String templateId) {
        return success();
    }

    @PostMapping("message/send")
    public BaseResult<Object> createMessageSend(@RequestBody MessageSendVo vo) {
        int result = messageSendService.addMessageSend(vo);
        return success("createMessageSend success.", result);
    }

    @PostMapping("message/send/batch")
    public BaseResult<Object> createBatchMessageSend(@RequestBody List<MessageSendVo> vos) {
        int result = messageSendService.addBatchMessageSend(vos);
        return success("createMessageSend success.", result);
    }

}
