package app.pinlendandroid.adapters;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import app.pinlendandroid.R;
import app.pinlendandroid.app.bases.BaseFragment;
import app.pinlendandroid.ui.fragments.home.HomeFragment;
import app.pinlendandroid.utils.Constants;
import app.pinlendandroid.utils.Utils;

/**
 * Created by ntnhuy on 22/12/2016.
 */

public class MainActivityPagerAdapter extends FragmentPagerAdapter {

    private static final int NUMBER_OF_PAGES = 2;
    private BaseFragment mCurrentFragment;
    private Context mContext;

    public MainActivityPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    private String getTabTitle(int position) {
        switch (position) {
            case Constants.TAB.TAB1:
                return Utils.getString(R.string.tab1);

            case Constants.TAB.TAB2:
                return Utils.getString(R.string.tab2);

            default:
                return "";
        }
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        switch (position) {
            case Constants.TAB.TAB1:
                return new HomeFragment();

            case Constants.TAB.TAB2:
                return new HomeFragment();
        }
        return new HomeFragment();
    }

    @Override
    public int getCount() {
        return NUMBER_OF_PAGES;
    }

    public String getActionBarTitle(int pos) {
        return getTabTitle(pos);
    }

    public BaseFragment getCurrentFragment() {
        return mCurrentFragment;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (getCurrentFragment() != object) {
            mCurrentFragment = ((BaseFragment) object);
        }
        super.setPrimaryItem(container, position, object);
    }
}
