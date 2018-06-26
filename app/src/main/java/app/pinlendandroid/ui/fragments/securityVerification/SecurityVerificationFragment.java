package app.pinlendandroid.ui.fragments.securityVerification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.pinlendandroid.R;
import app.pinlendandroid.app.bases.BaseFragment;
import app.pinlendandroid.databinding.FragmentSecurityVerificationBinding;

import javax.inject.Inject;

/**
 * User: ntnhuy
 * Date: 6/26/18
 * Time: 11:12 PM
 */

public class SecurityVerificationFragment extends BaseFragment implements SecurityVerificationView {

    @Inject
    SecurityVerificationPresenter presenter;
    FragmentSecurityVerificationBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = FragmentSecurityVerificationBinding.inflate(inflater);
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
        presenter.initVariation(getArguments());
    }

    @Override
    public void initView() {
        binding.email.setText(presenter.getEmail());
    }

    @Override
    public void initEvent() {
        binding.setOnSendViaEmail(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setOnSendViaEmail();
            }
        });
        binding.setOnSendViaTXT(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setOnSendViaTXT(binding.mobileNumber.getText().toString());
            }
        });
    }

    @Override
    public String getFragmentLabel() {
        return getString(R.string.fragment_security_verification_label);
    }

    @Override
    public void refresh(boolean isRefreshData) {

    }

    @Override
    public void resetView() {

    }
}
