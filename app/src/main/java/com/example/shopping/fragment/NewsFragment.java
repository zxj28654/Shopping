package com.example.shopping.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvplibrary.base.BaseMvpFragment;
import com.example.shopping.R;
import com.example.shopping.adapter.RcyAdapterNews;
import com.example.shopping.bean.news.MsgInfoBean;
import com.example.shopping.evenbus.OnExitZhanghao;
import com.example.shopping.evenbus.OnGetNews;
import com.example.shopping.mvp.news.NewsPresenter;
import com.example.shopping.mvp.news.NewsView;
import com.example.shopping.utils.SPUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseMvpFragment<NewsView, NewsPresenter> implements NewsView {
    private ArrayList<MsgInfoBean> list;
    private RcyAdapterNews mRcyAdapterNews;

    @BindView(R.id.rcy_news)
    RecyclerView rcy;
    @BindView(R.id.tv_newsEmpty)
    TextView tv;
    private Integer mSpsp;

    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView() {
        mSpsp = SPUtil.getDefData("spsp", 0);
        initViews();


    }


    @Override
    protected NewsPresenter initPresenter() {
        return new NewsPresenter();
    }

    @Override
    public void setData(ArrayList<MsgInfoBean> list) {
        if (list.size()>0){
            int index=list.size()-1;
            tv.setVisibility(View.INVISIBLE);
            for (int i = 0; i < list.size(); i++) {
                this.list.add(list.get(index));
                index--;
            }
            mRcyAdapterNews.notifyDataSetChanged();
        }else {
            tv.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showToast(String string) {
        Toast.makeText(mActivity, string, Toast.LENGTH_SHORT).show();
    }

    private void initViews() {
        rcy.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        mRcyAdapterNews = new RcyAdapterNews(mActivity,list);
        rcy.setAdapter(mRcyAdapterNews);

        if (mSpsp !=0){
            Log.i("555", mSpsp +"");
            mPresenter.getDatas();
        }
    }
    @Subscribe
    public void onEvent(OnGetNews onGetNews){
        mPresenter.getDatas();
    }


    @Subscribe
    public void exit(OnExitZhanghao onExitZhanghao){
        list.clear();
        tv.setVisibility(View.VISIBLE);
        mRcyAdapterNews.notifyDataSetChanged();
        tv.setVisibility(View.VISIBLE);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
