package com.example.shopping.classification.goodslie;


import com.example.shopping.classification.Beans;

import java.util.ArrayList;

public interface GoodsCallback {
    void OnSuccess(ArrayList<Beans.DataBean> data);
    void onFail(String string);
}
