package com.joinyon.githubapp.ui.module.account;

import com.joinyon.githubapp.data.model.User;
import com.joinyon.githubapp.mvp.lce.LoadView;

/**
 * 作者： JoinYon on 2018/6/28.
 * 邮箱：2816886869@qq.com
 */

public interface ILoginView extends LoadView {

    void loginSuccess(User user);
}
