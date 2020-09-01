package com.example.shopping.activity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.shopping.R;
import com.example.shopping.evenbus.OnExitZhanghao;
import com.example.shopping.utils.SPUtil;

import org.greenrobot.eventbus.EventBus;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toobar_class;
    private LinearLayout mine_guanli;
    private LinearLayout mine_guanli1;
    private LinearLayout mine_guanli2;
    private Button bt_join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            // getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_setting);
        initView();
    }

    private void initView() {
        toobar_class = (Toolbar) findViewById(R.id.toobar_class);
        toobar_class.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mine_guanli = (LinearLayout) findViewById(R.id.mine_guanli0);
        mine_guanli1 = (LinearLayout) findViewById(R.id.mine_guanli1);
        mine_guanli2 = (LinearLayout) findViewById(R.id.mine_guanli2);
        bt_join = (Button) findViewById(R.id.bt_join);

        bt_join.setOnClickListener(this);
        mine_guanli.setOnClickListener(this);
        mine_guanli1.setOnClickListener(this);
        mine_guanli2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_join:
              SPUtil.putDefDataByApply("spsp",0);
              SPUtil.putDefDataByApply("name","");
                EventBus.getDefault().post(new OnExitZhanghao());
                finish();
                break;
            case R.id.mine_guanli0:
                Toast.makeText(this, "收获管理", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_guanli1:
                Toast.makeText(this, "意见反馈", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_guanli2:
                Toast.makeText(this, "关于", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
