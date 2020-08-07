package com.example.shopping;

import android.util.Log;

import com.example.mylibrary.callback.BaseCallBack;
import com.example.mylibrary.exception.ApiException;
import com.example.shopping.bean.EegeddBean;
import com.example.shopping.bean.Response;
import com.google.gson.Gson;
import com.google.gson.JsonElement;


public abstract class HttpCallBack<T> extends BaseCallBack<T> {
   // Response response;
    EegeddBean mEegeddBean;
    @Override
    protected T onConvert(String result) {
        T t=null;
       // response = new Gson().fromJson(result, Response.class);
        mEegeddBean = new Gson().fromJson(result, EegeddBean.class);
        JsonElement data = mEegeddBean.getData();
        boolean success = mEegeddBean.isSuccess();
        String errorMsg = mEegeddBean.getMessage();
      /*  switch (errorCode) {
            case -1:
                onError(errorMsg,errorCode);
                break;
            default:
                if (isCodeSuccess()) {
                    t=convert(data);
                }
                break;
        }*/

      if (success){
          if (isCodeSuccess()) {
              t=convert(data);
          }
      }else {
          onError(errorMsg, 1000);
      }
        Log.i("111", "onConvert: "+t.toString() );
        return t;
    }


    @Override
    public boolean isCodeSuccess() {
       /* if (response != null) {
            return response.getErrorCode() == 0;
        }*/
       if (mEegeddBean!=null){
           return mEegeddBean.isSuccess() == true;
       }
        return false;
    }

}
