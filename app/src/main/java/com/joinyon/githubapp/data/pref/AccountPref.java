package com.joinyon.githubapp.data.pref;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.joinyon.githubapp.data.model.User;

/**
 * 作者： JoinYon on 2018/6/27.
 * 邮箱：2816886869@qq.com
 */

public class AccountPref {
    private static final String KEY_LOGIN_TOKEN = "login_token";
    private static final String KEY_LOGIN_USER = "login_user";

    private static SharedPreferences getPreference(Context context) {
        return context.getApplicationContext().getSharedPreferences("com.joinyon.githubapp.account_preference.xml", Context.MODE_PRIVATE);
    }

    /**
     * 保存login token
     *
     * @param context
     * @param loginToken
     */
    public static void saveLoginToken(Context context, String loginToken) {
        getPreference(context).edit().putString(KEY_LOGIN_TOKEN, loginToken).apply();
    }

    public static String getLoginToken(Context context) {
        return getPreference(context).getString(KEY_LOGIN_TOKEN, "");
    }

    public static void saveLoginUser(Context context, User user) {
        String userJson = new Gson().toJson(user);
        getPreference(context).edit().putString(KEY_LOGIN_USER, userJson).apply();
    }

    public static void removeLoginUser(Context context) {
        getPreference(context).edit().remove(KEY_LOGIN_USER).apply();
    }

    public static User getLoginUser(Context context) {
        User user = null;
        String userJson = getPreference(context).getString(KEY_LOGIN_USER, "");
        if (!TextUtils.isEmpty(userJson)) {
            user = new Gson().fromJson(userJson, User.class);
        }
        return user;
    }

    public static boolean isLogin(Context context) {
        return !TextUtils.isEmpty(getLoginToken(context)) && getLoginUser(context) != null;
    }

}
