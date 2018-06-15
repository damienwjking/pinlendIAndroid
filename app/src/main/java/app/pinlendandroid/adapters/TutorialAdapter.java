package app.pinlendandroid.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import app.pinlendandroid.ui.fragments.tutorial.TutorialFragment;

/**
 * User: ntnhuy
 * Date: 6/13/18
 * Time: 10:58 PM
 */
public class TutorialAdapter extends FragmentStatePagerAdapter{

    private List<TutorialFragment> lstFragments;

    public TutorialAdapter(FragmentManager fm, List<TutorialFragment> lstFragments) {
        super(fm);
        this.lstFragments = lstFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return lstFragments.get(position);
    }

    @Override
    public int getCount() {
        return lstFragments.size();
    }
}
