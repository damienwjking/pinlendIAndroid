package app.pinlendandroid.datas.api;

import android.app.Activity;

import app.pinlendandroid.App;
import app.pinlendandroid.BuildConfig;
import app.pinlendandroid.utils.ToStringConverterFactory;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ntnhuy on 18/04/2016.
 */
public class AppService {
    public static Activity context;
    private static Retrofit retrofit;

    public static ApiHelper getApiInstance() {
        if (retrofit == null) {
            final OkHttpClient okHttpClient = new OkHttpClient();

            // Enable caching for OkHttp
            int cacheSize = 10 * 1024 * 1024; // 10 MiB
            Cache cache = new Cache(App.getInstance().getCacheDir(), cacheSize);
            okHttpClient.newBuilder().cache(cache);


            okHttpClient.interceptors().add(new AppRequestInterceptor());

//            okHttpClient.setReadTimeout(60, TimeUnit.SECONDS);
//            okHttpClient.setConnectTimeout(60, TimeUnit.SECONDS);
            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(new ToStringConverterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit.create(ApiHelper.class);
    }
}

