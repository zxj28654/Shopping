package com.example.shopping.fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.example.shopping.R;
import com.example.shopping.fragment.classfragment.ClassFragment;
import com.example.shopping.fragment.classfragment.TempFragment;

import java.util.ArrayList;

import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.TabView;


/**
 * BaseMvpFragment<ClassView, ClassPresenter> implements ClassView
 */
public class ClassificationFragment extends Fragment {


    private Toolbar toobar_class;
    private VerticalTabLayout tab_ver;
    private ArrayList<Fragment> mFragments;
    private FragmentManager fm;
    private volatile int lastPosition;
    private ClassFragment mClassFragment;


    public ClassificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getActivity(). getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        View view = inflater.inflate(R.layout.fragment_classification, container, false);

        initview(view);
        return view;
    }

    private void initview(View view) {
        tab_ver=view.findViewById(R.id.tab_ver);


        mClassFragment = new ClassFragment(1);
        TempFragment tempFragment = new TempFragment();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("电脑办公");
        strings.add("手机数码");
        strings.add("男装");
        strings.add("女装");
        strings.add("家用电器");
        strings.add("食品生鲜");
        strings.add("酒水饮料");
        strings.add("玩具乐器");
        strings.add("汽车用品");
        strings.add("家具家装");
        strings.add("礼品鲜花");
        strings.add("生活旅行");
        strings.add("二手礼品");

        fm = getChildFragmentManager();
        fm.beginTransaction().add(R.id.framelay,mClassFragment).show(mClassFragment)
                .add(R.id.framelay,tempFragment).hide(tempFragment)
               .commit();

        tab_ver.setTabAdapter(new TabAdapter() {
            @Override
            public int getCount() {
                return strings.size();
            }

            @Override
            public ITabView.TabBadge getBadge(int position) {
                return null;
            }

            @Override
            public ITabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public ITabView.TabTitle getTitle(int position) {
                ITabView.TabTitle title = new ITabView.TabTitle.Builder()
                        .setContent(strings.get(position))
                        .setTextColor(R.color.lans,Color.BLACK)
                        .build();
                return title;
            }

            @Override
            public int getBackground(int position) {
                return 0;
            }
        });

        tab_ver.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {

                if (position>=2){
                    fm.beginTransaction().hide(mClassFragment).show(tempFragment).commit();
                }else {
                    fm.beginTransaction().show(mClassFragment).hide(tempFragment).commit();
                }
                switch (position){
                    case 0:
                        mClassFragment.getPage(1);
                        break;
                    case 1:
                        mClassFragment.getPage(2);
                        break;
                    default:

                        break;

                }
            }

            @Override
            public void onTabReselected(TabView tab, int position) {
                    if (position<2){

                    }
            }
        });
    }




}



