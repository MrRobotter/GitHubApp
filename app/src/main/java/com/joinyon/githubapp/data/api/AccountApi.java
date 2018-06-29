package com.joinyon.githubapp.data.api;

import com.joinyon.githubapp.data.model.User;

import rx.Observable;

/**
 * 作者： JoinYon on 2018/6/28.
 * 邮箱：2816886869@qq.com
 */

public interface AccountApi {
    Observable<User> login(String username, String password);
}
