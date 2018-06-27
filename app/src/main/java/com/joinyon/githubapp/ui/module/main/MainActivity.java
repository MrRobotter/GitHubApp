package com.joinyon.githubapp.ui.module.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.joinyon.githubapp.GitHubApplication;
import com.joinyon.githubapp.R;
import com.joinyon.githubapp.common.AppLog;
import com.joinyon.githubapp.dagger.HasComponent;
import com.joinyon.githubapp.dagger.component.DaggerMainComponent;
import com.joinyon.githubapp.dagger.component.MainComponent;
import com.joinyon.githubapp.dagger.module.ActivityModule;
import com.joinyon.githubapp.ui.base.BaseActivity;
import com.joinyon.githubapp.ui.module.mine.MineFragment;
import com.joinyon.githubapp.ui.module.moststar.MostStarFragment;
import com.joinyon.githubapp.ui.module.trending.TrendingFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements HasComponent<MainComponent> {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.content_frame)
    FrameLayout mContentFrame;

    BottomBar mBottomBar;

    FragmentManager mFragmentManager = getSupportFragmentManager();

    public static void launch(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppLog.d("MainActivity onCreate start");
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mBottomBar = BottomBar.attach(this, savedInstanceState);
        initViews();
        AppLog.d("MainActivity onCreate end");
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppLog.d("MainActivity onResume");
    }

    private void initViews() {
        setSupportActionBar(mToolbar);
        mBottomBar.setItems(R.menu.bottombar_menu);
        mBottomBar.setOnMenuTabClickListener(mTabClickListener);
    }

    private OnMenuTabClickListener mTabClickListener = new OnMenuTabClickListener() {
        @Override
        public void onMenuTabSelected(int menuItemId) {
            AppLog.d("onMenuTabSelected menuItemId=" + menuItemId);
            changeTitle(menuItemId);
            switchMenu(getFragmentName(menuItemId));

        }

        @Override
        public void onMenuTabReSelected(int menuItemId) {
            AppLog.d("onMenuTabReSelected menuItemId=" + menuItemId);
        }
    };

    private Fragment mCurrentFragment;

    private void switchMenu(String fragmentName) {

        Fragment fragment = mFragmentManager.findFragmentByTag(fragmentName);

        if (fragment != null) {
            if (fragment == mCurrentFragment) {
                return;
            }
            mFragmentManager.beginTransaction().show(fragment).commit();
        } else {
            fragment = Fragment.instantiate(this, fragmentName);
            mFragmentManager.beginTransaction().add(R.id.content_frame, fragment, fragmentName).commit();
        }
        if (mCurrentFragment != null) {
            mFragmentManager.beginTransaction().hide(mCurrentFragment).commit();
        }

        mCurrentFragment = fragment;
    }

    private String getFragmentName(int menuId) {
        switch (menuId) {
            case R.id.menu_trending:
                return TrendingFragment.class.getName();

            case R.id.menu_most_stars:
                return MostStarFragment.class.getName();
            case R.id.menu_account:
                return MineFragment.class.getName();
            default:
                return "";
        }
    }

    private void changeTitle(int menuId) {
        switch (menuId) {
            case R.id.menu_account:
                setTitle("账户");
                break;
            case R.id.menu_most_stars:
                setTitle("热门");
                break;
            case R.id.menu_trending:
                setTitle("趋势");
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public MainComponent getComponent() {

        return DaggerMainComponent
                .builder()
                .applicationComponent(GitHubApplication.get(this).getComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }
}
