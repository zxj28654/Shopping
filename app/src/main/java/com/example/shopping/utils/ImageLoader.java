package com.example.shopping.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * 项目名：Shopping
 * 包名：  com.example.liangxq.shopping.utils
 * 文件名：ImageLoader
 * 创建者：liangxq
 * 创建时间：2020/8/12  15:21
 * 描述：TODO
 */
public class ImageLoader extends com.youth.banner.loader.ImageLoader{
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path.toString()).into(imageView);
    }
}
