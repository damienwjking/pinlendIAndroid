package app.pinlendandroid.ui.activities.splash;

import app.pinlendandroid.app.bases.BasePresenter;
import app.pinlendandroid.datas.DataManager;
import app.pinlendandroid.datas.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

import javax.inject.Inject;

/**
 * Created by tohuy on 9/22/17.
 */

public class SplashPresenter extends BasePresenter<SplashView> {

    @Inject
    public SplashPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    public boolean isFirstInstallApp() {
        return dataManager.isFirstInstallApp();
    }

    public void setIsFirstInstallApp(boolean isFirstInstallApp) {
        dataManager.setIsFirstInstallApp(isFirstInstallApp);
    }

    public boolean isLogin() {
        return dataManager.isLogin();
    }
}
