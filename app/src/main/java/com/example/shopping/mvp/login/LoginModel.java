package com.example.shopping.mvp.login;

import com.example.mvplibrary.model.BaseModel;
import com.example.mylibrary.HttpGlobaConfig;
import com.example.mylibrary.client.HttpClient;
import com.example.mylibrary.utils.JsonUtils;
import com.example.shopping.bean.login.DataBean;
import com.google.gson.JsonElement;

import java.util.HashMap;

import retrofit2.Retrofit;

public class LoginModel implements BaseModel {




    public void toLogins(LoginCallback callback, String name, String psw) {

    }

    public void toCreate(LoginCallback callback, String name, String psw, String yanZen) {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("Content-Type","application/json");
        new HttpClient.Builder()
                .post()
                .setApiUrl("userCenter/register")
                .setHeadres(stringObjectHashMap)
                .setJsonBody("{\"mobile\":\"1553439217\",\"pwd\":\"28654\",\"verifyCode\":\"123456\"}",true)
                .equals(new LoginHttpCallBack<DataBean>(){

                    @Override
                    public void onError(String message, int code) {
                        callback.onFail(message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(DataBean dataBean) {
                        if (dataBean==null){
                            callback.onSucceet("注册成功");
                        }else {
                            callback.onSucceet(dataBean.getUserName());
                        }

                    }

                    @Override
                    public DataBean convert(JsonElement result) {
                        DataBean dataBean = JsonUtils.jsonToClass(result, DataBean.class);
                        return dataBean;
                    }
                });
    }
}
