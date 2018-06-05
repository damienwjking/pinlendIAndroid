package app.pinlendandroid.app.di.module;

import app.pinlendandroid.app.di.PreferenceInfo;
import app.pinlendandroid.datas.prefs.AppPreferencesHelper;
import app.pinlendandroid.datas.prefs.PreferencesHelper;
import app.pinlendandroid.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tohuy on 9/22/17.
 */

@Module
public class PreferenceModule {
    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return Constants.SPK.NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }
}
