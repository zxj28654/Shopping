package com.example.shopping.mvp.link;

import android.util.Log;

import com.example.mvplibrary.model.BaseModel;
import com.example.mylibrary.client.HttpClient;
import com.example.mylibrary.utils.JsonUtils;
import com.example.shopping.classification.Beann;
import com.example.shopping.classification.ClassHttpCallback;
import com.example.shopping.classification.LinkBean;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LinkModel implements BaseModel {
    public void getData(LinkCallback callback,int id){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("Content-Type","application/json");

        new HttpClient.Builder()
                //.setBaseUrl("http://169.254.202.146:8080/kotlin/")
                .setApiUrl("goods/getGoodsDetail")
                .post()
                .setHeadres(stringObjectHashMap)
                .setJsonBody("{goodsId:"+id+"}",true)
                .build()
                .request(new ClassHttpCallback<LinkBean.DataBean>() {


                    @Override
                    public void onSuccess(LinkBean.DataBean data) {
                       // Log.i("111222","111111111111"+data.toString());
                        callback.OnSuccess(data);

                    }

                    @Override
                    public LinkBean.DataBean convert(JsonElement result) {
                       // Log.i("111222","con"+result.toString());
                        LinkBean.DataBean dataBean = new Gson().fromJson(result, LinkBean.DataBean.class);
                       // Log.i("111222","con"+dataBean.toString());
                        return dataBean;
                    }

                    @Override
                    public void onError(String message, int code) {
                        // Log.i("111222",message);
                        callback.onFail(message);
                    }

                    @Override
                    public void cancle() {

                    }
                });
    }
}
