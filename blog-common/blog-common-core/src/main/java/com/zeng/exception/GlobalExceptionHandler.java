package com.zeng.exception;

import cn.dev33.satoken.exception.NotLoginException;
import com.zeng.web.domain.BaseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public BaseResult<Object> handlerException(Exception e) {
        e.printStackTrace();
        return BaseResult.error(e.getMessage());
    }


    @ExceptionHandler(NotLoginException.class)
    public BaseResult<Object> handlerNotLoginException(NotLoginException e) throws Exception {
        e.printStackTrace();
        String message = "";
        if (e.getType().equals(NotLoginException.NOT_TOKEN)) {
            message = "未提供token";
        } else if (e.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "token无效";
        } else if (e.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            message = "token已过期";
        } else if (e.getType().equals(NotLoginException.BE_REPLACED)) {
            message = "token已被顶下线";
        } else if (e.getType().equals(NotLoginException.KICK_OUT)) {
            message = "token已被踢下线";
        } else {
            message = "当前会话未登录";
        }
        return BaseResult.error(e.getMessage(), message);
    }

}
