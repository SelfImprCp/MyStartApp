package com.anyin.guwentong.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

import com.anyin.guwentong.R;
import com.anyin.guwentong.app.AppConfig;
import com.anyin.guwentong.bean.responbean.User;
import com.cp.mylibrary.utils.DensityUtils;
import com.cp.mylibrary.utils.KeyBoardUtils;
import com.cp.mylibrary.utils.LogCp;
import com.cp.mylibrary.utils.MathExtend;
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


    /**
     * @param mContext
     * @param shoucang_tuijian_shouyi
     * @param shouYI
     */
    public static void showZhangDieFu(Context mContext, TextView shoucang_tuijian_shouyi, float shouYI) {

        if (shouYI > 0) {
            shoucang_tuijian_shouyi.setTextColor(mContext.getResources().getColor(R.color.white_cp_util));
            shoucang_tuijian_shouyi.setText("+" + MathExtend.round(shouYI, 2) + "%");


        } else if (shouYI == 0) {
            shoucang_tuijian_shouyi.setTextColor(mContext.getResources().getColor(R.color.white_cp_util));
            shoucang_tuijian_shouyi.setText("0.00%");


        } else if (shouYI
                < 0) {
            shoucang_tuijian_shouyi.setText("" + MathExtend.round(shouYI, 2) + "%");


            shoucang_tuijian_shouyi.setTextColor(mContext.getResources().getColor(R.color.white_cp_util));

        }

    }

    /**
     * @param mContext
     * @param shoucang_tuijian_shouyi
     * @param shouYI
     */
    public static void showShouYi(Context mContext, TextView shoucang_tuijian_shouyi, float shouYI) {

        if (shouYI > 0) {
            shoucang_tuijian_shouyi.setTextColor(mContext.getResources().getColor(R.color.xiaoshutou_text_fe5933));
            shoucang_tuijian_shouyi.setText("+" + MathExtend.round(shouYI, 2) + "%");


        } else if (shouYI == 0) {
            shoucang_tuijian_shouyi.setTextColor(mContext.getResources().getColor(R.color.xiaoshutou_text_666666));
            shoucang_tuijian_shouyi.setText("0.00%");


        } else if (shouYI
                < 0) {
            shoucang_tuijian_shouyi.setText("" + MathExtend.round(shouYI, 2) + "%");


            shoucang_tuijian_shouyi.setTextColor(mContext.getResources().getColor(R.color.main_color));

        }

    }


    /**
     * @param mContext
     * @param shoucang_tuijian_shouyi
     * @param shouYI
     */
    public static void showShouYiZhenFu(Context mContext, TextView shoucang_tuijian_shouyi, float shouYI) {

        if (shouYI > 0) {
            shoucang_tuijian_shouyi.setTextColor(mContext.getResources().getColor(R.color.white_cp_util));
            shoucang_tuijian_shouyi.setText("+" + MathExtend.round(shouYI, 2));


        } else if (shouYI == 0) {
            shoucang_tuijian_shouyi.setTextColor(mContext.getResources().getColor(R.color.white_cp_util));
            shoucang_tuijian_shouyi.setText("0.00");


        } else if (shouYI
                < 0) {
            shoucang_tuijian_shouyi.setText("" + MathExtend.round(shouYI, 2));


            shoucang_tuijian_shouyi.setTextColor(mContext.getResources().getColor(R.color.white_cp_util));

        }

    }


    /**
     * @param mContext
     * @param shoucang_tuijian_shouyi
     * @param shouYI
     */
    public static void showShouYiYuan(Context mContext, TextView shoucang_tuijian_shouyi, float shouYI) {

        if (shouYI > 0) {
            shoucang_tuijian_shouyi.setTextColor(mContext.getResources().getColor(R.color.xiaoshutou_text_fe5933));
            shoucang_tuijian_shouyi.setText("+" + MathExtend.round(shouYI, 2));


        } else if (shouYI == 0) {
            shoucang_tuijian_shouyi.setTextColor(mContext.getResources().getColor(R.color.xiaoshutou_text_666666));
            shoucang_tuijian_shouyi.setText("0.00");


        } else if (shouYI
                < 0) {
            shoucang_tuijian_shouyi.setText("" + MathExtend.round(shouYI, 2));


            shoucang_tuijian_shouyi.setTextColor(mContext.getResources().getColor(R.color.main_color));

        }

    }

    /**
     * 根据证件名称取取证件id
     *
     * @return
     */

    public String getGuanXiId(String zhenJianType) {


        if (zhenJianType.equals("本人")) {
            return "1";
        }


        if (zhenJianType.equals("妻子")) {
            return "2";
        }

        if (zhenJianType.equals("丈夫")) {
            return "3";
        }

        if (zhenJianType.equals("儿子")) {
            return "4";
        }

        if (zhenJianType.equals("女儿")) {
            return "5";
        }

        if (zhenJianType.equals("父亲")) {
            return "6";
        }

        if (zhenJianType.equals("母亲")) {
            return "7";
        }
        if (zhenJianType.equals("兄弟")) {
            return "8";
        }

        if (zhenJianType.equals("雇主")) {
            return "20";
        }

        if (zhenJianType.equals("雇员")) {
            return "21";
        }
        if (zhenJianType.equals("法定监护人")) {
            return "22";
        }
        if (zhenJianType.equals("其他")) {
            return "23";
        }


        return "23";

    }

    /**
     * @return
     */

    public String[] getZhenJianLeiXin() {


        String[] strValue = {"身份证", "护照", "出生证", "驾照", "港澳通行证", "军官证", "台胞证", "警官证", "其他"};

        return strValue;

    }

    /**
     * 根据证件名称取取证件id
     *
     * @return
     */

    public String getZhenJianLeiXinId(String zhenJianType) {


        if (zhenJianType.equals("身份证")) {
            return "1";
        }


        if (zhenJianType.equals("护照")) {
            return "2";
        }

        if (zhenJianType.equals("出生证")) {
            return "3";
        }

        if (zhenJianType.equals("驾照")) {
            return "4";
        }

        if (zhenJianType.equals("港澳通行证")) {
            return "5";
        }

        if (zhenJianType.equals("军官证")) {
            return "6";
        }

        if (zhenJianType.equals("台胞证")) {
            return "7";
        }
        if (zhenJianType.equals("警官证")) {
            return "8";
        }

        if (zhenJianType.equals("其他")) {
            return "99";
        }


        return "99";

    }

    /**
     * 根据证件名称取取证件id
     *
     * @return
     */

    public String getZhenJianLeiXinName(String zhenJianType) {


        if (zhenJianType.equals("1")) {
            return "身份证";
        }


        if (zhenJianType.equals("2")) {
            return "护照";
        }

        if (zhenJianType.equals("3")) {
            return "出生证";
        }

        if (zhenJianType.equals("4")) {
            return "驾照";
        }

        if (zhenJianType.equals("5")) {
            return "港澳通行证";
        }

        if (zhenJianType.equals("6")) {
            return "军官证";
        }

        if (zhenJianType.equals("7")) {
            return "台胞证";
        }
        if (zhenJianType.equals("8")) {
            return "警官证";
        }

        if (zhenJianType.equals("99")) {
            return "其他";
        }


        return "其他";

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




    /**
     * 设置做过风测了
     */
    public void setFenCe(Context context, User user, String type) {
        SharePreferencesUitl.put(context, user.getUserId() + AppConfig.FENPING, type);


    }


    /**
     * 设置做过绑卡了
     */
    public void setBangKa(Context context, User user, String type) {
        SharePreferencesUitl.put(context, user.getUserId() + AppConfig.BANGKA, type);


    }


    /**
     * 设置做过开户了
     */
    public void setKaiHu(Context context, User user, String type) {
        SharePreferencesUitl.put(context, user.getUserId() + AppConfig.KAIHU, type);


    }





    public static Dialog simplecDialog;

    /**
     * 根据风险类型，返回 名字
     *
     * @return
     * @para m
     */
    public static String getFenXianStr(int fenxian) {
        String string = "";
        switch (fenxian) {
            case 1:
                string = "低风险";
                break;

            case 2:
                string = "较低风险";

                break;
            case 3:
                string = "中等风险";

                break;
            case 4:
                string = "较高风险";

                break;
            case 5:
                string = "高风险";

                break;
        }
        return string;

    }


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


    /**
     * @param webView
     */

    public static void setWebViewSetting(WebView webView) {


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //设置 缓存模式
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
// 开启 DOM storage API 功能
        webSettings.setDomStorageEnabled(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setDomStorageEnabled(true);

         webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);

    }


}
