package app.pinlendandroid.app.bases;

import app.pinlendandroid.datas.DataManager;
import app.pinlendandroid.datas.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

import javax.inject.Inject;

/**
 * Created by tohuy on 9/10/17.
 */

public class BaseActivityPresenter extends BasePresenter<BaseActivityView> {

    private boolean mReceiverRegistered = false;

    @Inject
    public BaseActivityPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    public void onCreate() {

    }

    public synchronized void onResume() {
        if (!mReceiverRegistered) {
            getMvpView().registerNetworkStateReceiver();
            mReceiverRegistered = true;
        }
    }

    public synchronized void onPause() {
        if (mReceiverRegistered) {
            getMvpView().unregisterNetworkStateReceiver();
            mReceiverRegistered = false;
        }
    }

    public void onConnectivityLoss() {
        getMvpView().ensureConnectionLossSnackBar();
        if (getMvpView().hasTabBar()) {
            getMvpView().addSnackBarTopMargin();
        }
        getMvpView().displayConnectionLoss();
    }

    public void onConnectivityResume() {
        getMvpView().dismissConnectionLoss();
    }
}
