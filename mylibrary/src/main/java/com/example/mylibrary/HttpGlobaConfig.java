package com.example.mylibrary;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;

public class HttpGlobaConfig {
    //baseUrl
    private String baseUrl;
    private long timeOut;
    private TimeUnit mTimeUnit;
    //公共请求参数
    private Map<String,Object> baseparams;
    //公共请求头信息
    private Map<String,Object> baseHeades;
    //公共的拦截器
    private ArrayList<Interceptor> mInterceptors;
    //日志开关
    private boolean isShowLog;
    private Context mContext;
    private Handler mHandler;

    private HttpGlobaConfig(){

    }
    private static final class HttpGlobaConfigHoder{
        private static HttpGlobaConfig INSTANCE=new HttpGlobaConfig();
    }

    public static HttpGlobaConfig getInstance(){
        return HttpGlobaConfigHoder.INSTANCE;
    }

  public String getBaseUrl(){
        return baseUrl;
  }
   public HttpGlobaConfig setBaseUrl(String baseUrl){
        this.baseUrl=baseUrl;
        return HttpGlobaConfig.getInstance();
   }

    public long getTimeOut() {
        return timeOut;
    }

    public HttpGlobaConfig setTimeOut(long timeOut) {
        this.timeOut = timeOut;
        return HttpGlobaConfig.getInstance();
    }

    public TimeUnit getTimeUnit() {
        return mTimeUnit;
    }

    public HttpGlobaConfig setTimeUnit(TimeUnit timeUnit) {
        mTimeUnit = timeUnit;
        return HttpGlobaConfig.getInstance();

    }

    public Context getContext() {
        return mContext;
    }

    public Handler getHandler() {
        return mHandler;
    }

    public Map<String, Object> getBaseparams() {
        return baseparams;
    }

    public HttpGlobaConfig setBaseparams(Map<String, Object> baseparams) {
        this.baseparams = baseparams;
        return HttpGlobaConfig.getInstance();
    }

    public Map<String, Object> getBaseHeades() {
        return baseHeades;
    }

    public HttpGlobaConfig setBaseHeades(Map<String, Object> baseHeades) {
        this.baseHeades = baseHeades;
        return HttpGlobaConfig.getInstance();
    }


    public ArrayList<Interceptor> getInterceptors() {
        return mInterceptors;
    }

    public HttpGlobaConfig setInterceptors(ArrayList<Interceptor> interceptors) {
        mInterceptors = interceptors;
        return HttpGlobaConfig.getInstance();
    }

    public boolean isShowLog() {
        return isShowLog;
    }

    public HttpGlobaConfig setShowLog(boolean showLog) {
        isShowLog = showLog;
        return HttpGlobaConfig.getInstance();
    }

    public HttpGlobaConfig initReady(Context context) {
        this.mContext=context.getApplicationContext();
        mHandler=new Handler(Looper.getMainLooper());
        return HttpGlobaConfig.getInstance();
    }
}
