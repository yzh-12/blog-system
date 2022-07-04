package com.zeng.controller;

import com.zeng.entities.po.UserInfoPo;
import com.zeng.entities.vo.CreateUserVo;
import com.zeng.service.UserInfoService;
import com.zeng.web.controller.BaseController;
import com.zeng.web.domain.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    private UserInfoService userInfoService;

    public UserController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("userinfo")
    public BaseResult<Object> findUserInfoByUserId(@RequestBody String userId) {
        UserInfoPo result = userInfoService.getUserInfoByUserId(userId);
        return success("find user info success.", result);
    }

    @PostMapping("user")
    public BaseResult<Object> createUser(@RequestBody @Validated CreateUserVo createUserVo) {
        boolean result = userInfoService.createUser(createUserVo);
        return result ? success("create user success.") : error("create user error.");
    }

}
