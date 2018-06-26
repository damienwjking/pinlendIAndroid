package app.pinlendandroid.ui.activities.tutorial;

import app.pinlendandroid.app.bases.MvpView;

/**
 * Created by tohuy on 9/14/17.
 */

public interface TutorialView extends MvpView {
    void onNextPage();
    void gotoLogin();
}
