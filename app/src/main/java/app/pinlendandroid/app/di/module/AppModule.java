package app.pinlendandroid.app.di.module;

import android.app.Application;
import android.content.Context;

import app.pinlendandroid.analyticss.AnalyticsManager;
import app.pinlendandroid.analyticss.AppAnalyticsManager;
import app.pinlendandroid.datas.AppDataManager;
import app.pinlendandroid.datas.DataManager;
import app.pinlendandroid.app.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tohuy on 9/8/17.
 */

@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    AnalyticsManager provideAnalyticsManager(AppAnalyticsManager appAnalyticsManager) {
        return appAnalyticsManager;
    }
}
