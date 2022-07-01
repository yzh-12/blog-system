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

    public static BaseResult success() {
        return BaseResult.success("operation success.");
    }

    public static BaseResult success(String msg) {
        return BaseResult.success(msg);
    }

    public static BaseResult error() {
        return BaseResult.error("operation fail.");
    }

    public static BaseResult error(String msg) {
        return BaseResult.error(msg);
    }


}
