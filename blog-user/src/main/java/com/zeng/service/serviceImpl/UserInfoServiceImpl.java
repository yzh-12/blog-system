package com.zeng.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeng.dao.UserInfoDao;
import com.zeng.entities.po.UserInfoPo;
import com.zeng.service.UserInfoService;
import com.zeng.utils.DateUtil;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoPo> implements UserInfoService {

    private UserInfoDao userInfoDao;

    public UserInfoServiceImpl(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    @Override
    public UserInfoPo getUserInfoByUserId(String userId) {
        return this.getById(userId);
    }

    @Override
    public int addUserInfo(UserInfoPo userInfo) {
        LocalDateTime time = DateUtil.getNowLocalDateTime();
        userInfo.setCreateTime(time);
        userInfo.setUpdateTime(time);
        return userInfoDao.insert(userInfo);
    }

}
