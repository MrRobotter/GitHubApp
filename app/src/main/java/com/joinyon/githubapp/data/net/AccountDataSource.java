package com.joinyon.githubapp.data.net;

import android.app.Application;

import com.joinyon.githubapp.common.GitHubConfig;
import com.joinyon.githubapp.data.api.AccountApi;
import com.joinyon.githubapp.data.model.User;
import com.joinyon.githubapp.data.net.client.GitHubAuthRetrofit;
import com.joinyon.githubapp.data.net.request.CreateAuthorization;
import com.joinyon.githubapp.data.net.response.AuthorizationResp;
import com.joinyon.githubapp.data.net.service.AccountService;
import com.joinyon.githubapp.data.pref.AccountPref;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * 作者： JoinYon on 2018/6/28.
 * 邮箱：2816886869@qq.com
 */

public class AccountDataSource implements AccountApi {
    @Inject
    GitHubAuthRetrofit mRetrofit;

    @Inject
    Application mContext;

    @Inject
    public AccountDataSource() {
    }

    @Override
    public Observable<User> login(String username, String password) {
        mRetrofit.setAuthInfo(username, password);
        final AccountService accountService = mRetrofit.get().create(AccountService.class);

        CreateAuthorization createAuthorization = new CreateAuthorization();
        createAuthorization.note = GitHubConfig.NOTE;
        createAuthorization.client_id = GitHubConfig.CLIENT_ID;
        createAuthorization.client_secret = GitHubConfig.CLIENT_SECRET;
        createAuthorization.scopes = GitHubConfig.SCOPES;

        return accountService.createAuthorization(createAuthorization)
                .flatMap(new Func1<AuthorizationResp, Observable<User>>() {
                    @Override
                    public Observable<User> call(AuthorizationResp authorizationResp) {

                        String token = authorizationResp.getToken();

                        // save token
                        AccountPref.saveLoginToken(mContext, token);

                        return accountService.getUserInfo(authorizationResp.getToken());
                    }
                });
    }
}
