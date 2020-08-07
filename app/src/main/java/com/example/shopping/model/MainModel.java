package com.example.shopping.model;

import android.util.Log;

import com.example.mvplibrary.model.BaseModel;
import com.example.mvplibrary.view.BaseView;
import com.example.mylibrary.client.HttpClient;
import com.example.shopping.HttpCallBack;
import com.example.shopping.bean.Demo1;
import com.example.shopping.net.MianCallBack;
import com.example.shopping.presenter.MainPresenter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class MainModel implements BaseModel {


    public void getDatas(MianCallBack callBack) {
        new HttpClient.Builder()
                //.setBaseUrl("http://apie.ergedd.com/")
                // .setApiUrl("article/listproject/0/json")
                .setApiUrl("api/v1/albums/1")
                // .post()
                //.setJsonBody("",true)
                .get()
                .build()
                .request(new HttpCallBack<Demo1>() {
                    @Override
                    public void onError(String message, int code) {
                        Log.e("111", "onError: "+message);
                        callBack.onFail(message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(Demo1 demo) {
                        callBack.onSuccess(demo);
                        Log.e("111", "onSuccess: "+demo.toString());
                    }

                    @Override
                    public Demo1 convert(JsonElement result) {
                        return new Gson().fromJson(result,Demo1.class);
                    }
                });

    }
}
