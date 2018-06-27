package com.joinyon.githubapp.ui.module.moststar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joinyon.githubapp.R;
import com.joinyon.githubapp.ui.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MostStarFragment extends BaseFragment {


    public MostStarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_most_star, container, false);
    }

}
