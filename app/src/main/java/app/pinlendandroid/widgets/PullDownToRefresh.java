package app.pinlendandroid.widgets;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

import app.pinlendandroid.R;

/**
 * Created by ntnhuy on 16/12/2016.
 */

public class PullDownToRefresh extends SwipeRefreshLayout {

    private LinearLayoutManager mChildViewLayoutManager;

    public PullDownToRefresh(Context context) {
        super(context);
        init();
    }

    public PullDownToRefresh(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            setColorSchemeResources(R.color.colorPrimary);
        }
    }

    public void setChildViewLayoutManager(LinearLayoutManager childViewLayoutManager) {
        mChildViewLayoutManager = childViewLayoutManager;
    }

    @Override
    public boolean canChildScrollUp() {
        return mChildViewLayoutManager != null && mChildViewLayoutManager.findFirstCompletelyVisibleItemPosition() > 0;
    }
}
