package app.pinlendandroid.datas.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import app.pinlendandroid.app.di.ApplicationContext;
import app.pinlendandroid.app.di.PreferenceInfo;
import app.pinlendandroid.utils.Constants;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by tohuy on 9/22/17.
 */

@Singleton
public class AppPreferencesHelper implements PreferencesHelper {

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }


    @Override
    public void clearPrefs() {
        mPrefs.edit().clear();
    }

    @Override
    public void setIsFirstInstallApp(boolean isFirstInstallApp) {
        mPrefs.edit().putBoolean(Constants.SPK.IS_FIRST_INSTALL_APP, isFirstInstallApp).apply();
    }

    @Override
    public boolean isFirstInstallApp() {
        return mPrefs.getBoolean(Constants.SPK.IS_FIRST_INSTALL_APP, true);
    }

    @Override
    public void setIsLogin(boolean isLogin) {
        mPrefs.edit().putBoolean(Constants.SPK.IS_LOGIN, isLogin).apply();
    }

    @Override
    public boolean isLogin() {
        return mPrefs.getBoolean(Constants.SPK.IS_LOGIN, false);
    }
}
