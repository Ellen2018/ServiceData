package com.ellen.servicedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.ellen.lmydata.LmyData;
import com.ellen.lmydata.RequestParams;
import com.ellen.lmydata.ResponseBody;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log = findViewById(R.id.tv_log);
        log.setError("呵呵哒");
        login();
    }


    /**
     * Boss直聘主页数据
     */
    private void bossMain(){
        LmyData lmyData = new LmyData();

        Map<String,Object> getQuery = new HashMap<>();
        getQuery.put("page",0);
        getQuery.put("count",5);
        RequestParams requestParams = new RequestParams.Build()
                .setUrl("https://androidstudy/boss/main")
                .get(getQuery)
                .build();

        lmyData.setRequestParams(requestParams).startRequest(new LmyData.Callback() {
            @Override
            public void onSuccess(ResponseBody responseBody) {
                if(responseBody.code() == 200){
                    Log.e("Ellen2018","请求的数据："+responseBody.body());
                }else {
                    Log.e("Ellen2018","请求失败："+responseBody.body());
                }
            }

            @Override
            public void onError(String errorMessage) {
                Log.e("Ellen2018","请求失败："+errorMessage);
            }
        });
    }

    /**
     * 注册用户
     */
    private void register(){
        LmyData lmyData = new LmyData();

        Map<String,Object> postQuery = new HashMap<>();
        postQuery.put("account","Ellen2033");
        postQuery.put("password","246810");
        postQuery.put("re_password","246810");
        RequestParams requestParams = new RequestParams.Build()
                .setUrl("https://androidstudy/boss/register")
                .post(postQuery)
                .build();

        lmyData.setRequestParams(requestParams).startRequest(new LmyData.Callback() {
            @Override
            public void onSuccess(ResponseBody responseBody) {
                if(responseBody.code() == 200){
                    Log.e("Ellen2018","请求成功："+responseBody.body());
                }else {
                    Log.e("Ellen2018","请求失败："+responseBody.body());
                }
            }

            @Override
            public void onError(String errorMessage) {
                Log.e("Ellen2018","请求失败："+errorMessage);
            }
        });
    }

    private void login(){
        LmyData lmyData = new LmyData();

        Map<String,Object> postQuery = new HashMap<>();
        postQuery.put("type",1);
        postQuery.put("account","Ellen2033");
        postQuery.put("password","246810");
        RequestParams requestParams = new RequestParams.Build()
                .setUrl("https://androidstudy/boss/login")
                .post(postQuery)
                .build();

        lmyData.setRequestParams(requestParams).startRequest(new LmyData.Callback() {
            @Override
            public void onSuccess(ResponseBody responseBody) {
                if(responseBody.code() == 200){
                    Log.e("Ellen2018","请求成功："+responseBody.body());
                }else {
                    Log.e("Ellen2018","请求失败："+responseBody.body());
                }
            }

            @Override
            public void onError(String errorMessage) {
                Log.e("Ellen2018","请求失败："+errorMessage);
            }
        });
    }

}