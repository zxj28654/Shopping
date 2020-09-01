package com.example.shopping.mvp.news;

import com.example.mvplibrary.model.ModleFractory;
import com.example.mvplibrary.presenter.BasePresenter;
import com.example.shopping.bean.news.MsgInfoBean;

import java.util.ArrayList;

public class NewsPresenter extends BasePresenter<NewsView> implements NewsCallBack {

    @Override
    public void onSuccees(ArrayList<MsgInfoBean> list) {
        mView.setData(list);
    }

    @Override
    public void onFail(String s) {
        mView.showToast(s);
    }

    public void getDatas() {
        NewaModel newaModel = ModleFractory.creatModle(NewaModel.class);
        newaModel.getLists(this);

    }
}
