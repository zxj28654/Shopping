package com.example.shopping.classification.goodslie;

import com.example.mvplibrary.model.ModleFractory;
import com.example.mvplibrary.presenter.BasePresenter;
import com.example.shopping.classification.Beann;
import com.example.shopping.classification.Beans;
import com.example.shopping.classification.ClassModel;

import java.util.ArrayList;

public class GoodsPresenter extends BasePresenter<GoodsView> implements GoodsCallback {

    @Override
    public void OnSuccess(ArrayList<Beans.DataBean> data) {
        mView.setData(data);
    }

    @Override
    public void onFail(String string) {
        mView.showToast(string);
    }

    public void getDataBean(int page) {
        GoodsModel goodsModel = ModleFractory.creatModle(GoodsModel.class);
        goodsModel.getBeans(this,page);
    }
}
