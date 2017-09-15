package com.kuson.mvpproject.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.kuson.mvpproject.utils.LogUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kuson on 17/6/27.
 */

public class RetrofitHelper {

    private static volatile RetrofitHelper instatnce;

    private static final long TIMEOUT_CONNECT = 15;

    private static final long TIMEOUT_READ = 20;

    private static final long TIMEOUT_WRITE = 20;

    private static Retrofit mRetrofit;

    public RetrofitHelper() {
        init();
    }

    private void init() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_CONNECT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_WRITE, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(mHttpLoggingIntercepter)
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    private HttpLoggingInterceptor mHttpLoggingIntercepter =
            new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            LogUtils.i("okhttp-->", message);
        }
    });

    public static RetrofitHelper getInstance() {
        if (instatnce == null) {
            synchronized (RetrofitHelper.class) {
                if (instatnce == null) {
                    instatnce = new RetrofitHelper();
                }
            }
        }
        return instatnce;
    }

    public <T> T getApiService(Class<T> service) {
        return mRetrofit.create(service);
    }

}
