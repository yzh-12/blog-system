package com.zeng;

import com.zeng.feign.UserClient;
import com.zeng.web.domain.BaseResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class BlogJobApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BlogJobApplication.class);
        UserClient userClient = context.getBean(UserClient.class);
        BaseResult<Object> result = userClient.findUserInfoByUserId("123");
        System.out.println(result.toString());
    }
}
