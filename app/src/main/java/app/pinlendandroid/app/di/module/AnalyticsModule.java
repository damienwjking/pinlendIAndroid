package app.pinlendandroid.app.di.module;

import app.pinlendandroid.BuildConfig;
import app.pinlendandroid.analyticss.crashlytics.AppCrashlyticsHelper;
import app.pinlendandroid.analyticss.crashlytics.CrashlyticsHelper;

import com.crashlytics.android.Crashlytics;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tohuy on 9/23/17.
 */

@Module
public class AnalyticsModule {

    @Provides
    @Singleton
    Crashlytics provideCrashlytics() {
        return new Crashlytics();
    }

    @Provides
    @Singleton
    CrashlyticsHelper provideCrashlyticsHelper(AppCrashlyticsHelper crashlyticsHelper) {
        return crashlyticsHelper;
    }
}
