package app.pinlendandroid.ui.fragments.signUp;

import android.support.v4.app.FragmentManager;

import app.pinlendandroid.app.bases.MvpView;

/**
 * User: ntnhuy
 * Date: 6/26/18
 * Time: 8:49 PM
 */

public interface SignUpView extends MvpView {
    void onBackPressed();
    void complain(String text);
    FragmentManager getFragmentManager();
}
