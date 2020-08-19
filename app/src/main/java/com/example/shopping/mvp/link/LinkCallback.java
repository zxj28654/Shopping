package com.example.shopping.mvp.link;


import com.example.shopping.classification.LinkBean;

import java.util.ArrayList;

public interface LinkCallback {
    void OnSuccess(LinkBean.DataBean data);
    void onFail(String string);
}
