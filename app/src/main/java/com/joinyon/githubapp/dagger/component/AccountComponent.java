package com.joinyon.githubapp.dagger.component;

import com.joinyon.githubapp.dagger.PerActivity;
import com.joinyon.githubapp.dagger.module.AccountModule;
import com.joinyon.githubapp.dagger.module.ActivityModule;
import com.joinyon.githubapp.ui.module.account.LoginActivity;

import dagger.Component;

/**
 * 作者： JoinYon on 2018/6/28.
 * 邮箱：2816886869@qq.com
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, AccountModule.class})
public interface AccountComponent extends ActivityComponent {
    void inject(LoginActivity loginActivity);

}
