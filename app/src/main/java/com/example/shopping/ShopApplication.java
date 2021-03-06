package com.example.shopping;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.example.mylibrary.HttpConstant;
import com.example.mylibrary.HttpGlobaConfig;
import com.example.mylibrary.ResponseInterceper;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.commonsdk.UMConfigure;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import cn.jpush.android.api.JPushInterface;
import okhttp3.Interceptor;

public class ShopApplication extends Application {

   public static ShopApplication mShopApplicatio;





    @Override
    public void onCreate() {
        super.onCreate();
        //极光推送的初始化
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        ArrayList<Interceptor> interceptors1 = new ArrayList<>();
        interceptors1.add(new ResponseInterceper());
        HttpGlobaConfig.getInstance()
       .setInterceptors(interceptors1)
                 .setBaseUrl("http://169.254.189.205:8080/kotlin/")
                .setTimeOut(HttpConstant.TIME_OUT)
                .setShowLog(true)
                .setTimeUnit(HttpConstant.TIME_UNIT)
                .initReady(this);

        //d59081eac6
        //9ad50244-fb71-4dfc-af0d-2fcf42a16251
 /*       Context context = getApplicationContext();
// 获取当前包名
        String packageName = context.getPackageName();
// 获取当前进程名
        String processName = getProcessName(android.os.Process.myPid());
// 设置是否为上报进程
      CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
// 初始化Bugly*/
        CrashReport.initCrashReport(getApplicationContext(), "d59081eac6",false);
// 如果通过“AndroidManifest.xml”来配置APP信息，初始化方法如下
// CrashReport.initCrashReport(context, strategy);

       // CrashReport.testJavaCrash();

        if (LeakCanary.isInAnalyzerProcess(this)) {//1
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);





        UMConfigure.init(this, "5f2c0445d30932215475adb3", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
        UMConfigure.setLogEnabled(true);

    }

}
