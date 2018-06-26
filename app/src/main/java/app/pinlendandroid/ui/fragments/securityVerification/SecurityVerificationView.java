package app.pinlendandroid.ui.fragments.securityVerification;

import android.support.v4.app.FragmentManager;

import app.pinlendandroid.app.bases.MvpView;

/**
 * User: ntnhuy
 * Date: 6/26/18
 * Time: 11:12 PM
 */

public interface SecurityVerificationView extends MvpView {
    void onBackPressed();
    FragmentManager getFragmentManager();
}
