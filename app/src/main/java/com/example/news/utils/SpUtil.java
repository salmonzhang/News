package com.example.news.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * author:salmonzhang
 * Description:
 * Date:2018/2/7 0007 22:38
 */

public class SpUtil {

    public static final String CONFIG = "config";
    private static SharedPreferences sSp;

    //保存boolean值
    public static void saveBoolean(Context context, String key, boolean value) {
        if (sSp == null) {
            sSp = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        sSp.edit().putBoolean(key, value).commit();
    }

    //获取boolean值
    public static boolean getBoolean(Context context, String key, boolean defValue){
        if (sSp == null) {
            sSp = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
        }
        return sSp.getBoolean(key, defValue);
    }
}
