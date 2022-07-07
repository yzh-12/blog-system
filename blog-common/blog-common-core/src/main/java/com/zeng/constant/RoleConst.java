package com.zeng.constant;

public enum RoleConst implements BaseEnum {
    COMMON(1, "1", "普通用户"), VIP(2, "2", "会员"), SVIP(3, "3", "超级会员");

    private int index;
    private String key;
    private String value;

    RoleConst(int index, String key, String value) {
        this.index = index;
        this.key = key;
        this.value = value;
    }

    public String key() {
        return key;
    }

    public String value() {
        return value;
    }

    @Override
    public Integer getCode() {
        return this.index;
    }
}
