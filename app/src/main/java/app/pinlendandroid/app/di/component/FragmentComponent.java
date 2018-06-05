package app.pinlendandroid.app.di.component;

import app.pinlendandroid.app.bases.BaseFragment;
import app.pinlendandroid.app.di.scopes.UserScope;
import app.pinlendandroid.ui.fragments.home.HomeFragment;

import dagger.Component;

/**
 * Created by tohuy on 9/17/17.
 */

@UserScope
@Component(dependencies = AppComponent.class)
public interface FragmentComponent {
    void inject(BaseFragment fragment);

    void inject(HomeFragment fragment);
}
