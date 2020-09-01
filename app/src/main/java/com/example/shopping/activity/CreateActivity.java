package com.example.shopping.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import com.example.mvplibrary.base.BaseMvpActivity;
import com.example.shopping.R;
import com.example.shopping.mvp.login.LoginPresenter;
import com.example.shopping.mvp.login.LoginView;

import java.util.Timer;
import java.util.TimerTask;

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
    private Timer mTimer;
    private int i=1;
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
         if (msg.what==1){

             i++;
             if (i<=60){
                 yanzheng.setText(" "+i+"秒 ");
             }else {
                 yanzheng.setText("重新获取");
                 i=1;
                 mTimer.cancel();
             }
         }
        }
    };
    @Override
    protected void initData() {
        toobarClass.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        yanzheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTimer = new Timer();
                initTimer();
            }
        });
        btCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.toCreate();
            }
        });


    }


    private void initTimer() {
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(1);
            }
        },500,1000);

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
    public void setStri(String sri,String string) {
        int i = Integer.parseInt(sri);
        if (i==0){
            showToast("注册成功");
            Intent intent = getIntent().putExtra("name", etPhone.getText().toString().trim())
                    .putExtra("psw", etPsw.getText().toString().trim());
            setResult(20,intent);
            finish();
        }else {
            showToast(string);
        }

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
    protected void onDestroy() {
        super.onDestroy();
        if (mTimer!=null){
            mTimer.cancel();
        }
    }
}
