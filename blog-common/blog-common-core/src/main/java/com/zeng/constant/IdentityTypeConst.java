package com.zeng.constant;

public enum IdentityTypeConst implements BaseEnum {

    USERNAME_PASSWORD(0, "用户名密码"), WECHAT(1, "微信");

    private int key;
    private String value;

    IdentityTypeConst(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public int key() {
        return this.key;
    }

    @Override
    public Integer getCode() {
        return this.key;
    }
}
