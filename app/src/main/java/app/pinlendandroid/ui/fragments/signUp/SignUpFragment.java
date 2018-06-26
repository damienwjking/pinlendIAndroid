package app.pinlendandroid.ui.fragments.signUp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.pinlendandroid.R;
import app.pinlendandroid.app.bases.BaseFragment;
import app.pinlendandroid.databinding.FragmentSignUpBinding;
import app.pinlendandroid.utils.ToastUtils;

import javax.inject.Inject;

/**
 * User: ntnhuy
 * Date: 6/26/18
 * Time: 8:49 PM
 */

public class SignUpFragment extends BaseFragment implements SignUpView {

    @Inject
    SignUpPresenter presenter;
    FragmentSignUpBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = FragmentSignUpBinding.inflate(inflater);
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
        presenter.initToolBar(toolBar);
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
        binding.setOnNext(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onNext(binding.email.getText().toString(), binding.password.getText().toString(), binding.confirmPassword.getText().toString());
            }
        });
        binding.setOnLogin(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onLogin();
            }
        });
    }

    @Override
    public String getFragmentLabel() {
        return getString(R.string.fragment_login_label);
    }

    @Override
    public void refresh(boolean isRefreshData) {

    }

    @Override
    public void resetView() {

    }

    @Override
    public void complain(String text) {
        ToastUtils.showLong(text);
    }
}
