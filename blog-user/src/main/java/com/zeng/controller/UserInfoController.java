package com.zeng.controller;

import com.zeng.entities.po.UserInfoPo;
import com.zeng.service.UserInfoService;
import com.zeng.web.controller.BaseController;
import com.zeng.web.domain.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("user")
public class UserInfoController extends BaseController {

    private UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("userinfo/{userId}")
    public BaseResult<Object> findUserInfoByUserId(@PathVariable("userId") String userId) {
        log.info("request success. userId => {}", userId);
        return success();
    }

    @PostMapping("userinfo")
    public BaseResult<Integer> createUserInfo(@RequestBody UserInfoPo userInfo) {
        int result = userInfoService.addUserInfo(userInfo);
        return success("create user info success.", result);
    }

}
