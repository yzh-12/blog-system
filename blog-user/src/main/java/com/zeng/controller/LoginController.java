package com.zeng.controller;

import com.zeng.entities.vo.LoginVo;
import com.zeng.web.controller.BaseController;
import com.zeng.web.domain.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("user")
public class LoginController extends BaseController {

    @PostMapping("/login")
    public BaseResult<Object> login(LoginVo loginInfo) {
        return success();
    }
}
