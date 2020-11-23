package com.ellen.serverdata.api;

import android.text.TextUtils;
import android.util.Log;

import com.ellen.dhcsqlitelibrary.table.impl.ZxyLibrary;
import com.ellen.lmydata.LmyHttpsEmulator;
import com.ellen.lmydata.RequestParams;
import com.ellen.serverdata.bean.BaseApiBean;
import com.ellen.serverdata.bean.user.User;
import com.ellen.serverdata.sql.table.user.UserTable;
import com.ellen.sqlitecreate.createsql.helper.WhereSymbolEnum;
import com.ellen.sqlitecreate.createsql.where.Where;
import com.google.gson.Gson;

public class RegisterApi implements LmyHttpsEmulator {

    private UserTable userTable;

    public RegisterApi(ZxyLibrary zxyLibrary){
       userTable = new UserTable(zxyLibrary,"service_user_table");
       userTable.onCreateTableIfNotExits();
    }

    @Override
    public void initData(boolean isInit) {

    }

    @Override
    public String url() {
        return "https://androidstudy/boss/register";
    }

    @Override
    public RequestParams.RequestType type() {
        return RequestParams.RequestType.POST;
    }

    @Override
    public String json(RequestParams requestParams) {
        String account = (String) requestParams.getPostFieldValues().get("account");
        String password = (String) requestParams.getPostFieldValues().get("password");
        String rePassword = (String) requestParams.getPostFieldValues().get("re_password");

        //验证账号是否已注册
        String sql = Where.getInstance(false).addAndWhereValue("account", WhereSymbolEnum.EQUAL,account).createSQL();
        if(userTable.search(sql,null).size() > 0){
            BaseApiBean<User> baseApiBean = new BaseApiBean<>();
            baseApiBean.setCode(404);
            baseApiBean.setMessage("此账号已注册!");
            return new Gson().toJson(baseApiBean);
        }

        if(TextUtils.isEmpty(account) || TextUtils.isEmpty(password) || TextUtils.isEmpty(rePassword)){
            BaseApiBean<User> baseApiBean = new BaseApiBean<>();
            baseApiBean.setCode(404);
            baseApiBean.setMessage("参数不全,请将参数填写完全");
            return new Gson().toJson(baseApiBean);
        }else {
            if(!password.endsWith(rePassword)){
                BaseApiBean<User> baseApiBean = new BaseApiBean<>();
                baseApiBean.setCode(404);
                baseApiBean.setMessage("密码与重复验证的密码不一致");
                return new Gson().toJson(baseApiBean);
            }else {
                if(account.length() > 15){
                    BaseApiBean<User> baseApiBean = new BaseApiBean<>();
                    baseApiBean.setCode(404);
                    baseApiBean.setMessage("帐号长度不允许超过15个");
                    return new Gson().toJson(baseApiBean);
                }
                if(password.length() > 20){
                    BaseApiBean<User> baseApiBean = new BaseApiBean<>();
                    baseApiBean.setCode(404);
                    baseApiBean.setMessage("密码长度不允许超过20个");
                    return new Gson().toJson(baseApiBean);
                }

                User user = new User();
                user.setAccount(account);
                user.setPassword(password);
                user.setUserName(account);
                BaseApiBean<User> baseApiBean = new BaseApiBean<>();
                baseApiBean.setCode(200);
                baseApiBean.setMessage("请求成功!");
                baseApiBean.setData(user);


                //将用户写入数据库
                userTable.saveData(user);

                return new Gson().toJson(baseApiBean);
            }
        }
    }
}
