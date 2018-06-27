package com.joinyon.githubapp.common;

import android.content.Context;

import com.joinyon.githubapp.BuildConfig;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * 作者： JoinYon on 2018/6/26.
 * 邮箱：2816886869@qq.com
 * <p>
 * 崩溃搜集助手
 */

public class CrashHelper {
    public static void init(Context context) {
        AppLog.d("CrashHelp init");
        CrashReport.initCrashReport(context.getApplicationContext(), "dde5db9d06", BuildConfig.DEBUG);
    }

    public static void testCrash() {
        CrashReport.testJavaCrash();
    }

    public static void testANR() {
        CrashReport.testANRCrash();
    }
}
