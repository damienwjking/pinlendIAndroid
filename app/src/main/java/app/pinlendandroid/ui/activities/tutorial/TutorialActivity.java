package app.pinlendandroid.ui.activities.tutorial;

import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import app.pinlendandroid.adapters.TutorialAdapter;
import app.pinlendandroid.app.bases.BaseActivity;
import app.pinlendandroid.ui.fragments.tutorial.TutorialFragment;
import app.pinlendandroid.widgets.ToolBarPlus;
import app.pinlendandroid.utils.Utils;
import app.pinlendandroid.R;
import app.pinlendandroid.databinding.ActivityTutorialBinding;

import javax.inject.Inject;

public class TutorialActivity extends BaseActivity implements TutorialView {


    @Inject
    public TutorialPresenter presenter;
    ActivityTutorialBinding binding;
    private TutorialAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
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
        binding = ActivityTutorialBinding.bind(contentView.getChildAt(0));
        getActivityComponent().inject(this);
        presenter.attachView(this);

        adapter = new TutorialAdapter(getSupportFragmentManager(), presenter.getListTutorialFragments());
    }

    @Override
    protected void initView() {
        binding.setAdapter(adapter);
    }

    @Override
    protected void initEvent() {
        binding.setOnSkipClicked(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setOnSkipClicked();
            }
        });

        binding.setOnNextClicked(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setOnNextClicked();
            }
        });
    }

    @Override
    public void setActiveTitle(String title) {
        super.setActiveTitle(title);
    }

    public ToolBarPlus getToolbar() {
        return null;
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

    @Override
    public void onNextPage() {
        presenter.onNextPage(binding.pager);
    }
}
