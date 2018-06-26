package app.pinlendandroid.ui.activities.signUp;

import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import app.pinlendandroid.app.bases.BaseActivity;
import app.pinlendandroid.widgets.ToolBarPlus;
import app.pinlendandroid.utils.Utils;
import app.pinlendandroid.R;
import app.pinlendandroid.databinding.ActivityLoginBinding;

import javax.inject.Inject;

/**
 * User: ntnhuy
 * Date: 6/26/18
 * Time: 1:24 PM
 */

public class SignUpActivity extends BaseActivity implements SignUpView {


    @Inject
    public SignUpPresenter presenter;
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
        binding = ActivityLoginBinding.bind(contentView.getChildAt(0));
        getActivityComponent().inject(this);
        presenter.attachView(this);
    }

    @Override
    protected void initView() {
        presenter.initView();
    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void setActiveTitle(String title) {
        super.setActiveTitle(title);
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
        Utils.hideSoftKeyboard(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean hasTabBar() {
        return false;
    }
}
