package com.ellen.serverdata.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.ellen.dhcsqlitelibrary.table.impl.ZxyLibrary;

public class ServiceSqlLibrary extends ZxyLibrary {

    public ServiceSqlLibrary(Context context, String name, int version) {
        super(context, name, version);
    }

    public ServiceSqlLibrary(Context context, String libraryPath, String name, int version) {
        super(context, libraryPath, name, version);
    }

    @Override
    public void onZxySQLiteCreate(SQLiteDatabase db) {

    }

    @Override
    public void onZxySQLiteUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
