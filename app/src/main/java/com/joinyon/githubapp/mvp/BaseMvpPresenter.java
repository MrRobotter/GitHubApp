package com.joinyon.githubapp.mvp;

/**
 * 作者： JoinYon on 2018/6/26.
 * 邮箱：2816886869@qq.com
 */

public class BaseMvpPresenter<V extends MvpView> implements MvpPresenter<V> {
    private V mMvpView;

    @Override
    public void attachView(V view) {
        mMvpView = view;

    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    private boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getmMvpView() {
        return mMvpView;
    }

    public void checkViewAttatched() {
        if (!isViewAttached()) {
            throw new MvpViewNotAttachedException();
        }
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        private MvpViewNotAttachedException() {
            super("在使用Presenter请求数据前请先调用" + "Presenter.attachView(MvpView)方法");
        }
    }
}
