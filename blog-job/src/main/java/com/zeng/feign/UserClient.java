package com.zeng.feign;

import com.zeng.feign.po.UserRolePo;
import com.zeng.web.domain.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("blog-user")
public interface UserClient {

    @PostMapping("user/userinfo/userid")
    BaseResult<Object> findUserInfoByUserId(String userId);

    @PostMapping("user/expiration")
    BaseResult<List<UserRolePo>> findExpirationUser(int expirationDay);
}
