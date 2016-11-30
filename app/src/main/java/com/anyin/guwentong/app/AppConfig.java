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

    //http://192.168.1.49:18080/appFundService/4
    //
// 访问路径

    // 服务器：192.168.1.49:18080
    //播明：192.168.1.126:8080
    //测试环境;192.168.1.175:9090
    // app.ailibuli.cn
    // public static final String HOST = "appxst.ailibuli.cn";
    public static final String HOST = "192.168.1.49:18080";
    // public static final String HOST = "192.168.1.126:8080";

    //public static final String HOST = "192.168.1.225:9090";

    /**
     * 是否是开发阶段，在发包时，注意把这里设置为false
     */

    public static final boolean isDevelop = false;

    public static final boolean isDevelop_yanzhema = true;


    //  隔多久再重新取验证码
    public static final int YANZHENMA_TIME = 60;

    /**
     * 保存用户的文件名
     */
    public static final String USER_FILE_NAME = "xiaoshutouuser";
    // 整个app用得字体
//    public static final String APP_FONT = "fonts/test.ttf";


    public static final String JIAOYIMIMA_TIP = "交易密码(非银行卡密码)";


    public static final String AccessKeyId = "LTAIE4SakrqXPNmW";

    public static final String AccessKeySecret = "2HF1XvwZmY3744aTWcuayVufkfxVma";
    public static final String AccessKeyEndPoint = "http://oss-cn-hangzhou.aliyuncs.com";
    public static final String AccessKeyBucketName = "xiaoshutou-bucket";

    public static final String headImage = "http://xiaoshutou-bucket.oss-cn-hangzhou.aliyuncs.com";


    public static final String K_MD5_APPID = "K_MD5_APPID";


    public static final String K_MD5_KEY = "K_MD5_KEY";

    // 加密解密的key
    public static final String CREATE_KEY = "UunzmKxbutcBnD4qcBNQQQ==";


    //  保险，暂时保存在本地的本人信息
    public static final String BAOXIAN_BENREN_INFO = "baoxian_benre_info";

    //  保险，暂时保存在本地的被保人信息
    public static final String BAOXIAN_BEIBAOREN_INFO = "baoxian_beibaoren_info";


    public static final String C0000 = "0000";


    public static final String FUND_ALL = "0";
    public static final String FUND_GUPIAO = "1";
    public static final String FUND_HUNHE = "2";
    public static final String FUND_HUOBI = "3";
    public static final String FUND_ZHAIQUAN = "4";
    public static final String FUND_QITA = "5";


    // 保险
    public static final String BAOXIAN_ALL = "99";
    public static final String BAOXIAN_YIWAI = "0";

    public static final String BAOXIAN_JIANKANG = "1";
    public static final String BAOXIAN_ZHONGJI = "2";
    public static final String BAOXIAN_YILIAO = "3";
    public static final String BAOXIAN_LVYOU = "4";
    public static final String BAOXIAN_CAICHAN = "5";
    public static final String BAOXIAN_SHAOER = "6";
    public static final String BAOXIAN_LAOREN = "7";


    public static final String isCurrencyFundN = "N";

    public static final String isCurrencyFundC = "C";


    // 支付保险的订单，支付保险是跳转到webview界面去支付的，在返回时要返回到保单的列表界面
    public static final String ZHIFU_BAOXIAN = "支付保险订单";

    public static final String C00009999 = "00009999"; // 未知错误
    public static final String C00020000 = "00020000"; // 数据库操作失败
    public static final String C00060001 = "00060001"; // 通讯异常
    public static final String C00060002 = "00060002"; // 通讯超时

    public static final String C00008888 = "00008888"; // 交易密码错误

    /**
     * 获取验证码失败
     */
    public static final String C10010001 = "10010001";
    /**
     * 手机号码不能为空
     */
    public static final String C10010002 = "10010002";
    /**
     * 验证码已过期
     */
    public static final String C10010003 = "10010003";
    /**
     * 该手机号已经注册
     */
    public static final String C10010004 = "10010004";

    /**
     * 手机号填写错误
     */
    public static final String C10010005 = "10010005";

    /**
     * 登录过期
     */
    public static final String C10010017 = "10010017";


    /**
     * 账号或密码为空
     */
    public static final String C10010006 = "10010006";

    /**
     * 参数解析失败
     */
    public static final String C10010007 = "10010007";

    // 是否开户
    public static final String KAIHU = "kaihu";
    // 是否绑卡
    public static final String BANGKA = "bangka";
    // 是否风评
    public static final String FENPING = "fenpings";

    public static final String FENXIAN_BAOSHOU = "保守型";
    public static final String FENXIAN_JIJI = "积极型";
    public static final String FENXIAN_WENJIAN = "稳健型";


    public static final String URL_ABOUT_ME = "http://webapp.ailibuli.cn/aboutus/";


    public static final String URL_QUESTION = "http://webapp.ailibuli.cn/aboutus/question.html";

    public static final String URL_AGREEMENT = "http://webapp.ailibuli.cn/aboutus/agreement.html";

    public static final String URL_XIAOSHUTOU_XIEYI = "http://webapp.ailibuli.cn/xiaoShuTou/static/userDeal.html";

    public static final String URL_KAIHU_XIEYI = "http://webapp.ailibuli.cn/xiaoShuTou/static/accountDeal.html";

    public static final String URL_QUANYIXUZHI = "http://webapp.ailibuli.cn/xiaoShuTou/static/investorDeal.html";

    public static final String URL_SANFANGXIEYI = "http://webapp.ailibuli.cn/xiaoShuTou/static/fundDeal.html";

    public static final String URL_TOUBAOSHENMING = "http://webapp.ailibuli.cn/xiaoShuTou/static/InsuranceDeclaration.html";


    public static final String KE_FU_TELL = "4000-628-333";
    public static final String KE_FU_TEXT_ONE = "#666666";
    public static final String KE_FU_TEXT_TWO = "#00b38a";
    public static final String KE_FU_TEXT_STRING = "联系客服：";


    public static String getKeFuTell() {
        return KE_FU_TELL;

    }

}
