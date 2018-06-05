package app.pinlendandroid.datas;

import android.content.Context;

import io.reactivex.Observable;
import app.pinlendandroid.datas.api.ApiHelper;
import retrofit2.Retrofit;
import app.pinlendandroid.app.di.ApplicationContext;
import app.pinlendandroid.datas.prefs.PreferencesHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by tohuy on 9/17/17.
 */

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final ApiHelper mApiHelper;
    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context, Retrofit retrofit, PreferencesHelper preferencesHelper) {
        mContext = context;
        mApiHelper = retrofit.create(ApiHelper.class);
        mPreferencesHelper = preferencesHelper;
    }

    @Override
    public void logout() {
        clearPrefs();
    }

    @Override
    public void clearPrefs() {
        mPreferencesHelper.clearPrefs();
    }

    @Override
    public void setIsFirstInstallApp(boolean isFirstInstallApp) {
        mPreferencesHelper.setIsFirstInstallApp(isFirstInstallApp);
    }

    @Override
    public boolean isFirstInstallApp() {
        return mPreferencesHelper.isFirstInstallApp();
    }

    @Override
    public void setIsLogin(boolean isLogin) {
        mPreferencesHelper.setIsLogin(isLogin);
    }

    @Override
    public boolean isLogin() {
        return mPreferencesHelper.isLogin();
    }
}
