package com.zeng.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zeng.entity.po.MessageSendPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageSendDao extends BaseMapper<MessageSendPo> {
}
