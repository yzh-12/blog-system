package com.zeng.controller;

import com.zeng.entities.vo.LoginVo;
import com.zeng.service.UserAuthsService;
import com.zeng.web.controller.BaseController;
import com.zeng.web.domain.BaseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class LoginController extends BaseController {

    private UserAuthsService userAuthsService;

    public LoginController(UserAuthsService userAuthsService) {
        this.userAuthsService = userAuthsService;
    }

    @GetMapping("/login")
    public BaseResult<Object> login(@RequestBody LoginVo loginInfo) {
        String result = userAuthsService.login(loginInfo);
        return !result.isEmpty() ? success("login success.", result) : error("login error.", result);
    }

    @GetMapping("/logout")
    public BaseResult<Object> logout() {
        boolean result = userAuthsService.logout();
        return result ? success("logout success.", true) : error("logout error.", false);
    }
}
