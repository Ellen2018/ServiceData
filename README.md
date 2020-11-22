[![](https://jitpack.io/v/Ellen2018/ServiceData.svg)](https://jitpack.io/#Ellen2018/ServiceData)  

接口导入说明：

【1】步骤一导入库：

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }//在项目gradle中添加此代码
		}
	}

然后在到app gradle的依赖中添加：  

    implementation 'com.github.Ellen2018:ServiceData:x.y.z'

【2】项目中配置使用环境

让你的application类继承自ServerApp,代码如下所示：  

    import com.ellen.serverdata.ServerApp;

    public class App extends ServerApp {
    }

然后再到项目的Androidmanifest.xml中配置此App类就完成了使用环境的配置。

【3】使用

就拿：[https://androidstudy/boss/main](https://yapi.baidu.com/project/14497/interface/api/185493)这个接口示范：

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


再三注意：接口的前缀域名为-->**https://androidstudy/**  
再三注意：接口的前缀域名为-->**https://androidstudy/**  
再三注意：接口的前缀域名为-->**https://androidstudy/**