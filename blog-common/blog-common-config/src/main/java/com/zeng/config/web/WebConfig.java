package com.zeng.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 该配置 只支持 不从请求体反序列化成 枚举类型的情况
 */
@Configuration(value = "webConfiguration")
public class WebConfig implements WebMvcConfigurer {

    private IntegerToBaseEnumConverterFactory integerToBaseEnumConverterFactory;

    public WebConfig(IntegerToBaseEnumConverterFactory integerToBaseEnumConverterFactory) {
        this.integerToBaseEnumConverterFactory = integerToBaseEnumConverterFactory;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(this.integerToBaseEnumConverterFactory);
    }
}
