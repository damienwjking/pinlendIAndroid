package app.pinlendandroid.datas;

import io.reactivex.Observable;
import app.pinlendandroid.datas.api.ApiHelper;
import app.pinlendandroid.datas.prefs.PreferencesHelper;

/**
 * Created by ntnhuy on 20/03/2016.
 */
public interface DataManager extends PreferencesHelper, ApiHelper {
    void logout();
}
