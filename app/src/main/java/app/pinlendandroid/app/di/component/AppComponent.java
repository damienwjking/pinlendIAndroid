package app.pinlendandroid.app.di.component;

import android.app.Application;
import android.content.Context;

import app.pinlendandroid.App;
import app.pinlendandroid.analyticss.AnalyticsManager;
import app.pinlendandroid.app.di.module.AnalyticsModule;
import app.pinlendandroid.app.di.module.PreferenceModule;
import app.pinlendandroid.datas.DataManager;
import app.pinlendandroid.app.di.ApplicationContext;
import app.pinlendandroid.app.di.module.AppModule;
import app.pinlendandroid.app.di.module.RxModule;
import app.pinlendandroid.datas.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import app.pinlendandroid.app.di.module.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tohuy on 9/17/17.
 */

@Singleton
@Component(modules = {AppModule.class, PreferenceModule.class, RxModule.class, ApiModule.class, AnalyticsModule.class})
public interface AppComponent {

    void inject(App app);

    @ApplicationContext
    Context context();

    Application application();

    CompositeDisposable compositeDisposable();

    SchedulerProvider schedulerProvider();

    DataManager getDataManager();

    AnalyticsManager analyticsManager();
}
