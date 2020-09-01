package com.example.shopping.mvp.news;

import com.example.mvplibrary.view.BaseView;
import com.example.shopping.bean.news.MsgInfoBean;

import java.util.ArrayList;

public interface NewsView extends BaseView {
    void setData(ArrayList<MsgInfoBean> list);
}
