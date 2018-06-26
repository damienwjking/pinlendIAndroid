package app.pinlendandroid.ui.fragments.signUp;

import android.os.Bundle;
import android.text.TextUtils;

import app.pinlendandroid.R;
import app.pinlendandroid.app.bases.BasePresenter;
import app.pinlendandroid.datas.DataManager;
import app.pinlendandroid.datas.rx.SchedulerProvider;
import app.pinlendandroid.enums.FragmentEnums;
import app.pinlendandroid.listeners.OnBackListener;
import app.pinlendandroid.utils.Constants;
import app.pinlendandroid.utils.Utils;
import app.pinlendandroid.widgets.ToolBarPlus;
import io.reactivex.disposables.CompositeDisposable;

import app.pinlendandroid.datas.models.EventBusModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

/**
 * User: ntnhuy
 * Date: 6/26/18
 * Time: 8:49 PM
 */

public class SignUpPresenter extends BasePresenter<SignUpView> {

    @Inject
    public SignUpPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventBusModel eventBusModel) {
        switch (eventBusModel.getBusEnum()) {

        }
    }

    public void onResume() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    public void initToolBar(ToolBarPlus toolBar) {
        toolBar.setShowBack(true);
        toolBar.setTextTitle("Sign Up");
        toolBar.setOnBackListener(new OnBackListener() {
            @Override
            public void onBack() {
                getMvpView().onBackPressed();
            }
        });
    }

    private boolean checkData(String email, String password, String confirmPassword) {
        boolean isOK = true;
        if (TextUtils.isEmpty(password)) {
            isOK = false;
            getMvpView().complain("Password is not blank");
        }
        if (password.length() < Constants.CONFIG.MIN_PASSWORD) {
            isOK = false;
            getMvpView().complain("Password too short");
        }
        if (!password.equals(confirmPassword)) {
            isOK = false;
            getMvpView().complain("Password is not match");
        }
        if (!Utils.isValidEmail(email)) {
            isOK = false;
            getMvpView().complain("Email is invalid");
        }
        return isOK;
    }

    public void onNext(String email, String password, String confirmPassword) {
        if (checkData(email, password, confirmPassword)) {
            gotoSecurityVerification(email);
        }
    }

    public void onLogin() {
        changeFragment(getMvpView().getFragmentManager(), FragmentEnums.LOGIN, true, null, R.id.flt_content);
    }

    private void gotoSecurityVerification(String email) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.BUNDLEKEY.EMAIL, email);
        changeFragment(getMvpView().getFragmentManager(), FragmentEnums.SECURITY_VERIFICATION, true, bundle, R.id.flt_content);
    }

    public void onDestroy() {
        EventBus.getDefault().unregister(this);
    }

}
