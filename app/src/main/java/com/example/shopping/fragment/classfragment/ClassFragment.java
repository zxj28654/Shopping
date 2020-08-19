package com.example.shopping.fragment.classfragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvplibrary.base.BaseMvpFragment;
import com.example.shopping.GoodsActivity;
import com.example.shopping.R;
import com.example.shopping.adapter.RcyAdapter;
import com.example.shopping.classification.Beann;
import com.example.shopping.classification.ClassPresenter;
import com.example.shopping.classification.ClassView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassFragment extends BaseMvpFragment<ClassView, ClassPresenter> implements ClassView {

    @BindView(R.id.rcy)
    RecyclerView rcy;
    private int id;
    private ArrayList<Beann.DataBean> mDataBeans;
    private RcyAdapter mRcyAdapter;

    public ClassFragment(int id) {
        this.id = id;
        // Required empty public constructor
    }

    public void getPage(int page) {
        mPresenter.getDataBean(page);
    }

    @Override
    protected void initView() {
        initRcy();
        mPresenter.getDataBean(id);

    }

    private void initRcy() {
        rcy.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mDataBeans = new ArrayList<>();
        mRcyAdapter = new RcyAdapter(getContext(), mDataBeans);
        rcy.setAdapter(mRcyAdapter);
        mRcyAdapter.setOnclickClasss(new RcyAdapter.OnclickClasss() {
            @Override
            public void onClickcliss(int id) {
                Intent intent = new Intent(getActivity(), GoodsActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

    }

    @Override
    protected ClassPresenter initPresenter() {
        return new ClassPresenter();
    }

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_class;
    }

    @Override
    public void setData(ArrayList<Beann.DataBean> list) {
        if (list != null) {
            if (list.size() > 0) {
                mDataBeans.clear();
                mDataBeans.addAll(list);
                mRcyAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void showToast(String string) {
        Toast.makeText(mActivity, string, Toast.LENGTH_SHORT).show();
    }
}
