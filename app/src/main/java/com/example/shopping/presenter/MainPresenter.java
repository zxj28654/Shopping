package com.example.shopping.presenter;

import com.example.mvplibrary.model.ModleFractory;
import com.example.mvplibrary.presenter.BasePresenter;
import com.example.mvplibrary.view.BaseView;
import com.example.shopping.bean.Demo1;
import com.example.shopping.model.MainModel;
import com.example.shopping.net.MianCallBack;
import com.example.shopping.view.MainView;
import com.trello.rxlifecycle2.LifecycleProvider;

public class MainPresenter extends BasePresenter<MainView> implements MianCallBack {

    @Override
    public void onSuccess(Demo1 demo1) {
        mView.setData(demo1);
    }

    @Override
    public void onFail(String string) {
        mView.showToast(string);
    }

    public void getBeans() {
        MainModel modle = ModleFractory.creatModle(MainModel.class);
        modle.getDatas(this);

    }

}
