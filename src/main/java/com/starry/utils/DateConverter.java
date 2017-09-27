package com.starry.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {

    /**
     * 配合Spring-mvc使用
     */
    @Override
    public Date convert(String source) {
        String pattern = source.length()==10 ? "yyyy-MM-dd" : "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
