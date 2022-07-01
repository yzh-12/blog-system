package com.zeng.controller;

import com.zeng.entities.po.UserInfoPo;
import com.zeng.web.controller.BaseController;
import com.zeng.web.domain.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("user")
public class UserInfoController extends BaseController {

    @GetMapping("userinfo/{userId}")
    public BaseResult<UserInfoPo> findUserInfoByUserId(@PathVariable("userId") String userId) {
        log.info("request success. userId => {}", userId);
        return success();
    }

}
