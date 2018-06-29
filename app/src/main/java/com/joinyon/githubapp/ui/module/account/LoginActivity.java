package com.joinyon.githubapp.ui.module.account;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;

import com.joinyon.githubapp.GitHubApplication;
import com.joinyon.githubapp.R;
import com.joinyon.githubapp.common.util.InputMethodUtils;
import com.joinyon.githubapp.dagger.HasComponent;
import com.joinyon.githubapp.dagger.component.AccountComponent;
import com.joinyon.githubapp.dagger.component.DaggerAccountComponent;
import com.joinyon.githubapp.dagger.module.AccountModule;
import com.joinyon.githubapp.dagger.module.ActivityModule;
import com.joinyon.githubapp.data.model.User;
import com.joinyon.githubapp.presenter.account.LoginPresenter;
import com.joinyon.githubapp.ui.base.BaseLoadingActivity;
import com.rey.material.widget.Button;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseLoadingActivity implements ILoginView, HasComponent<AccountComponent> {
    @BindView(R.id.icon)
    ImageView mIcon;

    @BindView(R.id.username)
    EditText mUsername;

    @BindView(R.id.password)
    EditText mPassword;

    @BindView(R.id.login_btn)
    Button mButton;

    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setTitle("登录");
        loginPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detachView();
    }

    public static void launch(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    public static void launchForResult(Activity activity) {
        activity.startActivityForResult(new Intent(activity, LoginActivity.class), 0);
    }

    @Override
    public String getLoadingMessage() {
        return "登录中……";
    }

    @OnClick(R.id.login_btn)
    public void onClick() {
        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();

        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            InputMethodUtils.hideSoftInput(this);
            loginPresenter.login(username, password);
        }
    }

    @Override
    public AccountComponent getComponent() {

        return DaggerAccountComponent.builder()
                .applicationComponent(GitHubApplication.get(this).getComponent())
                .activityModule(new ActivityModule(this))
                .accountModule(new AccountModule())
                .build();
    }

    @Override
    public void loginSuccess(User user) {
        Snackbar.make(mButton, "登录成功", Snackbar.LENGTH_LONG).show();

    }
}
