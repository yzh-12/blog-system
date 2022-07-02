package com.zeng.utils;

import java.lang.management.ManagementFactory;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {
    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM" };

    /**
     * 获取当前LocalDate型日期
     *
     * @return LocalDate 当前日期
     */
    public static LocalDate getNowLocalDate() {
        return LocalDate.now();
    }

    /**
     * 获取当前LocalDateTime型日期
     *
     * @return LocalDateTime 当前日期
     */
    public static LocalDateTime getNowLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     *
     * @return String
     */
    public static String getLocalDate() {
        return dateTimeNow(YYYY_MM_DD);
    }

    public static final String getLocalDateTime() {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static final String localDateTimeNow() {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static final String dateTimeNow(String format) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
    }

    // public static final String localDateTimeNow(final String format) {
    // return parseDateToStr(format, new Date());
    // }

    // public static final String dateTime(final Date date) {
    // return parseDateToStr(YYYY_MM_DD, date);
    // }

    // public static final String parseLocalDateToStr(final String format, final
    // Date date) {
    // return new SimpleDateFormat(format).format(date);
    // }

    // public static final Date dateTime(final String format, final String ts) {
    // try {
    // return new SimpleDateFormat(format).parse(ts);
    // } catch (ParseException e) {
    // throw new RuntimeException(e);
    // }
    // }

    // /**
    // * 日期路径 即年/月/日 如2018/08/08
    // */
    // public static final String datePath() {
    // Date now = new Date();
    // return DateFormatUtils.format(now, "yyyy/MM/dd");
    // }

    // /**
    // * 日期路径 即年/月/日 如20180808
    // */
    // public static final String dateTime() {
    // Date now = new Date();
    // return DateFormatUtils.format(now, "yyyyMMdd");
    // }

    // /**
    // * 日期型字符串转化为日期 格式
    // */
    // public static Date parseDate(Object str) {
    // if (str == null) {
    // return null;
    // }
    // try {
    // return DateUtil.
    // } catch (ParseException e) {
    // return null;
    // }
    // }

    /**
     * 获取服务器启动时间
     */
    public static Date getServerStartDate() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }
}
