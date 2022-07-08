package com.zeng;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableEurekaClient
@MapperScan("com.zeng.dao")
public class BlogUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogUserApplication.class);
    }
}
