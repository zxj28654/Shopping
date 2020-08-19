package com.example.shopping.mvp.link;

import com.example.mvplibrary.view.BaseView;
import com.example.shopping.classification.LinkBean;

public interface LinkView extends BaseView {
    void setData(LinkBean.DataBean linkBean);

}
