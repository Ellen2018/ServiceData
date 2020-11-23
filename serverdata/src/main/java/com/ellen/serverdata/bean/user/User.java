package com.ellen.serverdata.bean.user;

import com.ellen.dhcsqlitelibrary.table.annotation.field.bound.MajorKey;
import com.ellen.dhcsqlitelibrary.table.annotation.field.bound.Unique;

/**
 * 用于用户注册 & 登录
 */
public class User {
    @MajorKey
    private String account;
    private String password;
    @Unique
    private String qqId;
    @Unique
    private String wxId;
    @Unique
    private String userName;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQqId() {
        return qqId;
    }

    public void setQqId(String qqId) {
        this.qqId = qqId;
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
