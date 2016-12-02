package com.anyin.guwentong.main;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anyin.guwentong.R;
import com.anyin.guwentong.base.BaseFragment;
import com.anyin.guwentong.event.ExitUserEvent;
import com.anyin.guwentong.event.LoginEvent;
import com.anyin.guwentong.utils.UIHelper;

import com.anyin.guwentong.utils.UserManageUtil;
import com.cp.mylibrary.banner.ADInfo;
import com.cp.mylibrary.banner.CycleViewPager;
import com.cp.mylibrary.utils.DensityUtils;
import com.cp.mylibrary.utils.NetWorkUtil;
import com.cp.mylibrary.utils.ShowToastUtil;

/**
 * 规划界面
 *
 * @author Administrator
 */
public class HomeFragment extends BaseFragment {

    private String home_cache = "home_cache";

    private View view;


    private TextView home_shouyilv,home_min_value_2,home_min_value_1;

    private TextView home_touzirenshu;

    private TextView home_touziqian;

    private Button home_lijitouzi;

    // 广告条
    private CycleViewPager cycleViewPager;

    private FrameLayout home_fragment_top_banner_rel;
 private  LinearLayout home_no_loagin_lin;


    // 首页返回

    private Dialog waitDialog;


    @Override
    protected View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {


        if (view == null) {


            view = inflater.inflate(R.layout.fragment_home, container, false);

        }

//        ShowToastUtil.showToast(getActivity(), "  又执行了一遍 inflaterView ");

        return view;
    }


    @Override
    public void initView(View view) {



//         if (AppConfig.isDevelop)
//         {



        ShowToastUtil.showToast(getActivity(), "手机分辨率：高" + DensityUtils.getScreenHeight() + "宽 ;" + DensityUtils.getScreenWidth());
//         }

        home_shouyilv = (TextView) view.findViewById(R.id.home_shouyilv);
        home_touzirenshu = (TextView) view.findViewById(R.id.home_touzirenshu);
        home_touziqian = (TextView) view.findViewById(R.id.home_touziqian);

        home_min_value_2 = (TextView) view.findViewById(R.id.home_min_value_2);



        home_min_value_1 = (TextView) view.findViewById(R.id.home_min_value_1);


        home_lijitouzi = (Button) view.findViewById(R.id.home_lijitouzi);
        home_lijitouzi.setOnClickListener(this);

        home_no_loagin_lin = (LinearLayout) view.findViewById(R.id.home_no_loagin_lin);
        home_no_loagin_lin.setOnClickListener(this);


        home_fragment_top_banner_rel = (FrameLayout) view.findViewById(R.id.home_fragment_top_banner_rel);

//        LinearLayout.LayoutParams linearParamsFramet = (LinearLayout.LayoutParams) home_fragment_top_banner_rel.getLayoutParams();
//        linearParamsFramet.height = Uitl.getHomeBannerHeight();
//        home_fragment_top_banner_rel.setLayoutParams(linearParamsFramet);




    }


    /**
     *
     */
    private void getDataServer() {
        if (NetWorkUtil.hasInternetConnected(getActivity())) {



        }

    }


    /**
     *
     */
    private void fillUI() {


        // 广告
        initViewPger();




        showIsLogin();

    }


    @Override
    protected void widgetClick(View v) {

        switch (v.getId()) {




            case R.id.home_no_loagin_lin:

                if (NetWorkUtil.yesNext(getActivity())  ) {

                    UIHelper.showLogin(getActivity() );
                }

                break;


        }

    }


    private void initViewPger() {

//        List<HomeBannerBean> banner = mainForAppBean.getBanner();
//        //数据源
//        List<ADInfo> infos = new ArrayList<ADInfo>();
//
//
//        for (HomeBannerBean bannerBean : banner) {
//
//            ADInfo adInfo = new ADInfo();
//
//
//            LogCp.i(LogCp.CP, HomeFragment.class + " bannerBean.getImgUrl() " + bannerBean.getImgUrl());
//
//
//            adInfo.setUrl(bannerBean.getImgUrl());
//            adInfo.setImgUrl(bannerBean.getImgUrl());
//
//
//            LogCp.i(LogCp.CP, HomeFragment.class + " bannerBean.getTitle() " + bannerBean.getTitle());
//
//            adInfo.setTitle(bannerBean.getTitle());
//
//
//            if (!StringUtils.isEmpty(bannerBean.getSrcUrl())) {
//
//                adInfo.setJumpUrl(bannerBean.getSrcUrl());
//
//                LogCp.i(LogCp.CP, HomeFragment.class + "  设置的分享练级 " + bannerBean.getShareUrl());
//
//
//                LogCp.i(LogCp.CP, HomeFragment.class + "    分享 内容 ccc   " + bannerBean.getContent());
//
//                adInfo.setContent(bannerBean.getContent());
//
//                adInfo.setShare_url(bannerBean.getShareUrl());
//            }
//
//            infos.add(adInfo);
//
//        }
//
//
//        //初始化控件
//        cycleViewPager = (CycleViewPager) getActivity().getFragmentManager()
//                .findFragmentById(R.id.fragment_home_viewpager_content);
//
//
//        // 填充数据
//        BannerInitUtil bannerInitUtil = new BannerInitUtil();
//        bannerInitUtil.initBannerViewPager(getActivity(), true, 2000, infos, cycleViewPager, mAdCycleViewListener);


    }


    /**
     * banner 的监听 事件
     */
    private CycleViewPager.ImageCycleViewListener mAdCycleViewListener = new CycleViewPager.ImageCycleViewListener() {

        @Override
        public void onImageClick(ADInfo info, int position, View imageView) {


//            LogCp.i(LogCp.CP, HomeFragment.class + " title " + info.getTitle());
//
//            if (!StringUtils.isEmpty(info.getJumpUrl())) {
//
//
//                LogCp.i(LogCp.CP, HomeFragment.class + " title  分享 " + info.getShare_url());
//
//                LogCp.i(LogCp.CP, HomeFragment.class + "    分享 内容  " + info.getContent());
//
//                UIHelper.showWebView(getActivity(), info.getTitle(), info.getJumpUrl(), WebViewActivity.WEB_SHARE_NO, info.getTitle(), info
//                        .getContent(), info.getImgUrl(), info.getShare_url(),"");
//
//
//            }
//





        }

    };



    public void onEvent(LoginEvent event) {
        super.onEvent(event);

        showIsLogin();
    }

    public void onEvent(ExitUserEvent event) {
        super.onEvent(event);

        showIsLogin();
    }



    private  void showIsLogin()
     {



         if (UserManageUtil.userIsLogin(getActivity()))
         {
             home_no_loagin_lin.setVisibility(View.GONE);
         }else
         {
             home_no_loagin_lin.setVisibility(View.VISIBLE);
         }
     }

}

