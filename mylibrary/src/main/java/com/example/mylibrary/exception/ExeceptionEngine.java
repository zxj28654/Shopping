package com.example.mylibrary.exception;

import android.util.MalformedJsonException;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

import javax.net.ssl.SSLHandshakeException;

import retrofit2.HttpException;

public class ExeceptionEngine {
    public static final int UN_KONWN_ERROR=1000;
    public static final int ANALYTIC_SERVER_DATA_ERROR=1001;
    public static final int ANALYTIC_CLIENT_DATA_ERROR=1002;
    public static final int CONNECT_ERROR=1003;
    public static final int TIME_OUT_ERROR=1004;
    public static ApiException handelExeceptipn(Throwable e){
        ApiException ex;
        if (e instanceof HttpException){
            HttpException httpExcep= (HttpException) e;
            ex=new ApiException("网络错误"+e.getMessage(),httpExcep.code());
            return ex;
        }else if (e instanceof ServerException){
            ServerException serverExce= (ServerException) e;
            ex=new ApiException(serverExce.getMsg(),serverExce.getCode());
            return ex;
        }else if (e instanceof JsonParseException || e instanceof JSONException
        || e instanceof ParseException
         || e instanceof MalformedJsonException){
            ex=new ApiException("网络解析错误"+e.getMessage(),ANALYTIC_SERVER_DATA_ERROR);
            return ex;
        }else if (e instanceof ConnectException || e instanceof SSLHandshakeException || e instanceof UnknownHostException) {//连接网络错误
            ex = new ApiException("连接失败"+e.getMessage(), CONNECT_ERROR);
            return ex;
        } else if (e instanceof SocketTimeoutException) {//网络超时
            ex = new ApiException("网络超时"+e.getMessage(), TIME_OUT_ERROR);
            return ex;
        } else {  //未知错误
            ex = new ApiException("未知错误"+e.getMessage(), UN_KONWN_ERROR);
            return ex;
        }
    }


}
