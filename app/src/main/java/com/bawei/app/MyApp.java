package com.bawei.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/*
 *@Auther:libokang
 *@Date: 时间
 *@Description:功能
 * */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        //初始化Fresco
        super.onCreate();
        Fresco.initialize(this);
    }
}
