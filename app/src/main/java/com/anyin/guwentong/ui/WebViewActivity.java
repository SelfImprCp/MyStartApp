package com.anyin.guwentong.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;


import com.anyin.guwentong.R;
import com.anyin.guwentong.base.BaseActivity;
import com.anyin.guwentong.utils.UIHelper;
import com.anyin.guwentong.utils.Uitl;

import com.anyin.guwentong.app.AppConfig;
import com.cp.mylibrary.custom.ProgressWebView;
import com.cp.mylibrary.custom.TitleBarView;
import com.cp.mylibrary.dialog.ShareDialog;
import com.cp.mylibrary.utils.ActivityManagerUtil;
import com.cp.mylibrary.utils.LogCp;
import com.cp.mylibrary.utils.StringUtils;

import org.kymjs.kjframe.ui.BindView;

/**
 * Created by Jerry on 2016/8/22.
 * <p/>
 * webview
 */
public class WebViewActivity extends BaseActivity {


    @BindView(id = R.id.webview_test_title)
    private TitleBarView webview_test_title;
    @BindView(id = R.id.webview_test_view)
    private ProgressWebView webview_test_view;


    public static final String WEB_TITLE = "web_title";
    public static final String WEB_URL = "web_url";
    public static final String WEB_SHARE_IMG = "web_share_img";
    public static final String WEB_SHARE_TITLE = "web_share_title";
    public static final String WEB_SHARE_URL = "web_share_url";

    // 直接显示html
    public static final String WEB_SHOW_HTML = "web_show_html";


    public static final String WEB_SHARE_CONTENT = "web_share_content";

    public static final String WEB_SHARE_TAG = "web_share";

    // 是否能分享
    public static final String WEB_SHARE_NO = "0";

    public static final String WEB_SHARE_YES = "1";


    // 要直接显示的html
    private String showHtml = "";

    // 显示的标题
    private String title = "";
    /**
     * 分享
     */
    public static ShareDialog mDialog;

    @Override
    public void setRootView() {
        super.setRootView();

        setContentView(R.layout.activity_webview);
    }

    @Override
    protected void initView() {
        super.initView();

        Bundle bundle = getIntent().getExtras();
        title = bundle.getString(WEB_TITLE);
        final String url = bundle.getString(WEB_URL);
        String web_share = bundle.getString(WEB_SHARE_TAG);
        final String share_url = bundle.getString(WEB_SHARE_URL);

        showHtml = bundle.getString(WEB_SHOW_HTML);


        if (web_share.equals(WEB_SHARE_YES)) {

            final String web_share_img = bundle.getString(WEB_SHARE_IMG);

            final String web_share_content = bundle.getString(WEB_SHARE_CONTENT);
            final String web_share_title = bundle.getString(WEB_SHARE_TITLE);


            webview_test_title.setTitleBarMenuImg(R.drawable.share_icon_hui);
            webview_test_title.setTitlebarMenuImgOnClick(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    mDialog = new ShareDialog(WebViewActivity.this, null);


                    LogCp.i(LogCp.CP, WebViewActivity.class + " 分享lian " + share_url + ",分享的标题 ：" + web_share_title +
                            ", 内容:" + web_share_content + ", 分享的图片 " + web_share_img);

                    mDialog.setShareInfo(web_share_title, web_share_content, share_url, web_share_img);
                    mDialog.setCancelable(true);
                    mDialog.setCanceledOnTouchOutside(true);
                    mDialog.setTitle(R.string.share_to);
                    mDialog.show();


                }
            });


        }

        LogCp.i(LogCp.CP, WebViewActivity.this + " 要加载的url " + url);

        Uitl.setWebViewSetting(webview_test_view);

        //webview_test_title.setTitleBackFinshActivity(this);

        webview_test_title.setTitleBackClick(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (webview_test_view.canGoBack() && !title.equals(AppConfig.ZHIFU_BAOXIAN)) {
                    webview_test_view.goBack(); // goBack()表示返回WebView的上一页面

                } else {


                    webViewFinish();

                }


            }
        });

        webview_test_title.setTitleStr(title);

        //   LogCp.i(LogCp.CP, WebViewActivity.class + " 显示的东西，" + showHtml);


        if (!StringUtils.isEmpty(showHtml)) {
//            showHtml =   showHtml.replace("<!DOCTYPE html>","");

            LogCp.i(LogCp.CP, WebViewActivity.class + " 显示的东西， 处理过" + showHtml);
//            String showHtml = "<html><body><font color='red'>hello baidu!</font></body></html>";

            //  webview_test_view.loadData(showHtml, "text/html", "UTF-8");
            webview_test_view.loadDataWithBaseURL(null, showHtml, "text/html", "UTF-8", null);


        } else {
            webview_test_view.loadUrl(url);



        }

//        webview_test_view.loadUrl("javascript:duck.getHealthOld()");
//
//


    }


    @Override
    // 设置回退
    // 覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview_test_view.canGoBack() && !title.equals(AppConfig.ZHIFU_BAOXIAN)) {
            webview_test_view.goBack(); // goBack()表示返回WebView的上一页面
            return true;
        } else {
            webViewFinish();
        }
        return super.onKeyDown(keyCode, event);
    }


    private void webViewFinish() {
        if (title.equals(AppConfig.ZHIFU_BAOXIAN)) {



            //关闭保单提交页面，支付页面
//            ActivityManagerUtil.getInstance().finishActivity(TiJiaoBaoXianDingDanActivity.class);
//            ActivityManagerUtil.getInstance().finishActivity(BaoXianZhiFuActivity.class);
//            ActivityManagerUtil.getInstance().finishActivity(RestartPayActivity.class);

            finish();

        } else {
            finish();
        }


    }


    /**
     * H5页面按钮点击触发事件
     */

        @JavascriptInterface
        public void checNewkNotify_new() {

            LogCp.i(LogCp.CP, WebViewActivity.class + " 点击到了h 5 ");
            webview_test_view.loadUrl("javascript:checNewkNotify_new()");
        }


}
