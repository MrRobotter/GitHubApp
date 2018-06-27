package com.joinyon.githubapp.ui.widget;

import android.app.AlertDialog;
import android.content.Context;

import dmax.dialog.SpotsDialog;

/**
 * 作者： JoinYon on 2018/6/26.
 * 邮箱：2816886869@qq.com
 */

public class LoadingView {
    private AlertDialog mLoadingDialog;

    public LoadingView(Context context, String message) {
        mLoadingDialog = new SpotsDialog(context, message);
    }

    public void show() {
        mLoadingDialog.show();
    }

    public void dismiss() {
        mLoadingDialog.dismiss();
    }
}
