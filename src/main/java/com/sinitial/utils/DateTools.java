package com.sinitial.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Akari on 2017/7/6.
 */
public class DateTools {
    /**
     * 将Date转化为String类型
     * @param date 时间
     * @param format 格式 yyyy-MM-dd HH-mm-ss
     * @return
     */
    public static String getStrByDate (Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    /**
     * 将String类型的时间转化为Date
     * @param dateStr String类型的时间
     * @param format 格式 yyyy-MM-dd HH-mm-ss
     * @return
     */
    public static Date getDateByStr (String dateStr, String format) {
        Date date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 生成当前精确到毫秒的时间加四位随机数组成的文件名
     * @param ext 文件后缀
     * @return
     */
    public static String getFileName (String ext) {
        String fileName = getStrByDate(new Date(),"yyyyMMddHHmmss");
        for (int i = 0; i< 4; i++) {
            fileName += (int)(Math.random()*10);
        }
        fileName += "." + ext;
        return fileName;
    }

    public static String getOrderId () {
        String orderId = getStrByDate(new Date(),"yyyyMMddHHmmss");
        for (int i = 0; i< 4; i++) {
            orderId += (int)(Math.random()*10);
        }
        return orderId;
    }
}
