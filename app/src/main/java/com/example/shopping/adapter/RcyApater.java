package com.example.shopping.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;

import java.util.ArrayList;

public class RcyApater extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<String> mList;

    public RcyApater(Context context, ArrayList<String> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.zhekou_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        String s = mList.get(position);
        ViewHolder holder1= (ViewHolder) holder;
        Glide.with(mContext).load(s).into(holder1.iv);
        holder1.tv2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//删除线
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv;
        public TextView tv2;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.tv2 = (TextView) rootView.findViewById(R.id.tv2);
        }

    }
}
