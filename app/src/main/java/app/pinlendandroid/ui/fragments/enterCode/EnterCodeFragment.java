package app.pinlendandroid.ui.fragments.enterCode;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.pinlendandroid.R;
import app.pinlendandroid.app.bases.BaseFragment;
import app.pinlendandroid.databinding.FragmentEnterCodeBinding;
import app.pinlendandroid.ui.activities.main.MainActivity;
import app.pinlendandroid.ui.activities.splash.SplashActivity;

import javax.inject.Inject;

/**
 * User: ntnhuy
 * Date: 6/27/18
 * Time: 12:28 AM
 */

public class EnterCodeFragment extends BaseFragment implements EnterCodeView {

    @Inject
    EnterCodePresenter presenter;
    FragmentEnterCodeBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = FragmentEnterCodeBinding.inflate(inflater);
        }
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
    public void setToolBar() {
        super.setToolBar();
    }

    @Override
    public void initVariable() {
        getFragmentComponent().inject(this);
        presenter.attachView(this);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initEvent() {
        binding.setOnSubmit(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSubmit(binding.code.getText().toString());
            }
        });
    }

    @Override
    public String getFragmentLabel() {
        return getString(R.string.fragment_enter_code_label);
    }

    @Override
    public void refresh(boolean isRefreshData) {

    }

    @Override
    public void resetView() {

    }

    @Override
    public void gotoMain() {
        Intent i = new Intent(activity, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        activity.finish();
    }
}
