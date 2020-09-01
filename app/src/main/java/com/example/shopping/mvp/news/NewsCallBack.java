package com.example.shopping.mvp.news;

import com.example.shopping.bean.news.MsgInfoBean;

import java.util.ArrayList;

public interface NewsCallBack {
    void onSuccees(ArrayList<MsgInfoBean> list);
    void onFail(String s);
}
