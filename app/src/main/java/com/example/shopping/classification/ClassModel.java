package com.example.shopping.classification;

import android.util.Log;

import com.example.mvplibrary.model.BaseModel;
import com.example.mylibrary.client.HttpClient;
import com.example.mylibrary.utils.JsonUtils;
import com.example.mylibrary.utils.LogUtils;
import com.example.shopping.HttpCallBack;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassModel implements BaseModel {

//http://169.254.1.54:8080/kotlin/category/getCategory
    public void getBeans(CallbackClass callbackClass,int page) {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("Content-Type","application/json");

        new HttpClient.Builder()
                //.setBaseUrl("http://169.254.202.146:8080/kotlin/")
                .setApiUrl("category/getCategory")
                .post()
                .setHeadres(stringObjectHashMap)
                .setJsonBody("{parentId:"+page+"}",true)
                .build()
                .request(new ClassHttpCallback<ArrayList<Beann.DataBean>>() {


                    @Override
                    public void onSuccess(ArrayList<Beann.DataBean> data) {
                       // Log.i("111",data.get(0).getCategoryName());
                        callbackClass.OnSuccess(data);

                    }

                    @Override
                    public ArrayList<Beann.DataBean> convert(JsonElement result) {
                        List<Beann.DataBean> dataBeans = JsonUtils.jsonToClassList(result, Beann.DataBean.class);
                        return (ArrayList<Beann.DataBean>) dataBeans;
                    }

                    @Override
                    public void onError(String message, int code) {
                       // Log.i("111222",message);
                        callbackClass.onFail(message);
                    }

                    @Override
                    public void cancle() {

                    }
                });
    }


}
