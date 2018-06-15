package app.pinlendandroid.helpers;

import android.databinding.BindingAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * User: ntnhuy
 * Date: 6/13/18
 * Time: 11:11 PM
 */
public class DataBindingHelper {
    @BindingAdapter("initViewPager")
    public static void initViewPager(ViewPager viewPager, PagerAdapter adapter) {
        viewPager.setAdapter(adapter);
    }
}
