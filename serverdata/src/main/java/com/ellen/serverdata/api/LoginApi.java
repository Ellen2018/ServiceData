package com.ellen.serverdata.api;

import android.text.TextUtils;

import com.ellen.lmydata.LmyHttpsEmulator;
import com.ellen.lmydata.RequestParams;
import com.ellen.serverdata.bean.BaseApiBean;
import com.ellen.serverdata.bean.user.User;
import com.ellen.serverdata.sql.ServiceSqlLibrary;
import com.ellen.serverdata.sql.table.UserTable;
import com.ellen.sqlitecreate.createsql.helper.WhereSymbolEnum;
import com.ellen.sqlitecreate.createsql.where.Where;
import com.google.gson.Gson;

import java.util.List;

public class LoginApi implements LmyHttpsEmulator {

    private UserTable userTable;

    public LoginApi(ServiceSqlLibrary serviceSqlLibrary){
       this.userTable = serviceSqlLibrary.getUserTable();
    }

    @Override
    public void initData(boolean isInit) {

    }

    @Override
    public String url() {
        return "https://androidstudy/boss/login";
    }

    @Override
    public RequestParams.RequestType type() {
        return RequestParams.RequestType.POST;
    }

    @Override
    public String json(RequestParams requestParams) {
        Integer type = (Integer) requestParams.getPostFieldValues().get("type");
        if(type == null){
            BaseApiBean<User> baseApiBean = new BaseApiBean<>();
            baseApiBean.setCode(404);
            baseApiBean.setMessage("字段type参数异常");
            return new Gson().toJson(baseApiBean);
        }else {
            if (type == 0) {
                //原生登录
                String account = (String) requestParams.getPostFieldValues().get("account");
                String password = (String) requestParams.getPostFieldValues().get("password");
                if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
                    BaseApiBean<User> baseApiBean = new BaseApiBean<>();
                    baseApiBean.setCode(404);
                    baseApiBean.setMessage("字段account或者password参数异常");
                    return new Gson().toJson(baseApiBean);
                } else {
                    String sql = Where.getInstance(false)
                            .addAndWhereValue("account", WhereSymbolEnum.EQUAL, account)
                            .addAndWhereValue("password", WhereSymbolEnum.EQUAL, password)
                            .createSQL();
                    List<User> userList = userTable.search(sql, null);
                    if (userList.size() > 0) {
                        BaseApiBean<User> baseApiBean = new BaseApiBean<>();
                        baseApiBean.setData(userList.get(0));
                        baseApiBean.setMessage("登录成功!");
                        baseApiBean.setCode(200);
                        return new Gson().toJson(baseApiBean);
                    } else {
                        if (userTable.searchByMajorKey(account) == null) {
                            BaseApiBean<User> baseApiBean = new BaseApiBean<>();
                            baseApiBean.setMessage("没有此账号");
                            baseApiBean.setCode(404);
                            return new Gson().toJson(baseApiBean);
                        } else {
                            BaseApiBean<User> baseApiBean = new BaseApiBean<>();
                            baseApiBean.setMessage("密码不正确");
                            baseApiBean.setCode(404);
                            return new Gson().toJson(baseApiBean);
                        }
                    }
                }
            } else if (type == 1) {
                //qq登录
                String qqId = (String) requestParams.getPostFieldValues().get("qq_id");
                if(TextUtils.isEmpty(qqId)){
                    BaseApiBean<User> baseApiBean = new BaseApiBean<>();
                    baseApiBean.setCode(404);
                    baseApiBean.setMessage("qq_id参数异常");
                    return new Gson().toJson(baseApiBean);
                }else {
                    String sql = Where.getInstance(false)
                            .addAndWhereValue("qqId", WhereSymbolEnum.EQUAL, qqId)
                            .createSQL();
                    List<User> userList = userTable.search(sql, null);
                    if (userList.size() > 0) {
                        //qq登录成功
                        BaseApiBean<User> baseApiBean = new BaseApiBean<>();
                        baseApiBean.setData(userList.get(0));
                        baseApiBean.setMessage("登录成功!");
                        baseApiBean.setCode(200);
                        return new Gson().toJson(baseApiBean);
                    } else {
                        //第一次使用qq进行登录，将帐号记录进数据库
                        BaseApiBean<User> baseApiBean = new BaseApiBean<>();
                        baseApiBean.setMessage("登录成功!");
                        baseApiBean.setCode(200);
                        User user = new User();
                        user.setUserId(System.currentTimeMillis());
                        user.setQqId(qqId);
                        baseApiBean.setData(user);
                        userTable.saveData(user);
                        return new Gson().toJson(baseApiBean);
                    }
                }
            } else if (type == 2) {
                String wxId = (String) requestParams.getPostFieldValues().get("wx_id");
                if(TextUtils.isEmpty(wxId)){
                    BaseApiBean<User> baseApiBean = new BaseApiBean<>();
                    baseApiBean.setCode(404);
                    baseApiBean.setMessage("wx_id参数异常");
                    return new Gson().toJson(baseApiBean);
                }else {
                    String sql = Where.getInstance(false)
                            .addAndWhereValue("wxId", WhereSymbolEnum.EQUAL, wxId)
                            .createSQL();
                    List<User> userList = userTable.search(sql, null);
                    if (userList.size() > 0) {
                        //微信登录成功
                        BaseApiBean<User> baseApiBean = new BaseApiBean<>();
                        baseApiBean.setData(userList.get(0));
                        baseApiBean.setMessage("登录成功!");
                        baseApiBean.setCode(200);
                        return new Gson().toJson(baseApiBean);
                    } else {
                        //第一次使用微信进行登录，写入数据库
                        BaseApiBean<User> baseApiBean = new BaseApiBean<>();
                        baseApiBean.setMessage("登录成功!");
                        baseApiBean.setCode(200);
                        User user = new User();
                        user.setUserId(System.currentTimeMillis());
                        user.setWxId(wxId);
                        baseApiBean.setData(user);
                        userTable.saveData(user);
                        return new Gson().toJson(baseApiBean);
                    }
                }
            } else {
                BaseApiBean<User> baseApiBean = new BaseApiBean<>();
                baseApiBean.setCode(404);
                baseApiBean.setMessage("字段type参数异常");
                return new Gson().toJson(baseApiBean);
            }
        }
    }
}
