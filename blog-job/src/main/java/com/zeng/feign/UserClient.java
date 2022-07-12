package com.zeng.feign;

import com.zeng.web.domain.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("blog-user")
public interface UserClient {

    @PostMapping("user/userinfo/userid")
    BaseResult<Object> findUserInfoByUserId(String userId);
}
