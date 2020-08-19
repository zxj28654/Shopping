package com.example.shopping;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.shopping.classification.Beans;
import com.example.shopping.classification.gooddslink.LinkFragment;
import com.example.shopping.classification.gooddslink.ShangpingFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class GoodsLinkActivity extends AppCompatActivity  {

    private TabLayout tab_link;
    private Toolbar toobar_goods;
    private ViewPager vp_link;
    private ArrayList<Fragment> mFragments;
    private Beans.DataBean mBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
           // getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_link);
        mBean = (Beans.DataBean) getIntent().getSerializableExtra("bean");
      //  Toast.makeText(this, mBean.getGoodsDesc(), Toast.LENGTH_SHORT).show();
        initView();
        toobar_goods.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void initView() {
        tab_link = (TabLayout) findViewById(R.id.tab_link);
        toobar_goods = (Toolbar) findViewById(R.id.toobar_goods);
        vp_link = (ViewPager) findViewById(R.id.vp_link);

        initVp();


    }

    private void initVp() {
        mFragments = new ArrayList<>();
        mFragments.add(new ShangpingFragment(mBean.getId()));
        mFragments.add(new LinkFragment(mBean.getGoodsDetailOne(),mBean.getGoodsDetailTwo()));
        vp_link.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        });

        tab_link.setupWithViewPager(vp_link);
        tab_link.getTabAt(0).setText("商品");
        tab_link.getTabAt(1).setText("详情");

    }

}
