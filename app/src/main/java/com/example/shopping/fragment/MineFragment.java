package com.example.shopping.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shopping.R;
import com.example.shopping.activity.LoginActivity;

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

        tou.setOnClickListener(this);
        join.setOnClickListener(this);
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
                break;
            case R.id.tv_mine_join:
                startActivityForResult(new Intent(getActivity(), LoginActivity.class),100);
                break;
            case R.id.mine_wait_pay:
                break;
            case R.id.mine_confirm:
                break;
            case R.id.mine_completed:
                break;
            case R.id.mine_order:
                break;
            case R.id.mine_guanli:
                break;
            case R.id.mine_share:
                break;
            case R.id.mine_seting:
                break;


        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100 && resultCode==200){
            String name = data.getStringExtra("name");
            join.setText(name);
        }
    }
}
