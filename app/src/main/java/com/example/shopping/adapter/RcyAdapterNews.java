package com.example.shopping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.shopping.R;
import com.example.shopping.bean.news.MsgInfoBean;

import java.util.ArrayList;

public class RcyAdapterNews extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<MsgInfoBean> list;
    private int index;

    public RcyAdapterNews(Context context, ArrayList<MsgInfoBean> list) {
        mContext = context;
        this.list = list;
        this.index=list.size()-1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.rcy_item_news, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MsgInfoBean bean = list.get(position);
        ViewHolder holder1= (ViewHolder) holder;
        RequestOptions crop = new RequestOptions().circleCrop();
        Glide.with(mContext).load(R.mipmap.logo).apply(crop).into(holder1.iv_rcy_news);
        holder1.tvtitle_rcy_news.setText(bean.getMsgTitle());
        holder1.tvgongx.setText(bean.getMsgContent());
        holder1.tvshijian_rcy_news.setText(bean.getMsgTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv_rcy_news;
        public TextView tvtitle_rcy_news;
        public TextView tvshijian_rcy_news;
        public TextView tvgongx;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_rcy_news = (ImageView) rootView.findViewById(R.id.iv_rcy_news);
            this.tvtitle_rcy_news = (TextView) rootView.findViewById(R.id.tvtitle_rcy_news);
            this.tvshijian_rcy_news = (TextView) rootView.findViewById(R.id.tvshijian_rcy_news);
            this.tvgongx = (TextView) rootView.findViewById(R.id.tv_gongxi);
        }

    }
}
