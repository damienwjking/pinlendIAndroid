package app.pinlendandroid.ui.activities.main;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import app.pinlendandroid.R;
import app.pinlendandroid.adapters.MainActivityPagerAdapter;
import app.pinlendandroid.app.bases.BaseActivity;
import app.pinlendandroid.app.bases.BaseFragment;
import app.pinlendandroid.widgets.ToolBarPlus;
import app.pinlendandroid.utils.Utils;
import app.pinlendandroid.databinding.ActivityMainBinding;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainView {

    @Inject
    public MainPresenter presenter;
    ActivityMainBinding binding;
    private MainActivityPagerAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.onResume();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        presenter.detachView();
    }

    @Override
    protected void initVariable() {
        View decorView = getWindow().getDecorView();
        ViewGroup contentView = (ViewGroup) decorView.findViewById(android.R.id.content);
        binding = ActivityMainBinding.bind(contentView.getChildAt(0));
        getActivityComponent().inject(this);
        presenter.attachView(this);
    }

    @Override
    protected void initView() {

        binding.toolBar.removeAllViews();
        setSupportActionBar(binding.toolBar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, binding.drawerlayout, binding.toolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerlayout.setDrawerListener(toggle);
        toggle.syncState();
        presenter.setNavigationItemSelectedListener(binding.sliderMenu);
        presenter.setupUI(binding.drawerlayout);

        setupTabLayout();

        mMainAdapter = new MainActivityPagerAdapter(getSupportFragmentManager(), this);
        binding.viewpager.setAdapter(mMainAdapter);
        binding.viewpager.setSwipeEnable(false);
//        binding.viewpager.addOnPageChangeListener(this);
        binding.viewpager.setOffscreenPageLimit(2);

        presenter.selectTab(binding.tabbar.getTabAt(0), false);
    }

    @Override
    protected void initEvent() {
        binding.tabbar.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                presenter.unSelectLastActiveTab(binding.tabbar);
                presenter.selectTab(tab, true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                presenter.unSelectLastActiveTab(binding.tabbar);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                onTabSelected(tab);
            }
        });
    }

    private void setupTabLayout() {
        binding.tabbar.addTab(binding.tabbar.newTab().setText(R.string.tab1));

        binding.tabbar.addTab(binding.tabbar.newTab().setText(R.string.tab2));
    }

    @Override
    public void selectTab(int position) {
        presenter.unSelectLastActiveTab(binding.tabbar);
        presenter.selectTab(binding.tabbar.getTabAt(position), false);
    }

    @Override
    public void setCurrentItem(int position, boolean isSmooth) {
        binding.viewpager.setCurrentItem(position, isSmooth);
    }

    @Override
    public BaseFragment getCurrentFragment() {
        return mMainAdapter.getCurrentFragment();
    }

    @Override
    public String getActionBarTitle(int position) {
        return mMainAdapter.getActionBarTitle(position);
    }

    @Override
    public void setActiveTitle(String title) {
        super.setActiveTitle(title);
//        binding.toolBar.setTitle(title);
    }

    public ToolBarPlus getToolbar() {
        return binding.toolBar;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void resetView() {
        binding.toolBar.reset();
        Utils.hideSoftKeyboard(this);
        mMainAdapter.getCurrentFragment().setToolBar();
        mMainAdapter.getCurrentFragment().refresh(false);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mMainAdapter.getCurrentFragment().onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean hasTabBar() {
        return true;
    }

    @Override
    public void closeDrawer() {
        binding.drawerlayout.closeDrawers();
    }
}
