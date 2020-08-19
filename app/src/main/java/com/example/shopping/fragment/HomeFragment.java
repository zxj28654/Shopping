package com.example.shopping.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.shopping.HomeConstant;
import com.example.shopping.R;
import com.example.shopping.adapter.RcyApater;
import com.example.shopping.adapter.VpAdaPter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import me.crosswall.lib.coverflow.CoverFlow;
import me.crosswall.lib.coverflow.core.PageItemClickListener;
import me.crosswall.lib.coverflow.core.PagerContainer;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private View toobarSousuo;
    private View toobar_scan;
    private Banner banner;
    private ViewFlipper vf;
    private RecyclerView rcy;
    private PagerContainer mTopicContainer;
    private ViewPager mTopicPager;

    private ArrayList<String> mStrings;
    private RcyApater mRcyApater;
    private ArrayList<String> listItem;
    private VpAdaPter mVpAdaPter;
    private ArrayList<String> mList;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
           getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        initVIew(view);
        return view;
    }

    private void initVIew(View view) {
        toobarSousuo = view.findViewById(R.id.toobar_sousuo);
        toobar_scan = view.findViewById(R.id.toobar_scan);
        banner = view.findViewById(R.id.banner);
        vf = view.findViewById(R.id.marquee_view);
        rcy = view.findViewById(R.id.rcy);
        mTopicContainer = view.findViewById(R.id.mTopicContainer);
        mTopicPager = view.findViewById(R.id.mTopicPager);

        initBanner();
        initMarquee();
        initRcy();

        initVp();
    }

    private void initVp() {

        LayoutInflater inflater = LayoutInflater.from(getActivity());
        ArrayList<View> views = new ArrayList<>();
        views.add(inflater.inflate(R.layout.vpitem1,null));
        views.add(inflater.inflate(R.layout.vpitem1,null));
        views.add(inflater.inflate(R.layout.vpitem1,null));
        views.add(inflater.inflate(R.layout.vpitem1,null));
        views.add(inflater.inflate(R.layout.vpitem1,null));
        mList = new ArrayList<>();
        mList.add(HomeConstant.HOME_TOPIC_FIVE);
        mList.add(HomeConstant.HOME_TOPIC_FOUR);
        mList.add(HomeConstant.HOME_TOPIC_FIVE);
        mList.add(HomeConstant.HOME_TOPIC_FOUR);
        mList.add(HomeConstant.HOME_TOPIC_FIVE);
        mVpAdaPter = new VpAdaPter(views,getActivity(),mList);
        mTopicPager.setAdapter(mVpAdaPter);
        new CoverFlow.Builder()
                .with(mTopicPager)
                .pagerMargin(0f)
                .scale(0.3f)
                .spaceSize(0f)
                .rotationY(0f)
                .build();


    }

    private void initRcy() {
      //  LinearLayoutManager ms= new LinearLayoutManager(this);
      //  ms.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager ms = new LinearLayoutManager(getActivity());
        ms.setOrientation(LinearLayoutManager.HORIZONTAL);
        rcy.setLayoutManager(ms);
        listItem = new ArrayList<>();
        initListData();
        mRcyApater = new RcyApater(getActivity(),listItem);
        rcy.setAdapter(mRcyApater);
        mRcyApater.notifyDataSetChanged();



    }

    private void initListData() {
        listItem.add(HomeConstant.HOME_DISCOUNT_ONE);
        listItem.add(HomeConstant.HOME_DISCOUNT_TWO);
        listItem.add(HomeConstant.HOME_DISCOUNT_THREE);
        listItem.add(HomeConstant.HOME_DISCOUNT_FOUR);
        listItem.add(HomeConstant.HOME_DISCOUNT_FIVE);
    }

    private void initMarquee() {
        // 为ViewFlipper添加广告条

        vf.addView(View.inflate(getActivity(), R.layout.gonggao1, null));
        vf.addView(View.inflate(getActivity(), R.layout.gonggao2, null));
        vf.addView(View.inflate(getActivity(), R.layout.gonggao1, null));
        vf.addView(View.inflate(getActivity(), R.layout.gonggao2, null));

    }

    private void initBanner() {
        mStrings = new ArrayList<>();
        mStrings.add(HomeConstant.HOME_BANNER_ONE);
        mStrings.add(HomeConstant.HOME_BANNER_TWO);
        mStrings.add(HomeConstant.HOME_BANNER_THREE);
        mStrings.add(HomeConstant.HOME_BANNER_FOUR);

        banner.setImages(mStrings)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        String img= (String) path;
                        Glide.with(getActivity()).load(img)
                              //  .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(imageView);
                    }
                })
                .setBannerAnimation(Transformer.Accordion)
                .setDelayTime(2000)
                //设置指示器位置（当banner模式中有指示器时）
                .setIndicatorGravity(BannerConfig.RIGHT)
                 //banner设置方法全部调用完毕时最后调用
                .start();
    }
}
