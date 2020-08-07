package com.example.shopping.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.shopping.R;

import java.util.ArrayList;

public class VpAdaPter extends PagerAdapter {
    private ArrayList<View> mList;
    private ArrayList<String> lists;
    private Context mContext;

    public VpAdaPter(ArrayList<View> list, Context context,ArrayList<String> listss) {
        mList = list;
        lists = listss;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = mList.get(position);
        ImageView iv = view.findViewById(R.id.iv1s);
        Glide.with(mContext).load(lists.get(position)).into(iv);
        container.addView(view);
        return view;


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View)object);
    }
}
