package com.zeng.service.serviceImpl;

import cn.hutool.core.lang.Pair;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeng.dao.UserAuthsDao;
import com.zeng.dao.UserInfoDao;
import com.zeng.dao.UserRoleDao;
import com.zeng.entities.bo.RolePermissionBo;
import com.zeng.entities.bo.UserDetailInfoBo;
import com.zeng.entities.po.UserAuthsPo;
import com.zeng.entities.po.UserInfoPo;
import com.zeng.entities.po.UserRolePo;
import com.zeng.entities.vo.CreateUserVo;
import com.zeng.entities.vo.JoinVipVo;
import com.zeng.service.RoleResource;
import com.zeng.service.UserInfoService;
import com.zeng.util.ConvertUtil;
import com.zeng.utils.DateUtil;
import com.zeng.utils.ObjUtil;
import com.zeng.utils.PasswordUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoPo> implements UserInfoService {

    private RoleResource roleResource;
    private UserInfoDao userInfoDao;
    private UserAuthsDao userAuthsDao;
    private UserRoleDao userRoleDao;

    public UserInfoServiceImpl(RoleResource roleResource, UserInfoDao userInfoDao, UserAuthsDao userAuthsDao, UserRoleDao userRoleDao) {
        this.roleResource = roleResource;
        this.userInfoDao = userInfoDao;
        this.userAuthsDao = userAuthsDao;
        this.userRoleDao = userRoleDao;
    }

    @Override
    public UserInfoPo getUserInfoByUserId(String userId) {
        if (ObjUtil.equalsNull(userId)) {
            return null;
        }
        return this.getById(userId);
    }

    @Override
    public UserDetailInfoBo getUserDetailInfo(String userId) {
        if (ObjUtil.equalsNull(userId)) {
            return null;
        }
        UserInfoPo userInfo = this.getUserInfoByUserId(userId);
        RolePermissionBo roleResource = this.roleResource.getRoleResourceByUserId(userId);
        return createResult(userInfo, roleResource);
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
        if (checkUserInfo(createUserVo)) {
            throw new IllegalArgumentException("user name or email or phone number is used.");
        }
        Pair<UserInfoPo, UserAuthsPo> convertResult = ConvertUtil.convert(createUserVo);
        UserInfoPo userInfo = convertResult.getKey();
        UserAuthsPo userAuths = convertResult.getValue();
        int infoResult = userInfoDao.insert(userInfo);
        String userId = userInfo.getUserId();
        userAuths.setUserId(userId);
        userAuths.setCredential(PasswordUtil.hashpw(userAuths.getCredential()));
        int authsResult = userAuthsDao.insert(userAuths);

        //Assigning Roles
        UserRolePo userRole = new UserRolePo();
        userRole.setRoleId(createUserVo.getRole().key());
        userRole.setUserId(userId);
        LocalDateTime now = DateUtil.getNowLocalDateTime();
        userRole.setCreateTime(now);
        userRole.setUpdateTime(now);
        int userRoleResult = userRoleDao.insert(userRole);

        //determine whether it is successful
        if (infoResult != 1 && authsResult != 1 && userRoleResult != 1) {
            throw new RuntimeException("create user error.");
        }
        log.info("createUser success. user info => {} \n user auth => {}", userInfo, userAuths);
        return true;
    }

    @Override
    public boolean joinToVip(JoinVipVo joinVipVo) {
        UserRolePo updatePo = new UserRolePo();
        updatePo.setUserId(joinVipVo.getUserId());
        updatePo.setRoleId(joinVipVo.getRole().key());
        updatePo.setUpdateTime(DateUtil.getNowLocalDateTime());
        int result = userRoleDao.updateById(updatePo);
        if (result != 1) {
            throw new RuntimeException("join to vip error.");
        }
        return true;
    }

    private boolean checkUserInfo(CreateUserVo createUserVo) {
        String userName = createUserVo.getUserName();
        String phoneNumber = createUserVo.getPhoneNumber();
        String email = createUserVo.getEmail();
        int result = userInfoDao.countUserInfoRepeat(userName, phoneNumber, email);
        return result > 0 ? true : false;
    }

    private UserDetailInfoBo createResult(UserInfoPo userInfo, RolePermissionBo roleResource) {
        UserDetailInfoBo result = new UserDetailInfoBo();
        result.setRolePermissionInfo(roleResource);
        result.setUserId(userInfo.getUserId());
        result.setUserName(userInfo.getUserName());
        result.setNickName(userInfo.getNickName());
        result.setSex(userInfo.getSex());
        result.setPhoneNumber(userInfo.getPhoneNumber());
        result.setEmail(userInfo.getEmail());
        result.setAvatarUrl(userInfo.getAvatarUrl());
        result.setCreateTime(userInfo.getCreateTime());
        result.setUpdateTime(userInfo.getUpdateTime());
        return result;
    }

}
