package com.joinyon.githubapp.mvp.lce;

import android.support.annotation.UiThread;

import com.joinyon.githubapp.mvp.MvpView;

/**
 * 作者： JoinYon on 2018/6/26.
 * 邮箱：2816886869@qq.com
 */

public interface LceView<M> extends MvpView {
    /**
     * 显示加载状态
     */
    @UiThread
    void showLoading();

    /**
     * 隐藏加载状态
     */

    @UiThread
    void dismissLoading();

    /**
     * 展示内容
     *
     * @param data 内容实体
     */

    @UiThread
    void showContent(M data);

    /**
     * 显示错误
     *
     * @param e 错误原因
     */
    @UiThread
    void showError(Throwable e);

    /**
     * 显示空内容
     */
    @UiThread
    void showEmpty();
}
