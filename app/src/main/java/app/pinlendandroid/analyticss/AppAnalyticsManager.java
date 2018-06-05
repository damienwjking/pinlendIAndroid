package app.pinlendandroid.analyticss;

import android.content.Context;

import app.pinlendandroid.analyticss.crashlytics.CrashlyticsHelper;

import com.crashlytics.android.Crashlytics;

import app.pinlendandroid.app.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by tohuy on 9/23/17.
 */

@Singleton
public class AppAnalyticsManager implements AnalyticsManager {

    private final Context mContext;
    private final CrashlyticsHelper mCrashlyticsHelper;

    @Inject
    public AppAnalyticsManager(@ApplicationContext Context context, CrashlyticsHelper crashlyticsHelper) {
        mContext = context;
        mCrashlyticsHelper = crashlyticsHelper;
    }

    @Override
    public Crashlytics getCrashlytics() {
        return mCrashlyticsHelper.getCrashlytics();
    }
}
