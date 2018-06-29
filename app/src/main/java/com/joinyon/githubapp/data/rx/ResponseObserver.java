package com.joinyon.githubapp.data.rx;

import com.joinyon.githubapp.common.AppLog;

import rx.Subscriber;

/**
 * 作者： JoinYon on 2018/6/27.
 * 邮箱：2816886869@qq.com
 */

public abstract class ResponseObserver<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {
        AppLog.d("onCompleted");
    }

    @Override
    public void onNext(T t) {
        AppLog.d("onNext");
        onSuccess(t);
    }

    public abstract void onSuccess(T t);
}
