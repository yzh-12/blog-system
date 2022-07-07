package com.zeng.config.web;

import com.zeng.constant.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

@Component
public final class IntegerToBaseEnumConverterFactory implements ConverterFactory<Integer, BaseEnum> {
    @Override
    public <T extends BaseEnum> Converter<Integer, T> getConverter(Class<T> targetType) {
        return new IntegerToBaseEnum(targetType);
    }

    private static class IntegerToBaseEnum<T extends BaseEnum> implements Converter<Integer, T> {
        private final Class<T> enumType;

        private IntegerToBaseEnum(Class<T> enumType) {
            this.enumType = enumType;
        }

        @Override
        public T convert(Integer source) {
            if (source == null) {
                return null;
            }
            T[] enums = enumType.getEnumConstants();
            for (T t : enums) {
                if (t.getCode() == source) {
                    return t;
                }
            }
            throw new IllegalArgumentException("no enum constant error.");
        }
    }
}
