package app.pinlendandroid.app.di.component;

import app.pinlendandroid.app.bases.BaseFragment;
import app.pinlendandroid.app.di.scopes.UserScope;
import app.pinlendandroid.ui.fragments.enterCode.EnterCodeFragment;
import app.pinlendandroid.ui.fragments.home.HomeFragment;

import app.pinlendandroid.ui.fragments.login.LoginFragment;
import app.pinlendandroid.ui.fragments.securityVerification.SecurityVerificationFragment;
import app.pinlendandroid.ui.fragments.signUp.SignUpFragment;
import app.pinlendandroid.ui.fragments.tutorial.TutorialFragment;
import dagger.Component;

/**
 * Created by tohuy on 9/17/17.
 */

@UserScope
@Component(dependencies = AppComponent.class)
public interface FragmentComponent {
    void inject(BaseFragment fragment);

    void inject(HomeFragment fragment);

    void inject(TutorialFragment fragment);
    void inject(SignUpFragment fragment);
    void inject(SecurityVerificationFragment fragment);
    void inject(EnterCodeFragment fragment);
    void inject(LoginFragment fragment);
}
