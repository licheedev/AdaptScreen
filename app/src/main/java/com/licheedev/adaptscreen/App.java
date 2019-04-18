package com.licheedev.adaptscreen;

import android.app.Application;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化
        AdaptScreenUtils.init(this);
    }
}
