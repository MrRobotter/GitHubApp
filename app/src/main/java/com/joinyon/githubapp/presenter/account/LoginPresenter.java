package com.joinyon.githubapp.presenter.account;

import android.app.Application;

import com.joinyon.githubapp.common.AppLog;
import com.joinyon.githubapp.data.rx.ResponseObserver;
import com.joinyon.githubapp.data.api.AccountApi;
import com.joinyon.githubapp.data.model.User;
import com.joinyon.githubapp.presenter.base.RxMVpPresenter;
import com.joinyon.githubapp.ui.module.account.ILoginView;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 作者： JoinYon on 2018/6/28.
 * 邮箱：2816886869@qq.com
 */

public class LoginPresenter extends RxMVpPresenter<ILoginView> {
    private final AccountApi mAccountApi;

    @Inject
    public LoginPresenter(AccountApi accountApi) {
        this.mAccountApi = accountApi;
    }

    @Inject
    Application mContext;

    public void login(final String username, String password) {
        mCompositeSubscription.add(mAccountApi.login(username, password)
                .subscribeOn(Schedulers.io())//
                .observeOn(AndroidSchedulers.mainThread())//
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        getmMvpView().showLoading();
                    }
                })
                .doOnTerminate(new Action0() {
                    @Override
                    public void call() {
                        getmMvpView().dismissLoading();
                    }
                })
                .subscribe(new ResponseObserver<User>() {
                    @Override
                    public void onSuccess(User user) {
                        AppLog.e("user=" + user.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        AppLog.e(e);
                        getmMvpView().error(e);

                    }
                })
        );
    }
}
