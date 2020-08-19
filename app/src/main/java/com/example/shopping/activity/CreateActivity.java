package com.example.shopping.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.mvplibrary.base.BaseMvpActivity;
import com.example.shopping.R;
import com.example.shopping.mvp.login.LoginPresenter;
import com.example.shopping.mvp.login.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateActivity extends BaseMvpActivity<LoginView, LoginPresenter> implements LoginView {


    @BindView(R.id.toobar_class)
    Toolbar toobarClass;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.yanzheng)
    TextView yanzheng;
    @BindView(R.id.et_yanma)
    EditText etYanma;
    @BindView(R.id.et_psw)
    EditText etPsw;
    @BindView(R.id.et_repsw)
    EditText etRepsw;
    @BindView(R.id.bt_create)
    Button btCreate;

    @Override
    protected void initData() {
        btCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.toCreate();
            }
        });
    }

    @Override
    protected int initLayoutId() {
        return R.layout.activity_create;
    }

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    public String getName() {
        return etPhone.getText().toString().trim();
    }

    @Override
    public String getPsw() {
        return etPsw.getText().toString().trim();
    }

    @Override
    public String getRepsw() {
        return etRepsw.getText().toString().trim();
    }

    @Override
    public String getYanZen() {
        return etYanma.getText().toString().trim();
    }

    @Override
    public void setStri(String sri) {
        Toast.makeText(this, sri, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            // getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

    }
}
