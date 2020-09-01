package com.example.shopping.mvp.login;

import com.example.mvplibrary.view.BaseView;

public interface LoginView extends BaseView {
    String getName();
    String getPsw();
    String getRepsw();
    String getYanZen();
    void setStri(String sri,String string);

}
