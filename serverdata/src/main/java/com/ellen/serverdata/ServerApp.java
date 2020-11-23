package com.ellen.serverdata;

import android.app.Application;

import com.ellen.lmydata.LmyEmulator;
import com.ellen.serverdata.api.BossMainApi;
import com.ellen.serverdata.api.RegisterApi;
import com.ellen.serverdata.sql.ServiceSqlLibrary;

public class ServerApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LmyEmulator.getInstance().init(this);

        ServiceSqlLibrary serviceSqlLibrary = new ServiceSqlLibrary(this,"service_sql_library",1);

        //Boss直聘首页接口数据
        LmyEmulator.getInstance().addHttpsEmulator(new BossMainApi());
        //注册接口
        LmyEmulator.getInstance().addHttpsEmulator(new RegisterApi(serviceSqlLibrary));
    }
}
