
package com.anyin.guwentong.base;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.anyin.guwentong.app.AppContext;

import com.cp.mylibrary.base.MyBaseFragment;
import com.cp.mylibrary.interf.BaseFragmentInterface;


/**
 * fragment 基类
 *
 * @author kymjs (http://www.kymjs.com/)
 */
public class BaseFragment extends MyBaseFragment implements
        BaseFragmentInterface {

    public static final int STATE_NONE = 0;
    public static final int STATE_REFRESH = 1;
    public static final int STATE_LOADMORE = 2;
    public static final int STATE_NOMORE = 3;
    public static final int STATE_PRESSNONE = 4;// 正在下拉但还没有到刷新的状态
    public static int mState = STATE_NONE;

//    protected LayoutInflater mInflater;

    public AppContext getApplication() {
        return (AppContext) getActivity().getApplication();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


//        this.mInflater = inflater;

//        View view = inflaterView(inflater, container, savedInstanceState);
//
//        //加载界面
//        initView(view);
//        // 处理数据
//        initData();

        super.onCreateView(inflater,container,savedInstanceState);



        return view;

    }




    @Override
    public void onDestroy() {

        super.onDestroy();

    }


    /**
     * 子类直接复写这个方法,view,就是当前界面的view
     */
    @Override
    public void initView(View view) {

    }


    /**
     * 子类复写这个方法,设置当前界面的布局
     *
     * @return
     */
    @Override
    protected View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        return null;
    }

    /**
     * 子类直接复写这个方法,view, 对当前界面的数据进行处理
     */
    @Override
    public void initData() {

    }



}
