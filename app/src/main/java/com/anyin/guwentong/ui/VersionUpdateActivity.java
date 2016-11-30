package com.anyin.guwentong.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anyin.guwentong.R;
import com.anyin.guwentong.api.MyAPI;
import com.anyin.guwentong.base.BaseActivity;

import com.anyin.guwentong.utils.ServerDataDeal;
import com.cp.mylibrary.api.MyResponseHandler;
import com.cp.mylibrary.custom.TitleBarView;
import com.cp.mylibrary.res.UpdateRes;
import com.cp.mylibrary.utils.AppUtils;
import com.cp.mylibrary.utils.LogCp;
import com.cp.mylibrary.utils.NetWorkUtil;
import com.cp.mylibrary.utils.UpdateManagerUtil;
import com.zhy.autolayout.AutoRelativeLayout;

import org.kymjs.kjframe.ui.BindView;

/**
 * Created by Jerry on 2016/11/3.
 */
public class VersionUpdateActivity extends BaseActivity {

     @BindView(id = R.id.version_update_title)
      private TitleBarView version_update_title;


//
     @BindView(id = R.id.version_update_rel,click = true)
    private AutoRelativeLayout version_update_rel;


    @BindView(id = R.id.version_update_lin)
    private LinearLayout version_update_lin;

    @BindView(id = R.id.version_update_text)
    private TextView version_update_text;


//

//
//    version_update_rel


    private boolean isNewVersion = false;


    private UpdateRes updateRes;
    // 检查版本

    private UpdateManagerUtil updateManagerUtilS = new UpdateManagerUtil(VersionUpdateActivity.this) {
        @Override
        public void getServerUpdate() {
            getServerUpdateS();
        }
    };


    @Override
    public void setRootView() {
        super.setRootView();

     setContentView(R.layout.activity_version_update);
    }

    @Override
    protected void initView() {
        super.initView();

        version_update_title.setTitleBackFinshActivity(this);
        version_update_title.setTitleStr("版本检测");



        checkUpdate();


    }


    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);

     switch (v.getId())
     {
          // 版本检测
         case R.id.version_update_rel:


             if (updateRes != null&&isNewVersion&& NetWorkUtil.yesNext(VersionUpdateActivity.this)) {
                 String strVersion = UpdateManagerUtil.getVersionNameAndVersionCode(VersionUpdateActivity.this);

                 LogCp.i(LogCp.CP, VersionUpdateActivity.class + "取得的版本，" + strVersion);

                 updateManagerUtilS.onFinshCheck(updateRes, strVersion, false);

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
        if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(VersionUpdateActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            LogCp.i(LogCp.CP,VersionUpdateActivity.this +  " 已经有了写入sdcard 的权限!");


            updateManagerUtilS.setShowDialog(false);
            updateManagerUtilS.checkUpdate();


        } else {
            //do not have permission
            LogCp.i(LogCp.CP, VersionUpdateActivity.this +"  没有 写入sdcard 的权限!");
            AppUtils. getPromission(this);


        }



    }





    /**
     *
     */
    private void getServerUpdateS() {


    }









}
