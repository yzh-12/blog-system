package com.zeng.web.controller;

import com.zeng.web.domain.BaseResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;

public class BaseController {

    @InitBinder
    void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(LocalDateTime.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(LocalDateTime.parse(text));
            }
        });
    }

    public static BaseResult<Object> success() {
        return BaseResult.success("operation success.");
    }

    public static BaseResult<Object> success(String msg) {
        return BaseResult.success(msg);
    }

    public static <T> BaseResult<T> success(String msg, T data) {
        return BaseResult.success(msg, data);
    }

    public static BaseResult<Object> error() {
        return BaseResult.error("operation fail.");
    }

    public static BaseResult<Object> error(String msg) {
        return BaseResult.error(msg);
    }

    public static <T> BaseResult<T> error(String msg, T data) {
        return BaseResult.error(msg, data);
    }

}
