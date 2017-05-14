package com.dolphin.util;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Demo {

    public static void main(String[] args) {
        // 日期格式转换
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // 当前日期
        Calendar instance = Calendar.getInstance();
        // 调整到上周
        instance.add(Calendar.WEDNESDAY, -1);
        // 调整到上周1
        instance.set(Calendar.DAY_OF_WEEK, 2);
        //循环打印
        for (int i = 1; i <= 5; i++) {
            System.out.println("星期" + i + ":" + format.format(instance.getTime()));
            instance.add(Calendar.DAY_OF_WEEK, 1);
        }
    }
}