package com.example.shopping.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.classification.Beans;

import java.util.ArrayList;

public class RcyGoodslAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<Beans.DataBean> list;

    public RcyGoodslAdapter(Context context, ArrayList<Beans.DataBean> list) {
        mContext = context;
        this.list = list;
    }

    public interface OnclickClasss{
        void onClickcliss(Beans.DataBean bean);
    }
    private OnclickClasss mOnclickClasss;

    public void setOnclickClasss(OnclickClasss onclickClasss) {
        mOnclickClasss = onclickClasss;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.goodslie_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Beans.DataBean bean = list.get(position);
        ViewHolder holder1= (ViewHolder) holder;
        holder1.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnclickClasss!=null){
                    mOnclickClasss.onClickcliss(bean);
                }
            }
        });
        //Log.e("liangxq", "onBindViewHolder: "+bean.getGoodsDefaultIcon() );
        Glide.with(mContext).load(bean.getGoodsDefaultIcon()).into(holder1.ivlei);
        holder1.tvlei.setText(bean.getGoodsDesc());
        holder1.tv2lei.setText("$"+bean.getGoodsDefaultPrice());
        holder1.tv_lie_xiao.setText("销量"+bean.getGoodsSalesCount()+"件");
        holder1.tv_lie_ku.setText("库存"+bean.getGoodsSalesCount());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView ivlei;
        public TextView tvlei;
        public TextView tv2lei;
        public TextView tv_lie_ku;
        public TextView tv_lie_xiao;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.ivlei = (ImageView) rootView.findViewById(R.id.ivlei);
            this.tvlei = (TextView) rootView.findViewById(R.id.tvlei);
            this.tv2lei = (TextView) rootView.findViewById(R.id.tv2lei);
            this.tv_lie_ku = (TextView) rootView.findViewById(R.id.tv_lie_ku);
            this.tv_lie_xiao = (TextView) rootView.findViewById(R.id.tv_lie_xiao);
        }

    }
}
