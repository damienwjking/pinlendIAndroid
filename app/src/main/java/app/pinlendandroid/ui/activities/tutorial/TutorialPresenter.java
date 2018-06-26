package app.pinlendandroid.ui.activities.tutorial;

import android.support.v4.view.ViewPager;

import app.pinlendandroid.R;
import app.pinlendandroid.datas.models.EventBusModel;
import app.pinlendandroid.app.bases.BasePresenter;
import app.pinlendandroid.datas.DataManager;

import javax.inject.Inject;

import app.pinlendandroid.datas.models.EventBusModel;

import app.pinlendandroid.datas.rx.SchedulerProvider;
import app.pinlendandroid.ui.fragments.tutorial.TutorialFragment;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tohuy on 9/14/17.
 */

public class TutorialPresenter extends BasePresenter<TutorialView> {

    @Inject
    public TutorialPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventBusModel eventBusModel) {
        switch (eventBusModel.getBusEnum()) {

        }
    }

    public List<TutorialFragment> getListTutorialFragments() {
        List<TutorialFragment> lstTutorialFragments = new ArrayList<>();
        lstTutorialFragments.add(TutorialFragment.newInstance(R.drawable.logo_text, "content1"));
        lstTutorialFragments.add(TutorialFragment.newInstance(R.drawable.logo_text, "content2"));
        lstTutorialFragments.add(TutorialFragment.newInstance(R.drawable.logo_text, "content3"));
        return lstTutorialFragments;
    }

    public void setOnSkipClicked() {
        getMvpView().gotoLogin();
    }

    public void setOnNextClicked() {
        getMvpView().onNextPage();
    }

    public void onNextPage(ViewPager viewPager) {
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
    }

    public void onResume() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    public void onDestroy() {
        EventBus.getDefault().unregister(this);
    }

}
