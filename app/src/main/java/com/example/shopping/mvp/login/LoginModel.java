package com.example.shopping.mvp.login;

import android.content.Context;
import android.util.Log;

import com.example.mvplibrary.model.BaseModel;
import com.example.mylibrary.HttpGlobaConfig;
import com.example.mylibrary.HttpManager;
import com.example.mylibrary.ResponseInterceper;
import com.example.mylibrary.callback.BaseCallBack;
import com.example.mylibrary.client.HttpClient;
import com.example.mylibrary.server.ApiServer;
import com.example.mylibrary.utils.JsonUtils;
import com.example.shopping.HttpCallBack;
import com.example.shopping.bean.login.CreateBadyBean;
import com.example.shopping.bean.login.DataBean;
import com.example.shopping.bean.login.LoginBean;
import com.example.shopping.bean.login.LoginBodyBean;
import com.example.shopping.bean.login.UserBean;
import com.example.shopping.utils.SPUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginModel implements BaseModel {


    private int status;

    public void toLogins(LoginCallback callback, String name, String psw) {
        LoginBodyBean bean = new LoginBodyBean(name, psw, "1314521");
        HashMap<String, Object> map = new HashMap<>();
        map.put("Content-Type","application/json");

        new HttpClient.Builder()
                .post()
                .setHeadres(map)
                .setApiUrl("userCenter/login")
                .setJsonBody(JsonUtils.classToJson(bean),true)
                .build()
                .request(new BaseCallBack<UserBean>() {
                    @Override
                    protected UserBean onConvert(String result) {
                        try {
                            JSONObject jsonObject=new JSONObject(result);
                            status = jsonObject.getInt("status");
                            if(status==0){
                                JSONObject data = jsonObject.getJSONObject("data");
                                UserBean userBean = JsonUtils.jsonToClass(data.toString(), UserBean.class);
                                SPUtil.putDefDataByApply("spsp",userBean.getId());
                                SPUtil.putDefDataByApply("name",userBean.getUserName());
                                return userBean;
                            }else if(status==-1){
                                onError(jsonObject.getString("message"),status);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    public boolean isCodeSuccess() {
                        return status==0;
                    }

                    @Override
                    public void onSuccess(UserBean userBean) {
                        Log.e("liangxq", "onSuccess: "+userBean.toString() );
                       // modelBaseCallback.onSucess(userBean);
                        callback.onSucceet(userBean.getUserName(),userBean.getPushId());
                    }

                    @Override
                    public UserBean convert(JsonElement result) {
                        return null;
                    }
                    @Override
                    public void onError(String message, int code) {
                        Log.e("liangxq", "onError: "+message );
                       // modelBaseCallback.OnError(message,code);
                        callback.onFail(message);
                    }

                    @Override
                    public void cancle() {

                    }
                });


    }

    public void toCreate(LoginCallback callback, String name, String psw, String yanZen) {
        CreateBadyBean badyBean = new CreateBadyBean(name, psw, yanZen);
        /*HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("Content-Type","application/json");*/
        RequestBody requestBody = null;
        String jsonbody = JsonUtils.classToJson(badyBean);
        String mediaType = "application/json; charset=utf-8";
        requestBody = RequestBody.create(okhttp3.MediaType.parse(mediaType), jsonbody);
        Retrofit build = new Retrofit.Builder()
                .baseUrl("http://169.254.189.205:8080/kotlin/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiServer apiServer = build.create(ApiServer.class);

        HashMap<String, Object> map = new HashMap<>();
        Observable<JsonElement> postjson = apiServer.postjson("userCenter/register", requestBody, map);
        postjson.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonElement>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonElement jsonElement) {
                        LoginBean loginBean = JsonUtils.jsonToClass(jsonElement, LoginBean.class);
                        int status = loginBean.getStatus();
                        if (loginBean.getMessage()!=null){
                            callback.onSucceet(status+"",loginBean.getMessage());
                        }else {
                            callback.onSucceet(status+"","");
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
