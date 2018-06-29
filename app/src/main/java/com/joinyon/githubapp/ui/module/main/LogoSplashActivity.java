package com.joinyon.githubapp.ui.module.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.joinyon.githubapp.common.AppLog;
import com.joinyon.githubapp.ui.base.BaseActivity;

/**
 * 作者： JoinYon on 2018/6/28.
 * 邮箱：2816886869@qq.com
 */

public class LogoSplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppLog.d("LogoSplashActivity onCreate");
//        if (AppPref.isFirstRunning(this)) {
//
//        } else {
//        }
        MainActivity.launch(this);

        finish();
    }
}
