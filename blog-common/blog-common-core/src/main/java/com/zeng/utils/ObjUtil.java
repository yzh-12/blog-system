package com.zeng.utils;

public final class ObjUtil {


    public static boolean equalsNull(Object paramObject) {
        return paramObject == null || paramObject.equals("") || paramObject.equals("null");
    }
}
