package com.anyin.guwentong;


import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TabHost;
import android.widget.TextView;

import com.anyin.guwentong.app.AppConfig;
import com.anyin.guwentong.main.MainTab;
import com.anyin.guwentong.utils.Uitl;
import com.cp.mylibrary.api.MyHttpClient;
import com.cp.mylibrary.custom.MyFragmentTabHost;
import com.cp.mylibrary.interf.OnTabReselectListener;
import com.cp.mylibrary.utils.AppUtils;
import com.cp.mylibrary.utils.DoubleClickExitHelper;
import com.cp.mylibrary.utils.LogCp;
import com.cp.mylibrary.utils.UpdateManagerUtil;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import static android.view.LayoutInflater.from;

/**
 * 应用主界面
 *
 * @author Administrator
 */
public class MainActivity extends FragmentActivity implements TabHost.OnTabChangeListener,
        View.OnTouchListener {


    public static MyFragmentTabHost mTabHost;
    // 双击退出
    private DoubleClickExitHelper mDoubleClickExit;
    public static String TCurrent = "value";
    //为状态栏着色
    public SystemBarTintManager tintManager ;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    //   private GoogleApiClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        super.onCreate(savedInstanceState);

        if (AppConfig.isDevelop)
        {
            MyHttpClient.initHttp(Uitl.getInstance().getHOST());


        }


        //     android:fitsSystemWindows="true"
        //  android:clipToPadding="false"
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        //只对api19以上版本有效
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        //为状态栏着色
        tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);


        tintManager.setStatusBarTintResource(com.cp.mylibrary.R.color.base_color);





        setContentView(R.layout.activity_main);

        initView();


    }


    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }


    public void initView() {
        mDoubleClickExit = new DoubleClickExitHelper(this);

        mTabHost = (MyFragmentTabHost) findViewById(android.R.id.tabhost);


        // mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        if (Build.VERSION.SDK_INT > 10) {
            mTabHost.getTabWidget().setShowDividers(0);
        }

        initTabs();

        int current = getIntent().getIntExtra(TCurrent, 0);

        mTabHost.setCurrentTab(current);


        // 保存用户
//        User user = new User();
//        user.setNickname("小林");
//        user.setMobile("13560255894");
//
//        UserManaage.getUserManaage().saveUserInfo(MainActivity.this,
//                user);
//
//
//        User dbUser = UserManaage.getUserManaage().getLoginUser(MainActivity.this);
//
//        LogCp.i(LogCp.CP, MainActivity.class + "从数据库中查出来的登录用户" + dbUser );


        /**
         * 检查 版本更新
         */
        checkUpdate();


    }


    /**
     * 初始化tab
     */
    private void initTabs() {
        MainTab[] tabs = MainTab.values();
        final int size = tabs.length;
        for (int i = 0; i < size; i++) {
            MainTab mainTab = tabs[i];
            TabHost.TabSpec tab = mTabHost.newTabSpec(getString(mainTab.getResName()));

            View indicator = from(getApplicationContext())
                    .inflate(R.layout.tab_indicator, null);

            TextView title = (TextView) indicator.findViewById(R.id.tab_title);
            Drawable drawable = this.getResources().getDrawable(
                    mainTab.getResIcon());

            title.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null,
                    null);

            title.setText(getString(mainTab.getResName()));
            tab.setIndicator(indicator);
            tab.setContent(new TabHost.TabContentFactory() {

                @Override
                public View createTabContent(String tag) {
                    return new View(MainActivity.this);
                }
            });
            mTabHost.addTab(tab, mainTab.getClz(), null);

            mTabHost.getTabWidget().getChildAt(i).setOnTouchListener(this);
        }


    }


    /**
     *
     */
    private void checkUpdate() {

        LogCp.i(LogCp.CP, "  检查更新 !");

        // 写入sdcard 权限
        if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            LogCp.i(LogCp.CP,MainActivity.this +  " 已经有了写入sdcard 的权限!");


            updateManagerUtilS.setShowDialog(false);
            updateManagerUtilS.checkUpdate();


        } else {
            //do not have permission
            LogCp.i(LogCp.CP, MainActivity.this +"  没有 写入sdcard 的权限!");
            AppUtils. getPromission(this);


        }



    }


    /**
     * 监听返回--是否退出程序
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {


            // 是否退出应用
            // if (StringUtils.toBool(SharePreferencesUitl.getSharePreferencesUitl(MainActivity.this).loadData(DoubleClickExitHelper.KEY_DOUBLE_CLICK_EXIT
            //      ))) {

            // mPushAgent.disable(mUnregisterCallback);

            return mDoubleClickExit.onKeyDown(keyCode, event, "再次单击退出小树投");

            //}
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onTabChanged(String tabId) {
        final int size = mTabHost.getTabWidget().getTabCount();
        for (int i = 0; i < size; i++) {
            View v = mTabHost.getTabWidget().getChildAt(i);
            if (i == mTabHost.getCurrentTab()) {
                // if(i==3&&!AppContext.getInstance().isLogin())
                // {
                // noLogin();
                //
                // }

                v.setSelected(true);
            } else {
                v.setSelected(false);
            }
        }

        supportInvalidateOptionsMenu();

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        super.onTouchEvent(event);
        boolean consumed = false;
        // use getTabHost().getCurrentTabView to decide if the current tab is
        // touched again
        if (event.getAction() == MotionEvent.ACTION_DOWN
                && v.equals(mTabHost.getCurrentTabView())) {
            // use getTabHost().getCurrentView() to get a handle to the view
            // which is displayed in the tab - and to get this views context
            Fragment currentFragment = getCurrentFragment();
            if (currentFragment != null
                    && currentFragment instanceof OnTabReselectListener) {
                OnTabReselectListener listener = (OnTabReselectListener) currentFragment;
                listener.onTabReselect();
                consumed = true;
            }
        }
        return consumed;
    }

    private android.support.v4.app.Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentByTag(
                mTabHost.getCurrentTabTag());
    }


    // 检查版本

    private UpdateManagerUtil updateManagerUtilS = new UpdateManagerUtil(MainActivity.this) {
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
