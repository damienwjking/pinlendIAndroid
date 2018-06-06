package app.pinlendandroid.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import app.pinlendandroid.R;

/**
 * Created by tohuy on 11/17/17.
 */

public class ImageViewFixSize extends ImageView {

    boolean isChangeSize = true;

    public ImageViewFixSize(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ImageViewFixSize);
            isChangeSize = a.getBoolean(R.styleable.ImageViewFixSize_is_change_size, true);
            if (isInEditMode()) {
                setImageDrawable(a.getDrawable(R.styleable.ImageViewFixSize_src));
            } else {
                if (a.hasValue(R.styleable.ImageViewFixSize_src)) {
                    new AsyncTask<Void, Void, Drawable>() {

                        @Override
                        protected Drawable doInBackground(Void... voids) {
                            return a.getDrawable(R.styleable.ImageViewFixSize_src);
                        }

                        @Override
                        protected void onPostExecute(Drawable drawable) {
                            super.onPostExecute(drawable);
                            if (drawable != null) {
                                setImageDrawable(drawable);
                            }
                        }
                    }.execute();
                }
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getDrawable() != null && isChangeSize) {
            int widthDrawable = getDrawable().getIntrinsicWidth();
            int heightDrawable = getDrawable().getIntrinsicHeight();
            int width = getMeasuredWidth();
            int height = heightDrawable * getMeasuredWidth() / widthDrawable;
            super.onMeasure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
        }
    }

    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);
        requestLayout();
    }
}
