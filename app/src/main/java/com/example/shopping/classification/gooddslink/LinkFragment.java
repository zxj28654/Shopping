package com.example.shopping.classification.gooddslink;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shopping.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LinkFragment extends Fragment {

    private String one;
    private String two;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView ivshare;
    private ImageView ivcar;
    private Button jiarucar;

    public LinkFragment(String ones,String twos) {
        this.one=ones;
        this.two=twos;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_link, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        iv1 = (ImageView)view.findViewById(R.id.iv_link1);
        iv2 = (ImageView)view.findViewById(R.id.iv_link2);
        ivshare = (ImageView) view.findViewById(R.id.iv_link_dibu);
        ivcar = (ImageView) view.findViewById(R.id.iv_link_dibu1);
        jiarucar = (Button) view.findViewById(R.id.jia);

        Glide.with(this).load(one).into(iv1);
        Glide.with(this).load(two).into(iv2);
    }
}
