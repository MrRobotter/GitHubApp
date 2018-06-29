package com.joinyon.githubapp.data.pref;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 作者： JoinYon on 2018/6/28.
 * 邮箱：2816886869@qq.com
 */

public class AppPref {
    private static final String KEY_IS_FIRST_RUNNING = "is_first_running";

    private static SharedPreferences getPreference(Context context) {
        return context.getSharedPreferences("com.joinyon.githubapp.app_preference", Context.MODE_PRIVATE);
    }

    public static void setAlreadyRun(Context context) {
        getPreference(context).edit().putBoolean(KEY_IS_FIRST_RUNNING, false).apply();
    }

    public static boolean isFirstRunning(Context context) {
        return getPreference(context).getBoolean(KEY_IS_FIRST_RUNNING, true);
    }
}
