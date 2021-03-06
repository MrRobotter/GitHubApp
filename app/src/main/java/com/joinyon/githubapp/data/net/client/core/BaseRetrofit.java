package com.joinyon.githubapp.data.net.client.core;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者： JoinYon on 2018/6/27.
 * 邮箱：2816886869@qq.com
 */

public abstract class BaseRetrofit {
    public Retrofit get() {
        Retrofit.Builder builder = new Retrofit.Builder();

        builder.baseUrl(getApiEndpoint().getEndpoint())
                .client(getHttpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

        return builder.build();
    }

    public abstract ApiEndpoint getApiEndpoint();
    public abstract OkHttpClient getHttpClient();
}
