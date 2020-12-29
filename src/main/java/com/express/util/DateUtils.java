package com.express.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间类型工具类
 * @author Rock
 * @email cool_fish@aliyun.com
 * @date 2020-12-28
 */
public class DateUtils {

    public static Date stringToDate(String time) {
        // 日期格式
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
