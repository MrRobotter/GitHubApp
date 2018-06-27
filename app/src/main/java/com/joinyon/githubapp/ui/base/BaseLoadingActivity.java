package com.joinyon.githubapp.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;

import com.joinyon.githubapp.mvp.lce.LoadView;
import com.joinyon.githubapp.ui.widget.LoadingView;

/**
 * 作者： JoinYon on 2018/6/26.
 * 邮箱：2816886869@qq.com
 */

public abstract class BaseLoadingActivity extends BaseActivity implements LoadView {
    private LoadingView mLoadingView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoadingView = new LoadingView(this, getLoadingMessage());
    }

    @Override
    public void showLoading() {
        mLoadingView.show();
    }

    @Override
    public void dismissLoading() {
        mLoadingView.dismiss();
    }

    public abstract String getLoadingMessage();

    @Override
    public void error(Throwable e) {
        Snackbar.make(getWindow().getDecorView(), e.getMessage(), Snackbar.LENGTH_LONG).show();
    }
}
