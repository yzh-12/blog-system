package com.zeng.exception;

public class BusinessException extends GlobalException{


    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }
}
