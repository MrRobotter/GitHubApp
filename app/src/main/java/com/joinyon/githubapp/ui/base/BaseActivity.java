package com.joinyon.githubapp.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;

import com.joinyon.githubapp.GitHubApplication;
import com.joinyon.githubapp.dagger.component.ActivityComponent;
import com.joinyon.githubapp.dagger.component.DaggerActivityComponent;
import com.joinyon.githubapp.dagger.module.ActivityModule;
import com.mikepenz.iconics.context.IconicsLayoutInflater;

/**
 * 作者： JoinYon on 2018/6/26.
 * 邮箱：2816886869@qq.com
 */

public class BaseActivity extends AppCompatActivity {
    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
        super.onCreate(savedInstanceState);
    }

    public ActivityComponent getActivityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent
                    .builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(GitHubApplication.get(this).getComponent())
                    .build();
        }
        return mActivityComponent;
    }
}
