package com.anyin.guwentong.app;

import com.cp.mylibrary.utils.LogCp;

/**
 * Created by Jerry on 2016/10/10.
 */
public class AppConfig {


    /**
     * 编码时的一些注意事项：
     * 1.任何跳转前都要判断网络，没有网络跳转不了
     * 2.加入友盟埋点 : MobclickAgent.onEvent(UserInfoActivity.this, "换头像");
     */


    // 热修改命令
    // apkpatch.bat -f after.apk -t befor.apk -o output1 -k ailibuli.jks -p ailibuli123456 -a ailibuli -e ailibuli123456


    // 请求前缀
    public static final String SUFFIX_SERVICE = "appService/";

    /**
     * 是否是开发阶段，在发包时，注意把这里设置为false
     */

    public static final boolean isDevelop = true;

    public static final boolean isDevelop_yanzhema = true;


    //  隔多久再重新取验证码
    public static final int YANZHENMA_TIME = 60;

    /**
     * 保存用户的文件名
     */
    public static final String USER_FILE_NAME = "xiaoshutouuser";
    // 整个app用得字体
//    public static final String APP_FONT = "fonts/test.ttf";


    public static final String K_MD5_APPID = "K_MD5_APPID";


    public static final String K_MD5_KEY = "K_MD5_KEY";

    // 加密解密的key
    public static final String CREATE_KEY = "UunzmKxbutcBnD4qcBNQQQ==";



    public static final String C0000 = "0000";




    // 支付保险的订单，支付保险是跳转到webview界面去支付的，在返回时要返回到保单的列表界面
    public static final String ZHIFU_BAOXIAN = "支付保险订单";




    public static final String KE_FU_TELL = "4000-628-333";

    public static String getKeFuTell() {
        return KE_FU_TELL;

    }

}
