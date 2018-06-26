package app.pinlendandroid.ui.fragments.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.pinlendandroid.R;
import app.pinlendandroid.app.bases.BaseFragment;
import app.pinlendandroid.databinding.FragmentLoginBinding;
import app.pinlendandroid.ui.activities.main.MainActivity;

import javax.inject.Inject;

/**
 * User: ntnhuy
 * Date: 6/27/18
 * Time: 12:45 AM
 */

public class LoginFragment extends BaseFragment implements LoginView {

    @Inject
    LoginPresenter presenter;
    FragmentLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = FragmentLoginBinding.inflate(inflater);
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
        presenter.setToolBar(toolBar);
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
        binding.setOnLogin(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setOnLogin(binding.email.getText().toString(), binding.password.getText().toString());
            }
        });
    }

    @Override
    public String getFragmentLabel() {
        return getString(R.string.fragment_login2_label);
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
