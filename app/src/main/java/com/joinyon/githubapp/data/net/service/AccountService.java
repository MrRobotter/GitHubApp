package com.joinyon.githubapp.data.net.service;

import com.joinyon.githubapp.data.model.User;
import com.joinyon.githubapp.data.net.request.CreateAuthorization;
import com.joinyon.githubapp.data.net.response.AuthorizationResp;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者： JoinYon on 2018/6/28.
 * 邮箱：2816886869@qq.com
 */

public interface AccountService {
    @POST("/authorizations")
    Observable<AuthorizationResp> createAuthorization(
            @Body CreateAuthorization createAuthorization);

    @GET("/user")
    Observable<User> getUserInfo(@Query("access_token") String accessToken);
}
