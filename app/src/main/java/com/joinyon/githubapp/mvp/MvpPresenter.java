package com.joinyon.githubapp.mvp;

import android.support.annotation.UiThread;

/**
 * 作者： JoinYon on 2018/6/26.
 * 邮箱：2816886869@qq.com
 */

public interface MvpPresenter<V extends MvpView> {
    /**
     * 将view 和 此presenter关联
     *
     * @param view
     */
    @UiThread
    void attachView(V view);

    /**
     * 当view销毁时会被调用，通常在以下方法中会被调用
     * <code>Activity.detachView()</code>或者<code>Fragment.onDestroyView()</code>
     */
    @UiThread
    void detachView();
}
