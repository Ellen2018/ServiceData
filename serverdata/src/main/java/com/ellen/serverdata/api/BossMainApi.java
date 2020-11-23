package com.ellen.serverdata.api;

import com.ellen.lmydata.LmyHttpsEmulator;
import com.ellen.lmydata.RequestParams;
import com.ellen.serverdata.bean.BaseApiBean;
import com.ellen.serverdata.bean.bossmain.BossMain;
import com.ellen.serverdata.bean.bossmain.BossMainData;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class BossMainApi implements LmyHttpsEmulator {

    @Override
    public void initData(boolean isInit) {

    }

    @Override
    public String url() {
        return "https://androidstudy/boss/main";
    }

    @Override
    public RequestParams.RequestType type() {
        return RequestParams.RequestType.GET;
    }

    @Override
    public String json(RequestParams requestParams) {
        if(requestParams.getGetFieldValues() == null || !requestParams.getGetFieldValues().containsKey("page") || !requestParams.getGetFieldValues().containsKey("count")){
            BaseApiBean<BossMain> bossMainBaseApiBean = new BaseApiBean<>();
            bossMainBaseApiBean.setCode(404);
            bossMainBaseApiBean.setMessage("请求参数不全");
            return new Gson().toJson(bossMainBaseApiBean);
        }else {
            int page = (int) requestParams.getGetFieldValues().get("page");
            int count = (int) requestParams.getGetFieldValues().get("count");
            page++;


            BossMain bossMain = new BossMain();
            bossMain.setCompany(new ArrayList<>());
            for (int i = (page - 1) * count; i < count * page; i++) {
                BossMainData bossMainData = new BossMainData();
                //设置职位类型
                bossMainData.setJobType("Android工程师【" + i + "】");
                //设置公司地址
                bossMainData.setAddress("武汉第" + i + "区");
                //设置公司名
                bossMainData.setCompanyName("武汉科" + i + "有限科技公司");
                //设置公司规模
                bossMainData.setScale("11~50");
                //设置公司融资状态
                bossMainData.setStatus("天使轮");
                //设置公司标签
                List<String> tagLists = new ArrayList<>();
                tagLists.add("标签1");
                tagLists.add("标签2");
                tagLists.add("标签3");
                bossMainData.setTags(tagLists);
                //设置公司上限
                bossMainData.setWageLowerLimit(11);
                //设置公司下限
                bossMainData.setWageLowerLimit(20);
                bossMain.getCompany().add(bossMainData);
            }
            if(page > 10){
                bossMain.setIsHaveNextPage(0);
            }else {
                bossMain.setIsHaveNextPage(1);
            }
            BaseApiBean<BossMain> bossMainBaseApiBean = new BaseApiBean<>();
            bossMainBaseApiBean.setCode(200);
            bossMainBaseApiBean.setMessage("Success!");
            bossMainBaseApiBean.setData(bossMain);
            return new Gson().toJson(bossMainBaseApiBean);
        }
    }
}
