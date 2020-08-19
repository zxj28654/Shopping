package com.example.shopping.classification;

import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.example.mvplibrary.model.ModleFractory;
import com.example.mvplibrary.presenter.BasePresenter;
import com.example.mvplibrary.view.BaseView;

import java.util.ArrayList;

public class ClassPresenter extends BasePresenter<ClassView> implements CallbackClass{
    @Override
    public void OnSuccess(ArrayList<Beann.DataBean> data) {
        mView.setData(data);
    }

    @Override
    public void onFail(String string) {
        mView.showToast(string);
    }

    public void getDataBean(int page) {
        ClassModel classModel = ModleFractory.creatModle(ClassModel.class);
        classModel.getBeans(this,page);
    }
}
