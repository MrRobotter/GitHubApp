package com.joinyon.githubapp.mvp.lce;

import android.support.annotation.UiThread;

import com.joinyon.githubapp.mvp.MvpView;

/**
 * 作者： JoinYon on 2018/6/26.
 * 邮箱：2816886869@qq.com
 */

public interface LoadView extends MvpView {
    @UiThread
    void showLoading();

    @UiThread
    void dismissLoading();

    @UiThread
    void error(Throwable e);
}
