package com.zeng.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeng.dao.UserAuthsDao;
import com.zeng.dao.UserInfoDao;
import com.zeng.entities.po.UserAuthsPo;
import com.zeng.entities.po.UserInfoPo;
import com.zeng.entities.vo.CreateUserVo;
import com.zeng.service.UserInfoService;
import com.zeng.util.ConvertUtil;
import com.zeng.utils.DateUtil;
import com.zeng.utils.PasswordUtil;

import cn.hutool.core.lang.Pair;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoPo> implements UserInfoService {

    private UserInfoDao userInfoDao;
    private UserAuthsDao userAuthsDao;

    public UserInfoServiceImpl(UserInfoDao userInfoDao, UserAuthsDao userAuthsDao) {
        this.userInfoDao = userInfoDao;
        this.userAuthsDao = userAuthsDao;
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

    @Transactional
    @Override
    public boolean createUser(CreateUserVo createUserVo) {
        log.info("create user starting. args create user vo => {}", createUserVo);
        Pair<UserInfoPo, UserAuthsPo> convertResult = ConvertUtil.convert(createUserVo);
        UserInfoPo userInfo = convertResult.getKey();
        UserAuthsPo userAuths = convertResult.getValue();
        int infoResult = userInfoDao.insert(userInfo);
        userAuths.setUserId(userInfo.getUserId());
        userAuths.setCredential(PasswordUtil.hashpw(userAuths.getCredential()));
        int authsResult = userAuthsDao.insert(userAuths);
        if (infoResult != 1 && authsResult != 1) {
            throw new RuntimeException("create user error.");
        }
        log.info("createUser success. user info => {} \n user auth => {}", userInfo, userAuths);
        return true;
    }

    private boolean checkUserInfo(CreateUserVo createUserVo) {
        // todo
        return false;
    }

}
