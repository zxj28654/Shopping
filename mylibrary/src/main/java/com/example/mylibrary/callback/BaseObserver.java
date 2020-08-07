package com.example.mylibrary.callback;

import android.text.TextUtils;

import com.example.mylibrary.HttpGlobaConfig;
import com.example.mylibrary.disposable.RequestManagerlml;
import com.example.mylibrary.exception.ApiException;
import com.example.mylibrary.exception.ExeceptionEngine;
import com.example.mylibrary.utils.ThreadUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver implements Observer {
    String tag;
    @Override
    public void onSubscribe(Disposable d) {
        if(!TextUtils.isEmpty(tag)){
            RequestManagerlml.getInstance().add(tag,d);
        }
    }

    @Override
    public void onNext(Object t) {
        if(!TextUtils.isEmpty(tag)){
            RequestManagerlml.getInstance().remove(tag);
        }
    }

    @Override
    public void onError(Throwable e) {
        if(e instanceof ApiException){
            ApiException apiException= (ApiException) e;
            onError(apiException.getMesg(),apiException.getCode());
        }else{
            onError("未知异常", ExeceptionEngine.UN_KONWN_ERROR);
        }
        if(!TextUtils.isEmpty(tag)){
            RequestManagerlml.getInstance().remove(tag);
        }
    }

    @Override
    public void onComplete() {
        if(!RequestManagerlml.getInstance().isDispose(tag)){
            RequestManagerlml.getInstance().cancle(tag);
        }
    }

    //回调错错误信息
    public abstract void onError(String message, int code);


    public abstract void cancle();


    //网络请求取消
    public void canclend(){
        if(!ThreadUtils.isMainThread()){
            HttpGlobaConfig.getInstance().getHandler().post(new Runnable() {
                @Override
                public void run() {
                    cancle();
                }
            });
        }
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
}
