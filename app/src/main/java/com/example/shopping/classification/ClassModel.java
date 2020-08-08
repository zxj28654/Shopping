package com.example.shopping.classification;

import com.example.mvplibrary.model.BaseModel;
import com.example.mylibrary.client.HttpClient;
import com.example.shopping.HttpCallBack;

import java.util.HashMap;
import java.util.Map;

public class ClassModel implements BaseModel {
    public interface CallBack{
        void OnSuccess(ClassBeanData data);
        void onFail(String string);
    }

//http://169.254.1.54:8080/kotlin/category/getCategory
    public void getBeans() {
        new HttpClient.Builder().setBaseUrl("http://169.254.1.54:8080/kotlin/")
                .setApiUrl("category/getCategory")
                .post()
                .setJsonBody("",true)
                .build();
               // .request();

    }


}
