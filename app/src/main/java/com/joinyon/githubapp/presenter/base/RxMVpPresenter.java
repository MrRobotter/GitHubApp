package com.joinyon.githubapp.presenter.base;

import com.joinyon.githubapp.mvp.BaseMvpPresenter;
import com.joinyon.githubapp.mvp.MvpView;

import rx.subscriptions.CompositeSubscription;

/**
 * 作者： JoinYon on 2018/6/28.
 * 邮箱：2816886869@qq.com
 */

public class RxMVpPresenter<V extends MvpView> extends BaseMvpPresenter<V> {
    protected CompositeSubscription mCompositeSubscription;

    @Override
    public void attachView(V view) {
        super.attachView(view);
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        super.detachView();
        mCompositeSubscription.clear();
        mCompositeSubscription = null;
    }
}
