package com.anyin.guwentong.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;

import com.anyin.guwentong.app.AppConfig;

import com.anyin.guwentong.bean.responbean.User;
import com.cp.mylibrary.utils.DensityUtils;
import com.cp.mylibrary.utils.KeyBoardUtils;
import com.cp.mylibrary.utils.LogCp;
import com.cp.mylibrary.utils.SharePreferencesUitl;
import com.cp.mylibrary.utils.StringUtils;


/**
 * 没有明确分类的工具方法
 *
 * @author Administrator
 */
public class Uitl {

    public static Uitl uitl;

    public static Uitl getInstance() {
        if (uitl == null) {
            uitl = new Uitl();
        }


        return uitl;
    }


    // app.ailibuli.cn
    public String HOST = "api.guwenyi.com";

    public String getHOST() {
        return HOST;
    }

    public void setHOST(String host) {
        HOST = host;
    }


    /**
     * 首页广靠高度
     * <p>
     * 1280 :红米1
     * 1920 ：三星
     * 首页banner  750*377
     *
     * @return
     */
    public static int getHomeBannerHeight() {


        float width = DensityUtils.getScreenWidth();

        float biLi = width / 750;
        int height = (int) (377 * biLi);


        LogCp.i(LogCp.CP, Uitl.class + " 算出来的图片高度， 首页" + height);

        return height;

    }


    /**
     * 推荐banner 图片 750*298
     *
     * @return
     */
    public static int getTuiJianBannerHeight() {

        float width = DensityUtils.getScreenWidth();

        float biLi = width / 750;
        int height = (int) (298 * biLi);


        LogCp.i(LogCp.CP, Uitl.class + " 算出来的图片高度， 推荐" + height);


        return height;
    }


    public static Dialog simplecDialog;


    /**
     *
     */
    public void closeInputJ(Context context, EditText mairu_zuhe_jine, View view) {

        KeyBoardUtils.showSoftKeyboard(mairu_zuhe_jine, context);


        InputMethodManager imm = (InputMethodManager)
                context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

    /**
     * 银行卡尾号
     *
     * @param cardStr
     * @return
     */
    public static String getBankCardWeiHao(String cardStr) {
        // 截尾号
        int startJie = cardStr.length() - 4;
        String strJie = StringUtils.getSubString(startJie, cardStr.length(), cardStr);
        return strJie;
    }


}
