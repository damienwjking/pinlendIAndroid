package app.pinlendandroid.app.bases;

import app.pinlendandroid.app.bases.MvpView;

/**
 * Created by tohuy on 9/10/17.
 */

public interface BaseActivityView extends MvpView {

    boolean hasTabBar();

    void registerNetworkStateReceiver();

    void unregisterNetworkStateReceiver();

    void ensureConnectionLossSnackBar();

    void addSnackBarTopMargin();

    void displayConnectionLoss();

    void dismissConnectionLoss();
}
