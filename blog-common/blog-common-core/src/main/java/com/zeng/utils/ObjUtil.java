package com.zeng.utils;

public final class ObjUtil {

    public static boolean equalsNull(Object... args) {
        for (Object arg : args) {
            if (!equalsNull(arg)) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsNull(Object paramObject) {
        return paramObject == null || paramObject.equals("") || paramObject.equals("null");
    }
}
