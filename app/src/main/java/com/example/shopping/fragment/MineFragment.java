package com.example.shopping.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopping.MainActivity;
import com.example.shopping.R;
import com.example.shopping.activity.AdreassActivity;
import com.example.shopping.activity.DingDanActivity;
import com.example.shopping.activity.LoginActivity;
import com.example.shopping.activity.MyCenterActivity;
import com.example.shopping.activity.SettingActivity;
import com.example.shopping.evenbus.OnExitZhanghao;
import com.example.shopping.utils.SPUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment implements View.OnClickListener{

    private ImageView tou;
    private TextView join;
    private LinearLayout pay;
    private LinearLayout confirm;
    private LinearLayout completed;
    private LinearLayout order;
    private LinearLayout guanli;
    private LinearLayout share;
    private LinearLayout seting;
    private volatile Integer mSpsp1;

    public MineFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_mine, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        tou = (ImageView) inflate.findViewById(R.id.iv_mine_tou);
        join = (TextView) inflate.findViewById(R.id.tv_mine_join);
        pay = (LinearLayout) inflate.findViewById(R.id.mine_wait_pay);
        confirm = (LinearLayout) inflate.findViewById(R.id.mine_confirm);
        completed = (LinearLayout) inflate.findViewById(R.id.mine_completed);
        order = (LinearLayout) inflate.findViewById(R.id.mine_order);
        guanli = (LinearLayout) inflate.findViewById(R.id.mine_guanli);
        share = (LinearLayout) inflate.findViewById(R.id.mine_share);
        seting = (LinearLayout) inflate.findViewById(R.id.mine_seting);
        mSpsp1 = SPUtil.getDefData("spsp", 0);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSpsp1 !=0){
                    startActivity(new Intent(getActivity(), MyCenterActivity.class));
                }else {
                    startActivityForResult(new Intent(getActivity(), LoginActivity.class),100);
                }


            }
        });
        if (mSpsp1 !=0){
            String name = SPUtil.getDefData("name", "");
            join.setText(name);

        }else {


        }
        tou.setOnClickListener(this);
       // join.setOnClickListener(this);
        pay.setOnClickListener(this);
        confirm.setOnClickListener(this);
        completed.setOnClickListener(this);
        order.setOnClickListener(this);
        guanli.setOnClickListener(this);
        share.setOnClickListener(this);
        seting.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_mine_tou:
                if (mSpsp1!=0){
                    startActivity(new Intent(getActivity(), MyCenterActivity.class));
                }else {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.mine_wait_pay:
                startActivity(new Intent(getActivity(), DingDanActivity.class));
                break;
            case R.id.mine_confirm:
                startActivity(new Intent(getActivity(), DingDanActivity.class));
                break;
            case R.id.mine_completed:
                startActivity(new Intent(getActivity(), DingDanActivity.class));
                break;
            case R.id.mine_order:
                startActivity(new Intent(getActivity(), DingDanActivity.class));
                break;
            case R.id.mine_guanli:
                startActivity(new Intent(getActivity(), AdreassActivity.class));
                break;
            case R.id.mine_share:
                Toast.makeText(getActivity(), "敬请期待", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_seting:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;


        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100 && resultCode==200){
            String name = data.getStringExtra("name");
            join.setText(name);
            mSpsp1=SPUtil.getDefData("spsp", 0);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void exit(OnExitZhanghao onExitZhanghao){
        join.setText("登录/注册");
       mSpsp1=SPUtil.getDefData("spsp", 0);

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
