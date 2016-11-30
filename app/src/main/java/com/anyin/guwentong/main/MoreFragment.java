package com.anyin.guwentong.main;


import android.Manifest;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anyin.guwentong.R;
import com.anyin.guwentong.app.AppConfig;
import com.anyin.guwentong.base.BaseFragment;
import com.anyin.guwentong.utils.UIHelper;
import com.anyin.guwentong.utils.UserManageUtil;
import com.cp.mylibrary.utils.AppUtils;
import com.cp.mylibrary.utils.LogCp;
import com.cp.mylibrary.utils.MyCache;
import com.cp.mylibrary.utils.NetWorkUtil;
import com.cp.mylibrary.utils.ShowToastUtil;
import com.cp.mylibrary.utils.UpdateManagerUtil;
import com.zhy.autolayout.AutoRelativeLayout;

/**
 * 规划界面
 *
 * @author Administrator
 */
public class MoreFragment extends BaseFragment {


    private AutoRelativeLayout more_cache_rel;

    private AutoRelativeLayout more_about_rel;

    private AutoRelativeLayout more_fankui_rel;

    private AutoRelativeLayout more_lianxi_rel;

    private AutoRelativeLayout more_yonghuxiyi_rel;

    private AutoRelativeLayout more_changjian_rel;


    private AutoRelativeLayout more_version_update_rel;


    private TextView setting_get_cache_text;


    private String home_cache = "home_cache";


    private ViewGroup.LayoutParams layoutParams;

    /**
     * 屏幕宽度
     */
    private int screenWidth;

    private Dialog waitDialog;


    private View view;

    @Override
    protected View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {


        if (view == null) {


            view = inflater.inflate(R.layout.fragment_more, container, false);

        }


        return view;
    }


    @Override
    public void initView(View view) {
        super.initView(view);


        more_cache_rel = (AutoRelativeLayout) view.findViewById(R.id.more_cache_rel);

        more_cache_rel.setOnClickListener(this);

        more_about_rel = (AutoRelativeLayout) view.findViewById(R.id.more_about_rel);

        more_about_rel.setOnClickListener(this);


        more_fankui_rel = (AutoRelativeLayout) view.findViewById(R.id.more_fankui_rel);

        more_fankui_rel.setOnClickListener(this);


        more_version_update_rel = (AutoRelativeLayout) view.findViewById(R.id.more_version_update_rel);
        more_version_update_rel.setOnClickListener(this);

        more_lianxi_rel = (AutoRelativeLayout) view.findViewById(R.id.more_lianxi_rel);
        more_lianxi_rel.setOnClickListener(this);

        more_yonghuxiyi_rel = (AutoRelativeLayout) view.findViewById(R.id.more_yonghuxiyi_rel);
        more_yonghuxiyi_rel.setOnClickListener(this);


        more_changjian_rel = (AutoRelativeLayout) view.findViewById(R.id.more_changjian_rel);
        more_changjian_rel.setOnClickListener(this);


        setting_get_cache_text = (TextView) view.findViewById(R.id.setting_get_cache_text);

        setting_get_cache_text.setText(MyCache.getMyCache(getActivity()).getCacheSize(getActivity()));

    }


    @Override
    protected void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()) {

            // 清除缓存
            case R.id.more_cache_rel:
                MyCache.getMyCache(getActivity()).clearCache();

                setting_get_cache_text.setText(MyCache.getMyCache(getActivity()).getCacheSize(getActivity()));


                break;

            // 关于我们
            case R.id.more_about_rel:

//                UIHelper.showAbout(getActivity());



                break;
            // 联系我们
            case R.id.more_lianxi_rel:

         break;


            // 意见反馈
            case R.id.more_fankui_rel:

                 boolean isLogin = UserManageUtil.userIsLogin(getActivity());



                if (NetWorkUtil.yesNext(getActivity())) {

                     if (isLogin)
                     {

                     }else
                     {
                         ShowToastUtil.showToast(getActivity(),"请先登录");
                         UIHelper.showLogin(getActivity());
                     }

                }

                break;
            // 用户协议
            case R.id.more_yonghuxiyi_rel:



                break;

            // 常见问题
            case R.id.more_changjian_rel:


                break;


            //版本更新
            case R.id.more_version_update_rel:


                if (NetWorkUtil.yesNext(getActivity())) {

                }

                break;


        }


    }


    /**
     *
     */
    private void checkUpdate() {

        LogCp.i(LogCp.CP, "  检查更新 !");

        // 写入sdcard 权限
        if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            updateManagerUtilS.setShowDialog(false);
            updateManagerUtilS.checkUpdate();


        } else {
            //do not have permission
            AppUtils.getPromission(getActivity());


        }


    }


    // 检查版本

    private UpdateManagerUtil updateManagerUtilS = new UpdateManagerUtil(getActivity()) {
        @Override
        public void getServerUpdate() {
            getServerUpdateS();
        }
    };


    /**
     *
     */
    private void getServerUpdateS() {



    }
}

