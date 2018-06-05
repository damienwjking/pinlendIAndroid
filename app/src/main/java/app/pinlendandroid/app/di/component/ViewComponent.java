package app.pinlendandroid.app.di.component;

import app.pinlendandroid.app.di.scopes.UserScope;
import app.pinlendandroid.widgets.iconWithNotification.IconWithNotification;
import app.pinlendandroid.widgets.recyclerViewPlus.RecyclerViewPlus;

import dagger.Component;

/**
 * Created by tohuy on 9/17/17.
 */

@UserScope
@Component(dependencies = AppComponent.class)
public interface ViewComponent {
    void inject(IconWithNotification iconWithNotification);

    void inject(RecyclerViewPlus recyclerViewPlus);
}
