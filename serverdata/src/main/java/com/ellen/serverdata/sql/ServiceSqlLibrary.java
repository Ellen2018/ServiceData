package com.ellen.serverdata.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.ellen.dhcsqlitelibrary.table.impl.ZxyLibrary;
import com.ellen.serverdata.sql.table.user.UserTable;

public class ServiceSqlLibrary extends ZxyLibrary {

    public static String TABLE_NAME_USER = "service_user_table";
    private UserTable userTable;

    public UserTable getUserTable() {
        return userTable;
    }

    private void init(){
        userTable = new UserTable(this,TABLE_NAME_USER);
        userTable.onCreateTableIfNotExits();
    }

    public ServiceSqlLibrary(Context context, String name, int version) {
        super(context, name, version);
        init();
    }

    public ServiceSqlLibrary(Context context, String libraryPath, String name, int version) {
        super(context, libraryPath, name, version);
        init();
    }

    @Override
    public void onZxySQLiteCreate(SQLiteDatabase db) {

    }

    @Override
    public void onZxySQLiteUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
