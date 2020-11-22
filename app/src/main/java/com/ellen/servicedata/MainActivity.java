package com.ellen.servicedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.ellen.lmydata.LmyData;
import com.ellen.lmydata.RequestParams;
import com.ellen.lmydata.ResponseBody;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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



}