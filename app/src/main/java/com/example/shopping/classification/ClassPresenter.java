package com.example.shopping.classification;

import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.example.mvplibrary.model.ModleFractory;
import com.example.mvplibrary.presenter.BasePresenter;
import com.example.mvplibrary.view.BaseView;

public class ClassPresenter extends BasePresenter<ClassView> implements ClassModel.CallBack{
    @Override
    public void OnSuccess(ClassBeanData data) {

    }

    @Override
    public void onFail(String string) {

    }

    public void getDataBean() {
        ClassModel classModel = ModleFractory.creatModle(ClassModel.class);
        classModel.getBeans();
    }
}
