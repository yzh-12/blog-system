package com.zeng.service.serviceImpl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeng.dao.UserAuthsDao;
import com.zeng.entities.po.UserAuthsPo;
import com.zeng.entities.vo.LoginVo;
import com.zeng.service.UserAuthsService;
import com.zeng.utils.DateUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserAuthsServiceImpl extends ServiceImpl<UserAuthsDao, UserAuthsPo> implements UserAuthsService {

    private UserAuthsDao userAuthsDao;

    public UserAuthsServiceImpl(UserAuthsDao userAuthsDao) {
        this.userAuthsDao = userAuthsDao;
    }

    @Override
    public int addUserAuths(UserAuthsPo userAuthsPo) {
        LocalDateTime now = DateUtil.getNowLocalDateTime();
        userAuthsPo.setCreateTime(now);
        userAuthsPo.setUpdateTime(now);
        return userAuthsDao.insert(userAuthsPo);
    }

    @Override
    public boolean login(LoginVo loginInfo) {
        return false;
    }

}
