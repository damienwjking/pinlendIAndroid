package app.pinlendandroid.ui.fragments.enterCode;

import app.pinlendandroid.app.bases.BasePresenter;
import app.pinlendandroid.datas.DataManager;
import app.pinlendandroid.datas.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

import app.pinlendandroid.datas.models.EventBusModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

/**
 * User: ntnhuy
 * Date: 6/27/18
 * Time: 12:28 AM
 */

public class EnterCodePresenter extends BasePresenter<EnterCodeView> {

    @Inject
    public EnterCodePresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
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

    public void onSubmit(String code) {
        getMvpView().gotoMain();
    }

    public void onDestroy() {
        EventBus.getDefault().unregister(this);
    }

}
