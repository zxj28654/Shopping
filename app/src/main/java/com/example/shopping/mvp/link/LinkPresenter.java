package com.example.shopping.mvp.link;

import com.example.mvplibrary.model.ModleFractory;
import com.example.mvplibrary.presenter.BasePresenter;
import com.example.shopping.classification.LinkBean;

public class LinkPresenter extends BasePresenter<LinkView> implements LinkCallback {

    @Override
    public void OnSuccess(LinkBean.DataBean data) {
        mView.setData(data);
    }

    @Override
    public void onFail(String string) {
        mView.showToast(string);
    }

    public void getBean(int id){
        ModleFractory.creatModle(LinkModel.class).getData(this,id);
    }
}

