package app.pinlendandroid;

import android.support.multidex.MultiDexApplication;

import app.pinlendandroid.analyticss.AnalyticsManager;
import app.pinlendandroid.app.di.module.AnalyticsModule;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

import app.pinlendandroid.app.di.module.PreferenceModule;
import app.pinlendandroid.datas.DataManager;
import app.pinlendandroid.app.di.component.AppComponent;
import app.pinlendandroid.app.di.component.DaggerAppComponent;
import app.pinlendandroid.app.di.module.AppModule;
import app.pinlendandroid.app.di.module.ApiModule;
import app.pinlendandroid.app.di.module.RxModule;

import javax.inject.Inject;

/**
 * Created by ntnhuy on 5/29/2015.
 */
public class App extends MultiDexApplication {

    private static App sInstance;

    @Inject
    DataManager dataManager;
    @Inject
    AnalyticsManager analyticsManager;

    private AppComponent appComponent;

    public static App getInstance() {
        return sInstance;
    }

    //singleton
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        setAppComponent(DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule())
                .rxModule(new RxModule())
                .preferenceModule(new PreferenceModule())
                .analyticsModule(new AnalyticsModule())
                .build());

        getAppComponent().inject(this);
        Fabric.with(this, analyticsManager.getCrashlytics());

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public void setAppComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }
}
