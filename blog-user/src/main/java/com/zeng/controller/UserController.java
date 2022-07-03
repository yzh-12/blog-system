package com.zeng.controller;

import com.zeng.entities.vo.CreateUserVo;
import com.zeng.service.UserInfoService;
import com.zeng.web.controller.BaseController;
import com.zeng.web.domain.BaseResult;
import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    private UserInfoService userInfoService;

    public UserController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("userinfo/{userId}")
    public BaseResult<Object> findUserInfoByUserId(@PathVariable("userId") String userId) {
        log.info("request success. userId => {}", userId);
        return success();
    }

    @PostMapping("user")
    public BaseResult<Object> createUser(@RequestBody @Validated CreateUserVo createUserVo) {
        boolean result = userInfoService.createUser(createUserVo);
        return result ? success("create user success.") : error("create user error.");
    }

}
