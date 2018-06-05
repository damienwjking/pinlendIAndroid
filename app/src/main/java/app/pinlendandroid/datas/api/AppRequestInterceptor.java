package app.pinlendandroid.datas.api;


import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import app.pinlendandroid.App;
import app.pinlendandroid.ui.activities.splash.SplashActivity;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class AppRequestInterceptor implements Interceptor {

    public AppRequestInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request original = chain.request();
        String token = "";//AppUtils.getUser().getAccess_token();
        if (!TextUtils.isEmpty(token)) {
            Request request = original.newBuilder()
                    .header("Authorization", "Bearer " + token)
                    .method(original.method(), original.body())
                    .build();
            Response response = chain.proceed(request);
            if (response.code() == 401) {
                Context context = App.getInstance();
                Intent intent = new Intent(context, SplashActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                context.startActivity(intent);
            }
            return response;
        }
        return chain.proceed(original);


    }
}
