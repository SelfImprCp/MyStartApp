package com.anyin.guwentong.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.anyin.guwentong.MainActivity;
import com.anyin.guwentong.domian.SimpleBackPage;
import com.anyin.guwentong.ui.AboutMe;
import com.anyin.guwentong.ui.HuanJinSelect;
import com.anyin.guwentong.ui.LoginActivity;
import com.anyin.guwentong.ui.RegisterActivity;
import com.anyin.guwentong.ui.SimpleBackActivity;
import com.cp.mylibrary.utils.OpenActivityUtil;


/**
 * 界面帮助类
 *
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @version 创建时间：2014年10月10日 下午3:33:36
 */
public class UIHelper {

    private static String lastToast = "";
    private static long lastToastTime;
    public static UIHelper uiHelper;

    public static UIHelper getInstance() {
        if (uiHelper == null)
            uiHelper = new UIHelper();
        return uiHelper;
    }


    /**
     * 显示 关于我们
     *
     * @param context
     */

    public static void showAbout(Context context) {

        OpenActivityUtil.getInstance().openActivity(context, AboutMe.class);
//

    }


    /** 显示 关于我们
     *
     * @param context
     */

    public static void showHuanJinSelect(Context context) {


        OpenActivityUtil.getInstance().openActivity(context, HuanJinSelect.class);

    }
    /**
     * 显示  首页
     *
     * @param context
     */

    public static void showMainActivity(Context context) {

        OpenActivityUtil.getInstance().openActivity(context, MainActivity.class);


    }


    /**
     * 显示  登录
     *
     * @param context
     */

    public static void showLogin(Context context) {

        OpenActivityUtil.getInstance().openActivity(context, LoginActivity.class);


    }

    /**
     * @param context
     */
    public static void showRegister(Context context) {

        OpenActivityUtil.getInstance().openActivity(context, RegisterActivity.class);


    }


    // ===============================以下代码勿改动======================================//


    /**
     * @param context
     * @param page
     */
    public static void showSimpleBack(Context context, SimpleBackPage page) {
        Intent intent = new Intent(context, SimpleBackActivity.class);
        intent.putExtra(SimpleBackActivity.BUNDLE_KEY_PAGE, page.getValue());
        context.startActivity(intent);
    }

    /**
     * @param context
     * @param page
     * @param args
     */

    public static void showSimpleBack(Context context, SimpleBackPage page,
                                      Bundle args) {
        Intent intent = new Intent(context, SimpleBackActivity.class);
        intent.putExtra(SimpleBackActivity.BUNDLE_KEY_ARGS, args);
        intent.putExtra(SimpleBackActivity.BUNDLE_KEY_PAGE, page.getValue());
        context.startActivity(intent);
    }


}
