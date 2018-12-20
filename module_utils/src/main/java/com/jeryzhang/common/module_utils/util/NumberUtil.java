package com.jeryzhang.common.module_utils.util;

import android.content.Context;

import java.math.BigDecimal;
import java.util.Locale;

public class NumberUtil {
    public static String formatInt(Context context, long num) {
        if (num > 10000) {
            return String.format(Locale.CHINA, "%d万", num / 10000);
        }
        return String.valueOf(num);
    }

    public static String format2String(long number) {
        if (number <= 0) {
            return "0";
        } else if (number < 10000) {
            return String.valueOf(number);
        } else {
            double d = (double) number;
            double num = d / 10000;

            BigDecimal b = new BigDecimal(num);
            double f1 = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
            return f1 + "万";
        }
    }
}
