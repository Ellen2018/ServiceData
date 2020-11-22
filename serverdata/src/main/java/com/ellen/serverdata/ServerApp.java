package com.ellen.serverdata;

import android.app.Application;

import com.ellen.lmydata.LmyEmulator;
import com.ellen.serverdata.api.BossMainApi;

public class ServerApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LmyEmulator.getInstance().init(this);

        //Boss直聘首页接口数据
        LmyEmulator.getInstance().addHttpsEmulator(new BossMainApi());
    }
}
