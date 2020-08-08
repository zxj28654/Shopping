package com.example.shopping.fragment;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.mvplibrary.base.BaseMvpFragment;
import com.example.shopping.R;
import com.example.shopping.classification.ClassBeanData;
import com.example.shopping.classification.ClassPresenter;
import com.example.shopping.classification.ClassView;

import butterknife.BindView;
import q.rorbin.verticaltablayout.VerticalTabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClassificationFragment extends BaseMvpFragment<ClassView, ClassPresenter> implements ClassView{

    @BindView(R.id.toobar_class)
    Toolbar toobarClass;
    @BindView(R.id.tab_ver)
    VerticalTabLayout tabVer;


    public ClassificationFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initData() {
        super.initData();

        if (mPresenter!=null){
            mPresenter.getDataBean();
        }
    }

    @Override
    protected ClassPresenter initPresenter() {
        return new ClassPresenter();
    }

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_classification;
    }

    @Override
    public void setData(ClassBeanData classBeanData) {

    }

    @Override
    public void showToast(String string) {

    }
}
