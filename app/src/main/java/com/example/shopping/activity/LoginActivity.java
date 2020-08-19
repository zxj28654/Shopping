package com.example.shopping.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.example.mvplibrary.base.BaseMvpActivity;
import com.example.shopping.R;
import com.example.shopping.mvp.login.LoginPresenter;
import com.example.shopping.mvp.login.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseMvpActivity<LoginView, LoginPresenter> implements LoginView {


    @BindView(R.id.toobar_class)
    Toolbar toobarClass;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_psw)
    EditText etPsw;
    @BindView(R.id.bt_join)
    Button btJoin;
    @BindView(R.id.wangjipsw)
    TextView wangjipsw;
    @BindView(R.id.create)
    TextView create;

    @Override
    protected void initData() {

        toobarClass.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(LoginActivity.this,CreateActivity.class),10);
            }
        });
        btJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.toJoin();
            }
        });
    }


    @Override
    protected int initLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    public String getName() {
        return etName.getText().toString().trim();
    }

    @Override
    public String getPsw() {
        return etPsw.getText().toString().trim();
    }

    @Override
    public String getRepsw() {
        return null;
    }

    @Override
    public String getYanZen() {
        return null;
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==10 && resultCode==20){
            String name = data.getStringExtra("name");
            String psw = data.getStringExtra("psw");
            etName.setText(name);
            etPsw.setText(psw);
        }
    }
}
