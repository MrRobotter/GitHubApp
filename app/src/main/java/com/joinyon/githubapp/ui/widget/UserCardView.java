package com.joinyon.githubapp.ui.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.joinyon.githubapp.R;
import com.joinyon.githubapp.common.ImageLoader;
import com.joinyon.githubapp.data.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者： JoinYon on 2018/7/2.
 * 邮箱：2816886869@qq.com
 */
public class UserCardView extends FrameLayout {
    @BindView(R.id.user_icon)
    ImageView mUserIcon;
    @BindView(R.id.username)
    TextView mUsername;
    @BindView(R.id.bio)
    TextView mBio;
    @BindView(R.id.company)
    TextView mCompany;
    @BindView(R.id.location)
    TextView mLocation;
    @BindView(R.id.blog)
    TextView mBlog;
    @BindView(R.id.email)
    TextView mEmail;

    public UserCardView(@NonNull Context context) {
        super(context);
        init();
    }

    public UserCardView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public UserCardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.user_card_view, this);
        ButterKnife.bind(this);
    }

    public void setUser(User user) {
        ImageLoader.loadWithCircle(getContext(), user.getAvatar_url(), mUserIcon);
        String displayName = TextUtils.isEmpty(user.getName()) ? user.getLogin() : user.getName();
        mUsername.setText(displayName);
        if (TextUtils.isEmpty(user.getBio())) {
            mBio.setVisibility(GONE);
        } else {
            mBio.setVisibility(VISIBLE);
            mBio.setText(user.getBio());
        }


        if (TextUtils.isEmpty(user.getCompany())) {
            mCompany.setVisibility(GONE);
        } else {
            mCompany.setVisibility(VISIBLE);
            mCompany.setText(user.getCompany());
        }


        if (TextUtils.isEmpty(user.getBlog())) {
            mBlog.setVisibility(GONE);
        } else {
            mBlog.setVisibility(VISIBLE);
            mBlog.setText(user.getBlog());
        }


        if (TextUtils.isEmpty(user.getEmail())) {
            mEmail.setVisibility(GONE);
        } else {
            mEmail.setVisibility(VISIBLE);
            mEmail.setText(user.getEmail());
        }

        if (TextUtils.isEmpty(user.getLocation())) {
            mLocation.setVisibility(GONE);
        } else {
            mLocation.setVisibility(VISIBLE);
            mLocation.setText(user.getLocation());
        }

    }
}
