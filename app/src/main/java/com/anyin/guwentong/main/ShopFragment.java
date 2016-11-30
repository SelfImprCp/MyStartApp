package com.anyin.guwentong.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anyin.guwentong.R;
import com.anyin.guwentong.base.BaseFragment;

import com.anyin.guwentong.utils.UIHelper;

import com.cp.mylibrary.utils.LogCp;


/**
 * 收藏
 * <p>
 * author Administrator
 */

public class ShopFragment extends BaseFragment {


    private TextView shop_home_baoxian;
    private TextView shop_home_jijin;
    private ImageView shop_search_img;


    // fragment
    private Fragment baoxianFragment;

    private Fragment fundFragment;


    @Override
    protected View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {

        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        return view;
    }


    @Override


    public void initView(View view) {
        super.initView(view);

        shop_home_baoxian = (TextView) view.findViewById(R.id.shop_home_baoxian);

        shop_home_jijin = (TextView) view.findViewById(R.id.shop_home_jijin);

        shop_search_img = (ImageView) view.findViewById(R.id.shop_search_img);

        shop_home_baoxian.setOnClickListener(this);

        shop_home_jijin.setOnClickListener(this);

        shop_search_img.setOnClickListener(this);


        // 默认保险


//        shop_home_baoxian.setBackground();


        shop_home_baoxian.setBackground(getActivity().getResources().getDrawable(R.drawable.rounded_shop_baoxian));

        shop_home_jijin.setBackgroundColor(getActivity().getResources().getColor(R.color.xiaoshutou_text_00000000));


    }


    @Override
    protected void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()) {
            case R.id.shop_home_baoxian:


                break;

            case R.id.shop_home_jijin:

                break;


            case R.id.shop_search_img:

            break;

        }


    }






}
