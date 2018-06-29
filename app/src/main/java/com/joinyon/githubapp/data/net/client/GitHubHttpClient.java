package com.joinyon.githubapp.data.net.client;

import android.app.Application;

import com.joinyon.githubapp.data.pref.AccountPref;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 作者： JoinYon on 2018/6/27.
 * 邮箱：2816886869@qq.com
 */

public class GitHubHttpClient extends CacheHttpClient {
    @Inject
    public Application application;

    @Inject
    public GitHubHttpClient() {
    }

    public String getAcceptHeader() {
        return "application/vnd.github.v3.json";
    }

    @Override
    public OkHttpClient.Builder customize(OkHttpClient.Builder builder) {
        builder = super.customize(builder);

        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        .header("Accept", getAcceptHeader())
                        .header("User-Agent", "GithubApp");

                if (AccountPref.isLogin(application)) {
                    requestBuilder
                            .header("Authorization", "token " + AccountPref.getLoginToken(application));
                }

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        return builder;
    }
}
