package com.example.shopping.classification;

import android.util.Log;

import com.example.mylibrary.callback.BaseCallBack;
import com.example.shopping.HttpCallBack;
import com.example.shopping.bean.EegeddBean;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public abstract class ClassHttpCallback<T> extends BaseCallBack<T> {

    GoodsClassBeanParent mGoodsClassBeanParent;
    @Override
    protected T onConvert(String result) {
        T t=null;
        mGoodsClassBeanParent = new Gson().fromJson(result, GoodsClassBeanParent.class);
        JsonElement data = mGoodsClassBeanParent.getData();
        int status = mGoodsClassBeanParent.getStatus();
        String errorMsg = mGoodsClassBeanParent.getMessage();
        switch (status) {
            case -1:
                onError(errorMsg,status);
                break;
            default:
                if (isCodeSuccess()) {
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
