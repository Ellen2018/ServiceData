package com.ellen.serverdata.sql.table.user;

import android.database.sqlite.SQLiteDatabase;

import com.ellen.dhcsqlitelibrary.table.impl.ZxyLibrary;
import com.ellen.dhcsqlitelibrary.table.impl.ZxyTable;
import com.ellen.dhcsqlitelibrary.table.proxy.AutoDesignOperate;
import com.ellen.serverdata.bean.user.User;

public class UserTable extends ZxyTable<User, AutoDesignOperate> {
    public UserTable(SQLiteDatabase db, String tableName) {
        super(db, tableName);
    }

    public UserTable(SQLiteDatabase db) {
        super(db);
    }

    public UserTable(ZxyLibrary zxyLibrary, String tableName) {
        super(zxyLibrary, tableName);
    }

    public UserTable(ZxyLibrary zxyLibrary) {
        super(zxyLibrary);
    }
}
