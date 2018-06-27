package com.joinyon.githubapp.dagger.module;

import android.app.Application;
import android.content.Context;

import com.joinyon.githubapp.dagger.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * 作者： JoinYon on 2018/6/26.
 * 邮箱：2816886869@qq.com
 */
@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }


}
