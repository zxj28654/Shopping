package com.example.shopping.classification.gooddslink;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.media.RatingCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NavUtils;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.mvplibrary.base.BaseMvpFragment;
import com.example.shopping.R;
import com.example.shopping.classification.LinkBean;
import com.example.shopping.classification.XCFlowLayout;
import com.example.shopping.mvp.link.LinkPresenter;
import com.example.shopping.mvp.link.LinkView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShangpingFragment extends BaseMvpFragment<LinkView, LinkPresenter> implements LinkView {

    @BindView(R.id.ll_shang)
    LinearLayout llShang;
    private int id;
    @BindView(R.id.banner_link)
    Banner bann;
    @BindView(R.id.tv_link)
    TextView tv1;
    @BindView(R.id.tv2_link)
    TextView tv2;
    @BindView(R.id.tv_linkxt)
    TextView tvx;
    @BindView(R.id.xuanze)
    RelativeLayout xuan;
    @BindView(R.id.iv_link_dibu)
    ImageView ivshare;
    @BindView(R.id.iv_link_dibu1)
    ImageView ivcar;
    @BindView(R.id.jia)
    Button jiarucar;
    private ArrayList<String> mStrings;
    private ArrayList<String> mList;
    private ArrayList<String> mList1;


    public ShangpingFragment(int id) {
        this.id = id;
        // Required empty public constructor
    }


    @Override
    protected int initLayoutId() {
        return R.layout.fragment_shangping;
    }

    private void initVi(LinkBean.DataBean mBean) {
        xuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initPopwindow(mBean);
            }
        });
        tvx.setText(mBean.getGoodsDefaultSku());
        tv1.setText(mBean.getGoodsDesc());
        tv2.setText("$" + mBean.getGoodsDefaultPrice());

        mStrings = new ArrayList<>();
        String goodsBanner = mBean.getGoodsBanner();
        String[] split = goodsBanner.split(",");
        mStrings.add(split[0]);
        mStrings.add(split[1]);
        mStrings.add(split[2]);

        bann.setImages(mStrings)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        String img = (String) path;
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

       // EventBus.getDefault().register(this);

    }

    private void initPopwindow(LinkBean.DataBean mBean) {
        mList1 = new ArrayList<>();
        List<LinkBean.DataBean.GoodsSkuBean> sku = mBean.getGoodsSku();
        LinkBean.DataBean.GoodsSkuBean bean = sku.get(0);
        List<String> skuContent = bean.getSkuContent();
        mList1.addAll(skuContent);


        ArrayList<TextView> list = new ArrayList<>();
        ArrayList<TextView> lists = new ArrayList<>();
        ArrayList<TextView> retu = new ArrayList<>();
        ArrayList<TextView> retu1 = new ArrayList<>();

        View view = LayoutInflater.from(context).inflate(R.layout.popwindor_link, null);
        View viewById = view.findViewById(R.id.pop_close);
        ImageView touxiang = (ImageView) view.findViewById(R.id.iv_pop_tou);
        TextView price = (TextView) view.findViewById(R.id.tv_pop_price);
        TextView idcode = (TextView) view.findViewById(R.id.tv_pop_idcode);
        TextView skuTitle = (TextView) view.findViewById(R.id.pop_skuTitle);
        TextView goodsSkuTitle = (TextView) view.findViewById(R.id.pop_goodsSkuTitle);
        XCFlowLayout flowLayout1 = (XCFlowLayout) view.findViewById(R.id.flowlayout);
        XCFlowLayout flowLayout2 = (XCFlowLayout) view.findViewById(R.id.flowlayoutss);
        TextView jian = (TextView) view.findViewById(R.id.jian);
        TextView jia = (TextView) view.findViewById(R.id.jia);
        TextView shu = (TextView) view.findViewById(R.id.shu);
        jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = Integer.parseInt(shu.getText().toString());
                if (i==1){

                }else {
                    i=i-1;
                    shu.setText(i+"");
                }
            }
        });

        jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = Integer.parseInt(shu.getText().toString());
                i=i+1;
                shu.setText(i+"");
            }
        });

        Glide.with(context).load(mBean.getGoodsDefaultIcon()).into(touxiang);
        price.setText("￥"+mBean.getGoodsDefaultPrice());
        idcode.setText("商品编号:"+mBean.getGoodsCode());
        goodsSkuTitle.setText(bean.getGoodsSkuTitle());
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 5;
        lp.rightMargin = 5;
        lp.topMargin = 5;
        lp.bottomMargin = 5;
        for(int i = 0; i < mList1.size(); i ++){
            TextView views = new TextView(context);
            list.add(views);
            views.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    views.setTag("1");
                    for (TextView v:list) {
                        if ((String)v.getTag()=="1"){
                            v.setTextColor(Color.RED);
                            v.setTag(null);
                           retu.add(v);
                        }else {
                            v.setTextColor(Color.BLACK);
                           retu.remove(v);
                        }
                    }
                }
            });
            views.setText(mList1.get(i));
            views.setTextColor(Color.BLACK);
            views.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_bg));
            flowLayout1.addView(views,lp);

        }


        if (sku.size()>1){
            mList = new ArrayList<>();
            LinkBean.DataBean.GoodsSkuBean skuBean = sku.get(1);
            skuTitle.setText(skuBean.getGoodsSkuTitle());
            mList.addAll(skuBean.getSkuContent());
            ViewGroup.MarginLayoutParams lps = new ViewGroup.MarginLayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lps.leftMargin = 5;
            lps.rightMargin = 5;
            lps.topMargin = 5;
            lps.bottomMargin = 5;
            for(int i = 0; i < mList.size(); i ++){
                TextView viewl = new TextView(context);
                lists.add(viewl);
                viewl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        viewl.setTag("1");
                        for (TextView v:lists) {
                            if ((String)v.getTag()=="1"){
                                v.setTextColor(Color.RED);
                                v.setTag(null);
                                retu1.add(v);
                            }else {
                                v.setTextColor(Color.BLACK);
                                retu1.remove(v);
                            }
                        }

                    }
                });
                viewl.setText(mList.get(i));
                viewl.setTextColor(Color.BLACK);
                viewl.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_bg));
                flowLayout2.addView(viewl,lps);
            }
        }





       // Log.i("TAG", "initPopwindow: "+mList.toString()+"1111111111111111"+mList1.toString());


        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setBackgroundDrawable(null);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setAnimationStyle(R.style.AnimBottom);
        popupWindow.showAtLocation(llShang, Gravity.CENTER,0,0);

        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                StringBuffer buffer=new StringBuffer();
                for (TextView tv:retu) {

                    buffer.append(tv.getText().toString()+"/");

                }
                for (TextView tv:retu1) {
                    buffer.append(tv.getText().toString()+",");

                }

                if (retu.size()<=0 && retu1.size()<=0){
                    //切割字符串取出要用的部分
                    //String defaultSku = mBean.getGoodsDefaultSku();
                    buffer.append(mBean.getGoodsDefaultSku()).append(shu.getText().toString()+"件");
                    EventBus.getDefault().post(buffer.toString());
                }else if (retu.size()<0){
                    for (TextView tv:retu1) {
                        buffer.append(tv.getText().toString()+",").append(shu.getText().toString()+"件");
                    }
                    EventBus.getDefault().post(buffer.toString());

                }else if (retu1.size()<0){
                    for (TextView tv:retu) {
                        buffer.append(tv.getText().toString()+"/").append(shu.getText().toString()+"件");
                    }
                    EventBus.getDefault().post(buffer.toString());
                }else {
                    buffer.append(shu.getText().toString()+"件");
                    EventBus.getDefault().post(buffer.toString());
                }

            }
        });
    }

    @Override
    protected void initView() {
        mPresenter.getBean(id);
    }

    @Override
    protected LinkPresenter initPresenter() {
        return new LinkPresenter();
    }

    @Override
    public void setData(LinkBean.DataBean linkBean) {

        if (linkBean != null) {

            initVi(linkBean);
        }
    }

    @Override
    public void showToast(String string) {
        Toast.makeText(mActivity, string, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }
    @Subscribe
    public void SetTvx(String string){
        if (string!=null){
            tvx.setText(string);
            string=null;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
      EventBus.getDefault().unregister(this);

    }
}
