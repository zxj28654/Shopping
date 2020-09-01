package com.example.shopping.mvp.news;

import android.util.Log;

import com.example.mvplibrary.model.BaseModel;
import com.example.mylibrary.callback.BaseCallBack;
import com.example.mylibrary.client.HttpClient;
import com.example.mylibrary.utils.JsonUtils;
import com.example.shopping.bean.login.LoginBean;
import com.example.shopping.bean.news.MsgInfoBean;
import com.example.shopping.utils.SPUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NewaModel implements BaseModel {

    public void getLists(NewsCallBack callBack) {
        Integer spsp = SPUtil.getDefData("spsp", 0);
        HashMap<String, Object> map = new HashMap<>();
        map.put("token",spsp);

        new HttpClient.Builder()
                .post()
                .setHeadres(map)
                .setApiUrl("msg/getList")
                .build()
                .request(new BaseCallBack() {
                    @Override
                    protected Object onConvert(String result) {
                        return result;
                    }

                    @Override
                    public boolean isCodeSuccess() {
                        return true;
                    }

                    @Override
                    public void onSuccess(Object o) {
                        LoginBean loginBean = new Gson().fromJson((String) o, LoginBean.class);
                        Log.e("654",loginBean.toString());
                        if (loginBean.getStatus()==0){

                            JsonElement data = loginBean.getData();
                            List<MsgInfoBean> msgInfoBeans = JsonUtils.jsonToClassList(data, MsgInfoBean.class);
                            callBack.onSuccees((ArrayList<MsgInfoBean>) msgInfoBeans);
                        }else {
                            onError(loginBean.getMessage(),-1);
                        }
                    }

                    @Override
                    public Object convert(JsonElement result) {
                        return null;
                    }

                    @Override
                    public void onError(String message, int code) {
                        callBack.onFail(message);
                    }

                    @Override
                    public void cancle() {

                    }
                });
    }
}
