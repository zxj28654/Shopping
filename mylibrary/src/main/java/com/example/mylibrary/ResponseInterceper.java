package com.example.mylibrary;

import android.content.Context;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ResponseInterceper implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        List<String> headers = proceed.headers("Set-Cookie");
        if (headers!=null){
            String s = headers.get(0);
        }
        return proceed;
    }
}
