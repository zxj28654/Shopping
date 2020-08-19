package com.example.shopping.classification.goodslie;

import android.util.Log;

import com.example.mvplibrary.model.BaseModel;
import com.example.mylibrary.client.HttpClient;
import com.example.mylibrary.utils.JsonUtils;
import com.example.shopping.classification.Beann;
import com.example.shopping.classification.Beans;
import com.example.shopping.classification.CallbackClass;
import com.example.shopping.classification.ClassHttpCallback;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GoodsModel implements BaseModel {
    public void getBeans(GoodsCallback callbackClass, int page) {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("Content-Type","application/json");
        Log.i("333","3333333333"+page);
        new HttpClient.Builder()
                //.setBaseUrl("http://169.254.202.146:8080/kotlin/")
                .setApiUrl("goods/getGoodsList")
                .post()
                .setHeadres(stringObjectHashMap)
                .setJsonBody("{categoryId:"+page+",pageNo:1}",true)
                .build()
                .request(new GoodsHttpCallBack<ArrayList<Beans.DataBean>>() {


                    @Override
                    public void onSuccess(ArrayList<Beans.DataBean> data) {
                         Log.i("111",data.get(0).getGoodsDesc());
                        callbackClass.OnSuccess(data);

                    }

                    @Override
                    public ArrayList<Beans.DataBean> convert(JsonElement result) {
                        List<Beans.DataBean> dataBeans = JsonUtils.jsonToClassList(result, Beans.DataBean.class);
                        return (ArrayList<Beans.DataBean>) dataBeans;
                    }

                    @Override
                    public void onError(String message, int code) {
                         Log.i("111222",message);
                        callbackClass.onFail(message);
                    }

                    @Override
                    public void cancle() {

                    }
                });
    }

}
