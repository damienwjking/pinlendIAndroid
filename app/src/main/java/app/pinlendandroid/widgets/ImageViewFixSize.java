package app.pinlendandroid.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.util.concurrent.Callable;

import app.pinlendandroid.R;
import app.pinlendandroid.utils.Utils;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

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
        }
    }

    @BindingAdapter("src")
    public static void setSrc(final ImageView view, final int drawableId) {
        if (view.isInEditMode()) {
            view.setImageDrawable(Utils.getDrawable(drawableId));
        } else {
            Observable.fromCallable(new Callable<Drawable>() {
                @Override
                public Drawable call() throws Exception {
                    return Utils.getDrawable(drawableId);
                }
            })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Drawable>() {
                        @Override
                        public void accept(Drawable drawable) throws Exception {
                            if (drawable != null) {
                                view.setImageDrawable(drawable);
                            }
                        }
                    });
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
