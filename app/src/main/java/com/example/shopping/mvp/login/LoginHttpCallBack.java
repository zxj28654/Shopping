package com.example.shopping.mvp.login;

import android.util.Log;

import com.example.mylibrary.callback.BaseCallBack;
import com.example.mylibrary.utils.JsonUtils;
import com.example.shopping.bean.login.LoginBean;
import com.example.shopping.classification.GoodsClassBeanParent;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public abstract class LoginHttpCallBack<T> extends BaseCallBack<T> {

    LoginBean mGoodsClassBeanParent;
    @Override
    protected T onConvert(String result) {
        T t=null;
        mGoodsClassBeanParent = new Gson().fromJson(result, LoginBean.class);
        int status = mGoodsClassBeanParent.getStatus();

        switch (status) {
            case -1:
                String errorMsg = mGoodsClassBeanParent.getMessage();
                onError(errorMsg,status);
                break;
            default:
                if (isCodeSuccess()) {
                    JsonElement data = mGoodsClassBeanParent.getData();
                    t=convert(data);
                }
                break;
        }


        Log.i("111", "onConvert: "+t.toString() );
        return t;
    }


    @Override
    public boolean isCodeSuccess() {
        if (mGoodsClassBeanParent != null) {
            return mGoodsClassBeanParent.getStatus() == 0;
        }

        return false;
    }
}
