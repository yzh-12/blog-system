package com.zeng.controller;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import com.zeng.entities.bo.UserDetailInfoBo;
import com.zeng.entities.po.UserInfoPo;
import com.zeng.entities.vo.CreateUserVo;
import com.zeng.entities.vo.JoinVipVo;
import com.zeng.service.UserInfoService;
import com.zeng.utils.ObjUtil;
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

    @GetMapping("userinfo/userid")
    public BaseResult<UserInfoPo> findUserInfoByUserId(@RequestBody String userId) {
        UserInfoPo result = userInfoService.getUserInfoByUserId(userId);
        return success("find user info success.", result);
    }

    @GetMapping("userinfo")
    public BaseResult<UserInfoPo> findUserInfo() {
        SaSession session = StpUtil.getSession();
        String userId = session.get("user_id", null);
        UserInfoPo result = userInfoService.getUserInfoByUserId(userId);
        return success("find user info success.", result);
    }

    @GetMapping("userinfo/detailinfo")
    public BaseResult<Object> findUserDetailInfo() {
        SaSession session = StpUtil.getSession();
        String userId = session.get("user_id", null);
        UserDetailInfoBo userDetailInfo = userInfoService.getUserDetailInfo(userId);
        return success("find user detail info success.", userDetailInfo);
    }

    @PostMapping("user")
    public BaseResult<Object> createUser(@RequestBody @Validated CreateUserVo createUserVo) {
        boolean result = userInfoService.createUser(createUserVo);
        return result ? success("create user success.") : error("create user error.");
    }

    @PutMapping("user")
    public BaseResult<String> joinToVip(@RequestBody @Validated JoinVipVo joinVipVo) {
        return BaseResult.success(joinVipVo.toString());
//        if (ObjUtil.equalsNull(joinVipVo.getUserId())) {
//            SaSession session = StpUtil.getSession();
//            joinVipVo.setUserId(session.get("user_id", null));
//        }
//        boolean result = userInfoService.joinToVip(joinVipVo);
//        return result ? success("joinToVip success.") : error("joinToVip error.");
    }

}
