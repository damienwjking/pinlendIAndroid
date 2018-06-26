package app.pinlendandroid.ui.activities.signUp;

import app.pinlendandroid.R;
import app.pinlendandroid.datas.models.EventBusModel;
import app.pinlendandroid.app.bases.BasePresenter;
import app.pinlendandroid.datas.DataManager;

import javax.inject.Inject;

import app.pinlendandroid.datas.rx.SchedulerProvider;
import app.pinlendandroid.enums.FragmentEnums;
import io.reactivex.disposables.CompositeDisposable;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * User: ntnhuy
 * Date: 6/26/18
 * Time: 1:24 PM
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

    public void initView() {
        changeFragment(getMvpView().getSupportFragmentManager(), FragmentEnums.SIGN_UP, false, null, R.id.flt_content);
    }

    public void onDestroy() {
        EventBus.getDefault().unregister(this);
    }

}
