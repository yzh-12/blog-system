package com.zeng.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeng.dao.UserInfoDao;
import com.zeng.entities.po.UserInfoPo;
import com.zeng.service.UserInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoPo> implements UserInfoService {

}
