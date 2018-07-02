package com.joinyon.githubapp.ui.module.mine;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.joinyon.githubapp.R;
import com.joinyon.githubapp.common.ImageLoader;
import com.joinyon.githubapp.data.model.User;
import com.joinyon.githubapp.data.pref.AccountPref;
import com.joinyon.githubapp.data.pref.AppPref;
import com.joinyon.githubapp.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment {
    @BindView(R.id.user_icon)
    ImageView mUserIcon;

    @BindView(R.id.username)
    TextView mUsername;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_mine, null);
        ButterKnife.bind(this, contentView);
        getActivity().setTitle("个人信息");
        return contentView;
    }

    @Override
    public void onStart() {
        super.onStart();
        updateUser();
    }

    private void updateUser() {
        if (AccountPref.isLogin(getContext())) {
            User user = AccountPref.getLoginUser(getContext());
            ImageLoader.loadWithCircle(getContext(), user.getAvatar_url(), mUserIcon);
            String displayName = TextUtils.isEmpty(user.getName()) ? user.getLogin() : user.getName();
            mUsername.setText(displayName);
        } else {
            mUsername.setText("未登录");
        }

    }
}
