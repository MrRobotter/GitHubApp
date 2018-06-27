package com.joinyon.githubapp;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.joinyon.githubapp.common.AppLog;
import com.joinyon.githubapp.compz.InitializeService;
import com.joinyon.githubapp.dagger.component.ApplicationComponent;
import com.joinyon.githubapp.dagger.component.DaggerApplicationComponent;
import com.joinyon.githubapp.dagger.module.ApplicationModule;

/**
 * 作者： JoinYon on 2018/6/26.
 * 邮箱：2816886869@qq.com
 */

public class GitHubApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        // init logger.
        AppLog.init();

        InitializeService.start(this);
    }

    public static GitHubApplication get(Context context) {
        return (GitHubApplication) context.getApplicationContext();
    }

    ApplicationComponent mApplicationComponent;

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent
                    .builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
