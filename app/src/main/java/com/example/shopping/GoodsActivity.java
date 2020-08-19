package com.example.shopping;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvplibrary.base.BaseMvpActivity;
import com.example.mvplibrary.presenter.BasePresenter;
import com.example.shopping.adapter.RcyGoodslAdapter;
import com.example.shopping.classification.Beans;
import com.example.shopping.classification.goodslie.GoodsPresenter;
import com.example.shopping.classification.goodslie.GoodsView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsActivity extends BaseMvpActivity<GoodsView,GoodsPresenter> implements GoodsView {


    @BindView(R.id.toobar_goods)
    Toolbar toobarGoods;
    @BindView(R.id.rcy_goods)
    RecyclerView rcy;
    private ArrayList<Beans.DataBean> mDataBeans;
    private RcyGoodslAdapter mRcyGoodslAdapter;

    @Override
    protected void initData() {
        initVIew();
        initRcy();
        mPresenter.getDataBean(getIntent().getIntExtra("id", 0));
    }

    private void initRcy() {
        toobarGoods.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        rcy.setLayoutManager(new GridLayoutManager(this,2));
        mDataBeans = new ArrayList<>();
        mRcyGoodslAdapter = new RcyGoodslAdapter(this,mDataBeans);

        rcy.setAdapter(mRcyGoodslAdapter);
        mRcyGoodslAdapter.setOnclickClasss(new RcyGoodslAdapter.OnclickClasss() {
            @Override
            public void onClickcliss(Beans.DataBean bean) {
                Intent intent = new Intent(GoodsActivity.this, GoodsLinkActivity.class);
                intent.putExtra("bean",bean);
                startActivity(intent);
            }
        });

    }

    private void initVIew() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
           // getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    @Override
    protected int initLayoutId() {
        return R.layout.activity_goods;
    }





    @Override
    public void setData(ArrayList<Beans.DataBean> classBeanData) {
       if (classBeanData.size()>0){
            mDataBeans.addAll(classBeanData);
            mRcyGoodslAdapter.notifyDataSetChanged();
       }
    }

    @Override
    public void showToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected GoodsPresenter initPresenter() {
        return new GoodsPresenter();
    }
}
