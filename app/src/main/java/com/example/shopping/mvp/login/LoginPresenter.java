package com.example.shopping.mvp.login;

import android.text.TextUtils;
import android.widget.TextView;

import com.example.mvplibrary.model.ModleFractory;
import com.example.mvplibrary.presenter.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginView> implements LoginCallback {
    @Override
    public void onSucceet(String str) {
    mView.setStri(str);
    }

    @Override
    public void onFail(String str) {
mView.showToast(str);
    }

    public void toJoin() {
        String name = mView.getName();
        String psw = mView.getPsw();
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(psw)){

            ModleFractory.creatModle(LoginModel.class).toLogins(this,name,psw);
        }else {
            mView.showToast("用户名或密码不能为空!");
        }
    }

    public void toCreate() {
        String name = mView.getName();
        String psw = mView.getPsw();
        String yanZen = mView.getYanZen();
        String repsw = mView.getRepsw();
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(psw)&& !TextUtils.isEmpty(repsw)){
            if (!TextUtils.isEmpty(yanZen)){
                if (psw.equals(repsw)){
                    ModleFractory.creatModle(LoginModel.class).toCreate(this,name,psw,yanZen);
                }else {
                    mView.showToast("两次密码输入不一致!");
                }
            }else {
                mView.showToast("验证码不能为空!");
            }
        }else {
            mView.showToast("用户名或密码不能为空!");
        }
    }
}
