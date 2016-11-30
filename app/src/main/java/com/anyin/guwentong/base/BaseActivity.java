package com.anyin.guwentong.base;


import android.app.Dialog;
import android.os.Bundle;


import com.anyin.guwentong.R;
import com.anyin.guwentong.api.MyAPI;
import com.anyin.guwentong.bean.responbean.User;
import com.anyin.guwentong.event.IntentChangeEvent;

import com.anyin.guwentong.utils.ServerDataDeal;
import com.anyin.guwentong.utils.UserManageUtil;
import com.cp.mylibrary.api.MyResponseHandler;
import com.cp.mylibrary.base.MyBaseActivity;
import com.cp.mylibrary.dialog.DialogHelper;
import com.cp.mylibrary.utils.NetWorkUtil;
import com.cp.mylibrary.utils.ShowToastUtil;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;

import de.greenrobot.event.EventBus;


/**
 * 应用Activity基类
 *
 * @author Administrator
 *         <p/>
 *         <p/>
 *         基类中各个方法的调用顺序：
 *         setRootView(); //用于调用setContent()；
 * @BindView //setRootView执行后将会执行注解绑定
 * initDataFromThread();（执行在异步，用于做耗时操作）
 * threadDataInited();（initDataFromThread() 执行完成后将会回调）
 * initData(); //用于初始化数据
 * initWidget(); //用于设置控件内容
 * registerBroadcast(); //用于注册广播与上下文菜单
 */
public class BaseActivity extends MyBaseActivity {


    public Dialog waitDialog;



 // 时间 戳
//    public GetSystemTimeStampRes getSystemTimeStampRes;

     // 当前登录用户，调用处null判断
     public User      user  ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);




//        4.2.2  统计应用启动数据
//        在所有的Activity 的onCreate 方法或在应用的BaseActivity的onCreate方法中添加：

        PushAgent.getInstance(this).onAppStart();


        // 检查网络 联接
        if (!NetWorkUtil.hasInternetConnected(this)) {
            ShowToastUtil.showToastShort(this, R.string.tip_network_error);

        }

//
//        EventBus.getDefault().register(this);


        // 发出检查网络 的事件
        IntentChangeEvent event = new IntentChangeEvent();
        EventBus.getDefault().post(event);


    }

    @Override
    protected void initView() {
        super.initView();

        user = UserManageUtil.getLoginUser(BaseActivity.this);

        waitDialog = DialogHelper.getWaitDialog(BaseActivity.this, "加载中...");


    }

    @Override
    protected void onResume() {
        super.onResume();


        MobclickAgent.onResume(this);


    }


    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }


    @Override
    protected void onDestroy() {

        super.onDestroy();
    }


    /**
     *  取个时间 戳
     */
    public void getSystemTimeStamp() {
        // 取个时间 戳
//
//        waitDialog.show();
//        MyAPI.getSystemTimeStamp(new MyResponseHandler() {
//            @Override
//            public void dataSuccess(String s) {
//
//
//                getSystemTimeStampRes = ServerDataDeal.decryptDataAndDeal(BaseActivity.this, s, GetSystemTimeStampRes.class);
//
//
//            }
//
//            @Override
//            public void dataFinish() {
//                waitDialog.dismiss();
//
//            }
//
//            @Override
//            public void dataFailuer(int i, String s) {
//
//            }
//        });
//

    }


}
