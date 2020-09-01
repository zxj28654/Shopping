package com.example.shopping.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.shopping.R;
import com.example.shopping.fragment.DingdanFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class DingDanActivity extends AppCompatActivity {

    private Toolbar toobar_class;
    private TabLayout tab_dingdan;
    private ViewPager vp_dingdan;
    private ArrayList<String> mList;
    private ArrayList<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ding_dan);
        initView();
    }

    private void initView() {
        toobar_class = (Toolbar) findViewById(R.id.toobar_class);
        tab_dingdan = (TabLayout) findViewById(R.id.tab_dingdan);
        vp_dingdan = (ViewPager) findViewById(R.id.vp_dingdan);

        toobar_class.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        mList = new ArrayList<>();
        initList();
        mFragments = new ArrayList<>();
        for (String ss:mList) {
            mFragments.add(new DingdanFragment());
        }

        vp_dingdan.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()
        ) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mList.get(position);
            }
        });

        tab_dingdan.setupWithViewPager(vp_dingdan);
    }

    private void initList() {
        mList.add("全部");
        mList.add("待付款");
        mList.add("待收货");
        mList.add("待评价");
        mList.add("已取消");
    }
}
