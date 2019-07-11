package com.wallychen.ssm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @author ChenYZ
 * @version  1.0.0
 * @create 2019/6/21
 */
public class DateUtils {

    /**
     * @description 日期转成字符串
     * @params [date, patt]
     * @return java.lang.String
     * @author ChenYZ
     * @date 2019/6/21 11:14
     */
    public static String date2String(Date date,String patt){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }

    /**
     * @description 字符串转换成日期
     * @params [str, patt]
     * @return java.util.Date
     * @author ChenYZ
     * @date 2019/6/21 11:16
     */
    public static Date string2Date(String str,String patt) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse = sdf.parse(str);
        return parse;
    }

}
