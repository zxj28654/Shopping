package com.example.shopping;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.shopping.fragment.ClassificationFragment;
import com.example.shopping.fragment.HomeFragment;
import com.example.shopping.fragment.MineFragment;
import com.example.shopping.fragment.NewsFragment;
import com.example.shopping.fragment.ShoppingCartFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
{
    private FrameLayout fl;
    private BottomNavigationBar buttonnavig;
    private BadgeItem badgeItem;
    private ArrayList<Fragment> mFragments;
    private FragmentManager fm;
    private volatile int lastPosition;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPmismmer();
     /*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }*/
        initView();

    }

    private void initPmismmer() {
        int i = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (i!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA
            },100);
        }
    }

    private void initView() {

        fl = (FrameLayout) findViewById(R.id.fl);
        buttonnavig = (BottomNavigationBar) findViewById(R.id.buttonnavig);
        mFragments = new ArrayList<>();
        initFragment();

        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.fl,mFragments.get(0)).add(R.id.fl,mFragments.get(1)).hide(mFragments.get(1))
                .add(R.id.fl,mFragments.get(2)).hide(mFragments.get(2))
                .add(R.id.fl,mFragments.get(3)).hide(mFragments.get(3))
                .add(R.id.fl,mFragments.get(4)).hide(mFragments.get(4))
                .commit();
        badgeItem = new BadgeItem().setBackgroundColor(Color.RED).setText("0");
        buttonnavig.setMode(BottomNavigationBar.MODE_FIXED);
        buttonnavig.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        buttonnavig.setBarBackgroundColor(R.color.bai);
        buttonnavig.addItem(new BottomNavigationItem(R.drawable.btn_nav_home_press, "主页").setActiveColorResource(R.color.lan))
                .addItem(new BottomNavigationItem(R.drawable.btn_nav_category_press, "分类").setActiveColorResource(R.color.lan))
                .addItem(new BottomNavigationItem(R.drawable.btn_nav_cart_press, "购物车").setActiveColorResource(R.color.lan).setBadgeItem(badgeItem))
                .addItem(new BottomNavigationItem(R.drawable.btn_nav_msg_press, "消息").setActiveColorResource(R.color.lan))
                .addItem(new BottomNavigationItem(R.drawable.btn_nav_user_press, "我的").setActiveColorResource(R.color.lan))
                .setFirstSelectedPosition(0)
                .initialise(); //所有的设置需在调用该方法前完成


        buttonnavig.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {//这里也可以使用SimpleOnTabSelectedListener
            @Override
            public void onTabSelected(int position) {//未选中 -> 选中
                switch (position){
                    default:
                        break;
                    case 0:
                        if (lastPosition!=0){
                            hideFragment(lastPosition);
                        }
                      showFragment(position);
                      lastPosition=0;

                        break;
                    case 1:
                        if (lastPosition!=1){
                            hideFragment(lastPosition);
                        }
                        showFragment(position);
                        lastPosition=1;

                        break;
                    case 2:
                        if (lastPosition!=2){
                            hideFragment(lastPosition);
                        }
                        showFragment(position);
                        lastPosition=2;
                        break;
                    case 3:
                        if (lastPosition!=3){
                            hideFragment(lastPosition);
                        }
                        showFragment(position);
                        lastPosition=3;
                        break;
                    case 4:
                        if (lastPosition!=4){
                            hideFragment(lastPosition);
                        }
                        showFragment(position);
                        lastPosition=4;
                        break;
                }
            }

            @Override
            public void onTabUnselected(int position) {//选中 -> 未选中

            }

            @Override
            public void onTabReselected(int position) {//选中 -> 选中

            }
        });

    }

    private void hideFragment(int position) {
        fm.beginTransaction().hide(mFragments.get(position)).commit();
    }

    private void showFragment(int position) {
        fm.beginTransaction().show(mFragments.get(position)).commit();

    }

    private void initFragment() {
        mFragments.add(new HomeFragment());
        mFragments.add(new ClassificationFragment());
        mFragments.add(new ShoppingCartFragment());
        mFragments.add(new NewsFragment());
        mFragments.add(new MineFragment());
    }
}
