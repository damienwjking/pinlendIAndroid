package app.pinlendandroid.utils;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;

import app.pinlendandroid.listeners.IEnterText;
import app.pinlendandroid.widgets.EditTextPlus;

/**
 * Created by ntnhuy on 18/12/2016.
 */

public class TextWatcherPlus implements TextWatcher {

    private EditTextPlus edt;
    private Handler handler;
    private boolean isTyping;
    private IEnterText listener;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (!isTyping && listener != null) {
                listener.onFinish();
            }
        }
    };

    public TextWatcherPlus(EditTextPlus edt, IEnterText listener) {
        this.edt = edt;
        handler = new Handler();
        this.listener = listener;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        isTyping = true;
        handler.removeCallbacks(runnable);
        edt.setNormal();
    }

    @Override
    public void afterTextChanged(Editable s) {
        isTyping = false;
        handler.postDelayed(runnable, 1000);
    }
}
