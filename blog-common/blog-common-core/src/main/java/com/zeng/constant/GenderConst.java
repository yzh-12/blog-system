package com.zeng.constant;

public enum GenderConst implements BaseEnum {

    MALE(1, "男"), FEMALE(0, "女");

    private int key;
    private String value;

    GenderConst(int key, String value) {
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
