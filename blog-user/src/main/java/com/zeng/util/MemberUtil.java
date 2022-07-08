package com.zeng.util;

import com.zeng.utils.DateUtil;

import java.time.LocalDateTime;

public final class MemberUtil {
    public static final long ONE_MONTH = 30;

    public static final long HALF_MONTH = 15;

    public static LocalDateTime add30Days(LocalDateTime sourceTime) {
        return sourceTime.plusDays(ONE_MONTH);
    }

    public static LocalDateTime addAnyDays(LocalDateTime sourceTime, long days) {
        return sourceTime.plusDays(days);
    }

    public static void main(String[] args) {
        LocalDateTime now = DateUtil.getNowLocalDateTime();
        System.out.println(now);
        LocalDateTime after = MemberUtil.add30Days(now);
        System.out.println(String.format("now => %S \n after => %S", now, after));
    }
}
