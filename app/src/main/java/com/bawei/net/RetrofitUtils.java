package com.bawei.net;

import com.bawei.R;
import com.bawei.api.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *@Auther:libokang
 *@Date: 0713
 *@Description:RetrofitUtils
 * */
public class RetrofitUtils {
    private static RetrofitUtils utils;
    private final Retrofit retrofit;

    private RetrofitUtils() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * 双重检验锁
     *
     * @return
     */
    public static RetrofitUtils getUtils() {
        if (utils == null) {
            synchronized (RetrofitUtils.class) {
                if (utils == null) {
                    utils = new RetrofitUtils();
                }
            }
        }
        return utils;
    }

    /**
     * 动态代理
     */
    public <T> T srartService(Class<T> cls) {
        return retrofit.create(cls);
    }
}
