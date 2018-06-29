package com.joinyon.githubapp.dagger.module;

import com.joinyon.githubapp.data.api.AccountApi;
import com.joinyon.githubapp.data.net.AccountDataSource;

import dagger.Module;
import dagger.Provides;

/**
 * 作者： JoinYon on 2018/6/28.
 * 邮箱：2816886869@qq.com
 */
@Module
public class AccountModule {
    @Provides
    AccountApi provideAccountApi(AccountDataSource dataSource) {
        return dataSource;
    }
}
