package com.zeng.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zeng.constant.BaseEnum;

@Configuration
public class WebConfig implements WebMvcConfigurer {

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
