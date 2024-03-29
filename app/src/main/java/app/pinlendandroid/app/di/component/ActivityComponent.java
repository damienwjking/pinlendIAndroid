package app.pinlendandroid.app.di.component;

import app.pinlendandroid.ui.activities.signUp.SignUpActivity;
import app.pinlendandroid.ui.activities.main.MainActivity;
import app.pinlendandroid.app.bases.BaseActivity;
import app.pinlendandroid.app.di.scopes.UserScope;
import app.pinlendandroid.ui.activities.splash.SplashActivity;

import app.pinlendandroid.ui.activities.tutorial.TutorialActivity;
import dagger.Component;

/**
 * Created by tohuy on 9/8/17.
 */

@UserScope
@Component(dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(BaseActivity activity);

    void inject(SplashActivity activity);

    void inject(MainActivity activity);

    void inject(TutorialActivity activity);

    void inject(SignUpActivity activity);
}
