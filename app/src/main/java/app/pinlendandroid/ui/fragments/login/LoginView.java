package app.pinlendandroid.ui.fragments.login;

import app.pinlendandroid.app.bases.MvpView;

/**
 * User: ntnhuy
 * Date: 6/27/18
 * Time: 12:45 AM
 */

public interface LoginView extends MvpView {
    void onBackPressed();
    void gotoMain();
}
