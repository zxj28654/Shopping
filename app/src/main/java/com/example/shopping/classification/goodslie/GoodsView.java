package com.example.shopping.classification.goodslie;


import com.example.mvplibrary.view.BaseView;
import com.example.shopping.classification.Beans;

import java.util.ArrayList;

public interface GoodsView extends BaseView {
    void setData(ArrayList<Beans.DataBean> classBeanData);
}
