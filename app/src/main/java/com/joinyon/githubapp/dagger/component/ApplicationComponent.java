package com.joinyon.githubapp.dagger.component;

import android.app.Application;
import android.content.Context;

import com.joinyon.githubapp.dagger.ApplicationContext;
import com.joinyon.githubapp.dagger.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 作者： JoinYon on 2018/6/26.
 * 邮箱：2816886869@qq.com
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context context();

    Application application();
}
