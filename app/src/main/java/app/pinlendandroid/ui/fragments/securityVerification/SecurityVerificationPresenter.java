package app.pinlendandroid.ui.fragments.securityVerification;

import android.os.Bundle;

import app.pinlendandroid.R;
import app.pinlendandroid.app.bases.BasePresenter;
import app.pinlendandroid.datas.DataManager;
import app.pinlendandroid.datas.rx.SchedulerProvider;
import app.pinlendandroid.enums.FragmentEnums;
import app.pinlendandroid.listeners.OnBackListener;
import app.pinlendandroid.utils.Constants;
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
 * Time: 11:12 PM
 */

public class SecurityVerificationPresenter extends BasePresenter<SecurityVerificationView> {

    private String email;

    @Inject
    public SecurityVerificationPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
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

    public void initVariation(Bundle bundle) {
        if (bundle != null) {
            email = bundle.getString(Constants.BUNDLEKEY.EMAIL, "");
        }
    }

    public void initToolBar(ToolBarPlus toolBar) {
        toolBar.setShowBack(true);
        toolBar.setTextTitle("Security Verification");
        toolBar.setOnBackListener(new OnBackListener() {
            @Override
            public void onBack() {
                getMvpView().onBackPressed();
            }
        });
    }

    public void setOnSendViaEmail() {
        changeFragment(getMvpView().getFragmentManager(), FragmentEnums.ENTER_CODE, true, null, R.id.flt_content);
    }

    public void setOnSendViaTXT(String mobileNumber) {
        changeFragment(getMvpView().getFragmentManager(), FragmentEnums.ENTER_CODE, true, null, R.id.flt_content);
    }

    public void onDestroy() {
        EventBus.getDefault().unregister(this);
    }

    public String getEmail() {
        return email;
    }
}
