package com.zeng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeng.dao.MessageSendDao;
import com.zeng.entity.po.MessageSendPo;
import com.zeng.entity.vo.MessageSendVo;
import com.zeng.service.MessageSendService;
import com.zeng.util.ConvertUtil;
import com.zeng.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageSendServiceImpl extends ServiceImpl<MessageSendDao, MessageSendPo> implements MessageSendService {

    private MessageSendDao messageSendDao;

    public MessageSendServiceImpl(MessageSendDao messageSendDao) {
        this.messageSendDao = messageSendDao;
    }

    @Override
    public int addMessageSend(MessageSendVo sendMessage) {
        MessageSendPo po = ConvertUtil.convert(sendMessage);
        LocalDateTime now = DateUtil.getNowLocalDateTime();
        po.setCreateTime(now);
        po.setUpdateTime(now);
        return messageSendDao.insert(po);
    }

    @Override
    public int addBatchMessageSend(List<MessageSendVo> sendMessageList) {
        List<MessageSendPo> poList = ConvertUtil.convert(sendMessageList);
        LocalDateTime now = DateUtil.getNowLocalDateTime();
        List<MessageSendPo> handPoList = poList.stream()
                .peek(e -> {
                    e.setCreateTime(now);
                    e.setUpdateTime(now);
                }).collect(Collectors.toList());
        if (saveBatch(handPoList)) {
            return handPoList.size();
        }
        return 0;
    }
}
