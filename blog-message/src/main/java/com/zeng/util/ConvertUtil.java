package com.zeng.util;

import com.google.common.collect.Lists;
import com.zeng.entity.po.MessageSendPo;
import com.zeng.entity.vo.MessageSendVo;

import java.util.List;

public class ConvertUtil {

    public static MessageSendPo convert(MessageSendVo param) {
        if (param == null) {
            return null;
        }
        MessageSendPo result = new MessageSendPo();
        result.setNickName(param.getNickName());
        result.setSendType(param.getSendType());
        result.setDestination(param.getDestination());
        result.setTemplateId(param.getTemplateId());
        result.setIsSend(param.getIsSend());
        return result;
    }

    public static List<MessageSendPo> convert(List<MessageSendVo> param) {
        if (param == null) {
            return null;
        }
        return Lists.transform(param, e -> convert(e));
    }
}
