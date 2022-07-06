package com.zeng.config;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import com.zeng.constant.BaseEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaRouteInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/login");
    }


    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(new ConverterFactory<Object, BaseEnum>() {
            @Override
            public <T extends BaseEnum> Converter<Object, T> getConverter(Class<T> targetType) {
                T[] enums = targetType.getEnumConstants();

                return source -> {
                    for (T t : enums) {
                        if (t.getCode().equals(source)) {
                            return t;
                        }
                    }
                    throw new IllegalArgumentException("enums code is not correct.");
                };
            }
        });
    }
}
