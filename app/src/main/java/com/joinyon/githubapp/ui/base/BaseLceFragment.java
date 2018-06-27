package com.joinyon.githubapp.ui.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.joinyon.githubapp.R;
import com.joinyon.githubapp.mvp.lce.LceView;

/**
 * 作者： JoinYon on 2018/6/26.
 * 邮箱：2816886869@qq.com
 */

public abstract class BaseLceFragment<M> extends BaseFragment implements LceView<M> {
    private LinearLayout mContentView;
    private RelativeLayout mEmptyView;
    private RelativeLayout mErrorView;
    private RelativeLayout mLoadingView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View baseView = inflater.inflate(R.layout.layout_ice_container, null);
        mContentView = baseView.findViewById(R.id.content_frame);
        mContentView.removeAllViews();
        mContentView.addView(inflater.inflate(getContentView(), null), new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mEmptyView = baseView.findViewById(R.id.empty_root_layout);
        mErrorView = baseView.findViewById(R.id.error_root_layout);
        mErrorView.findViewById(R.id.retry_btn).setOnClickListener(getRetryListener());
        mLoadingView = baseView.findViewById(R.id.loading_root_layout);
        return baseView;
    }

    public abstract int getContentView();

    public abstract View.OnClickListener getRetryListener();

    @Override
    public void showLoading() {
        mContentView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.GONE);
        mEmptyView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissLoading() {
        mLoadingView.setVisibility(View.GONE);
    }

    @CallSuper
    @Override
    public void showContent(M data) {
        dismissLoading();
        mEmptyView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.GONE);
        mContentView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(Throwable e) {
        dismissLoading();
        mContentView.setVisibility(View.GONE);
        mEmptyView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showEmpty() {
        dismissLoading();
        mContentView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.GONE);
        mEmptyView.setVisibility(View.VISIBLE);
    }
}
