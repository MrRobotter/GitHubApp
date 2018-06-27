package com.joinyon.githubapp.dagger.component;

import com.joinyon.githubapp.dagger.PerActivity;
import com.joinyon.githubapp.dagger.module.ActivityModule;

import dagger.Component;

/**
 * 作者： JoinYon on 2018/6/27.
 * 邮箱：2816886869@qq.com
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface MainComponent extends ActivityComponent {

}
