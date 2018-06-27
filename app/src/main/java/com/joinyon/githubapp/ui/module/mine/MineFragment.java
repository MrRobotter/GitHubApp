package com.joinyon.githubapp.ui.module.mine;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joinyon.githubapp.R;
import com.joinyon.githubapp.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_mine, null);
        ButterKnife.bind(this, contentView);
        getActivity().setTitle("个人信息");
        return contentView;
    }
}
