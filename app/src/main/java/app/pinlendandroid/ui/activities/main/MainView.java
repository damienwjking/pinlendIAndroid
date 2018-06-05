package app.pinlendandroid.ui.activities.main;

import app.pinlendandroid.app.bases.BaseFragment;
import app.pinlendandroid.app.bases.MvpView;

/**
 * Created by tohuy on 9/14/17.
 */

public interface MainView extends MvpView {
    void selectTab(int position);

    void setCurrentItem(int position, boolean isSmooth);

    BaseFragment getCurrentFragment();

    void setActiveTitle(String text);

    String getActionBarTitle(int position);

    void closeDrawer();
}
