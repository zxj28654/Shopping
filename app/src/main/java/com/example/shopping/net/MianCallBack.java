package com.example.shopping.net;

import com.example.shopping.bean.Demo1;

public interface MianCallBack {
    void onSuccess(Demo1 demo1);
    void onFail(String string);
}
