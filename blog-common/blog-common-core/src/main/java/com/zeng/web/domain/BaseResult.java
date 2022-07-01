package com.zeng.web.domain;

import com.zeng.constant.HttpStatus;

import java.io.Serializable;

public class BaseResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    public static final String CODE_TAG = "code";

    /**
     * 返回内容
     */
    public static final String MSG_TAG = "msg";

    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";

    private int code;

    private String msg;

    private T data;

    public BaseResult() {
    }

    public BaseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> BaseResult<T> success(String msg) {
        return success(msg, null);
    }


    public static <T> BaseResult<T> success(String msg, T data) {
        return new BaseResult<>(HttpStatus.SUCCESS, msg, data);
    }

    public static <T> BaseResult<T> error() {
        return error(null, null);
    }

    public static <T> BaseResult<T> error(String msg) {
        return error(msg, null);
    }

    public static <T> BaseResult<T> error(int code, String msg) {
        return new BaseResult<>(code, msg, null);
    }

    public static <T> BaseResult<T> error(String msg, T data) {
        return new BaseResult<>(HttpStatus.ERROR, msg, data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
