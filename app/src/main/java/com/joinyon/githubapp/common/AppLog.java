package com.joinyon.githubapp.common;


import com.joinyon.githubapp.BuildConfig;
import com.orhanobut.logger.Logger;

/**
 * 作者： JoinYon on 2018/6/26.
 * 邮箱：2816886869@qq.com
 * <p>
 * 对Logger进行封装
 */

public class AppLog {
    private static final String TAG = "GitHubApp";

    /**
     * initialize the logger.
     */
    public static void init() {
        Logger.init(TAG);
    }

    /**
     * log.i
     *
     * @param msg
     */
    public static void i(String msg) {
        if (BuildConfig.DEBUG) {
            Logger.i(msg);
        }
    }

    /**
     * log.d
     *
     * @param msg
     */
    public static void d(String msg) {
        if (BuildConfig.DEBUG) {
            Logger.d(msg);
        }
    }

    /**
     * log.w
     *
     * @param msg
     */
    public static void w(String msg) {
        if (BuildConfig.DEBUG) {
            Logger.w(msg);
        }
    }

    /**
     * log.e
     *
     * @param msg
     */
    public static void e(String msg) {
        if (BuildConfig.DEBUG) {
            Logger.e(msg);
        }
    }

    public static void e(Throwable e) {
        Logger.e(e, "");
    }

}
