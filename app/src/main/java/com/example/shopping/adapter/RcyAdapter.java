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
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.shopping.R;
import com.example.shopping.classification.Beann;

import java.util.ArrayList;

public class RcyAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<Beann.DataBean> list;

    public RcyAdapter(Context context, ArrayList<Beann.DataBean> list) {
        mContext = context;
        this.list = list;
    }

    public interface OnclickClasss{
        void onClickcliss(int id);
    }
    private OnclickClasss mOnclickClasss;

    public void setOnclickClasss(OnclickClasss onclickClasss) {
        mOnclickClasss = onclickClasss;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.classitems, parent, false);

        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Beann.DataBean bean = list.get(position);

        ViewHolder holder1= (ViewHolder) holder;
        holder1.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnclickClasss!=null){
                    mOnclickClasss.onClickcliss(bean.getId());
                }
            }
        });
        holder1.classname.setText(bean.getCategoryName());
        //bitmapTransform(new CropCircleTransformation(context))
        Glide.with(mContext).load(bean.getCategoryIcon())
                .into(holder1.iv_classitem);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv_classitem;
        public TextView classname;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_classitem = (ImageView) rootView.findViewById(R.id.iv_classitem);
            this.classname = (TextView) rootView.findViewById(R.id.classname);
        }

    }
}
