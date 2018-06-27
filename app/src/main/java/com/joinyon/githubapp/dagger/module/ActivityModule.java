package com.joinyon.githubapp.dagger.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;


import com.joinyon.githubapp.dagger.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * 作者： JoinYon on 2018/6/26.
 * 邮箱：2816886869@qq.com
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    public ActivityModule(Fragment fragment) {
        mActivity = fragment.getActivity();
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }
}
