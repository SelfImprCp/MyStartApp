package com.anyin.guwentong.utils;

import android.content.Context;


import com.anyin.guwentong.bean.encyi.Data;
import com.anyin.guwentong.bean.encyi.MySerEncyiBean;

import com.anyin.guwentong.app.AppConfig;
import com.cp.mylibrary.utils.DateTimeUtil;
import com.cp.mylibrary.utils.GsonUtil;
import com.cp.mylibrary.utils.LogCp;
import com.cp.mylibrary.utils.ShowToastUtil;
import com.cp.mylibrary.utils.StringUtils;

/**
 * Created by Jerry on 2016/7/20.
 * <p/>
 * 对数据的处理，
 * 包括，在请求中对请求参数时行 加密，，对从服务器上拿来的数据进行解密，判断是否合法
 */
public class ServerDataDeal {


    /**
     * 这个方法是向服务器请求数据时，对参数进行的加密
     * 传入一个请参的实体，加密成string返回
     *
     * @param obj
     * @return
     */
    public static <T> String paramSecret(T obj) {

        MySerEncyiBean mySerEncyiBean = new MySerEncyiBean();

        Data data = new Data();

        data.setResultCode(AppConfig.C0000);
        data.setResultMessage("success");
        data.setResultData(obj);
        data.setTimeStamp(DateTimeUtil.getTimesTamp() + "");


        String strJson = GsonUtil.beanTojsonStr(data);


        //    LogCp.i(LogCp.CP, ServerDataDeal.class + "  生成的 json  " + strJson.toString());


        String strMD5 = Md5Tool.get32Md5(strJson + AppConfig.K_MD5_APPID + AppConfig.K_MD5_KEY);


        mySerEncyiBean.setData(data);
        mySerEncyiBean.setMD5(strMD5);


        String mySerEncyiBeanJson = GsonUtil.beanTojsonStr(mySerEncyiBean);


        //  LogCp.i(LogCp.CP, ServerDataDeal.class + "   可以提交 的gson  : " + mySerEncyiBeanJson);

// 再把这个json ，进行加密
        String ecnryStr = "";
        try {
            ecnryStr = Encryp.encrypData(AppConfig.CREATE_KEY, mySerEncyiBeanJson);

            //        LogCp.i(LogCp.CP, ServerDataDeal.class + "    加密出来的基辛格，   : " + ecnryStr);

            String decry = Encryp.decryptData(AppConfig.CREATE_KEY, ecnryStr);
            //      LogCp.i(LogCp.CP, ServerDataDeal.class + "    解密出来的基辛格，   : " + decry);


        } catch (Exception e) {
            e.printStackTrace();
        }


        String username = ecnryStr.replace("+", "%2B");

        return username;

    }


    /**
     * 返回成功是否
     *
     * @param context
     * @param noJieMi
     * @return
     */
//
//    public static MySerEncyiBean decryptDataRes(Context context, String noJieMi) {
//
//        MySerEncyiBean mySerEncyiBean = null;
//
//
//        AiResponBean aiResponBean = GsonUtil.jsonStrToBean(noJieMi, AiResponBean.class);
//
////        LogCp.i(LogCp.CP, ServerDataDeal.class + "  取得的  encryptData 里面的值 ： " + aiResponBean.getEncryptData());
//
//
//        String decry = "";
//        try {
//            decry = Encryp.decryptData(AppConfig.CREATE_KEY, aiResponBean.getEncryptData());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        LogCp.i(LogCp.CP, ServerDataDeal.class + "    解密出来的GSON，   : " + decry);
//
//        // 截取data进行md5的对比
//
//
//        if (!StringUtils.isEmpty(decry)) {
//
//            // 解密出来的数据 进行json 解析
//
//            mySerEncyiBean = GsonUtil.jsonStrToBean(decry, MySerEncyiBean.class);
//
//
//        }
//
//        return mySerEncyiBean;
//
//
//    }

    /**
     *
     *  要返回值的解析 的是没有 "resultCode":"0000" 值的
     *
     * 对从服务器返回的数据 进行解密及处理
     * <p/>
     * 返回的是一段截取过的json :
     * 截取出来的结果，   :
     * {"resultCode":"0000","resultMessage":"success","resultData":{"code":"108088"},"timeStamp":"1469070403299"}
     */
//    public static <T> T decryptDataAndDeal(Context context, String noJieMi, Class<T> cls) {
//
//        AiResponBean aiResponBean = GsonUtil.jsonStrToBean(noJieMi, AiResponBean.class);
//
////        LogCp.i(LogCp.CP, ServerDataDeal.class + "  取得的  encryptData 里面的值 ： " + aiResponBean.getEncryptData());
//
//
//        String decry = "";
//        try {
//            decry = Encryp.decryptData(AppConfig.CREATE_KEY, aiResponBean.getEncryptData());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        LogCp.i(LogCp.CP, ServerDataDeal.class + "    解密出来的GSON，   : " + decry);
//
//        // 截取data进行md5的对比
//
//
//        if (!StringUtils.isEmpty(decry)) {
//            // 解密出来的数据 进行json 解析
//
//            MySerEncyiBean mySerEncyiBean = GsonUtil.jsonStrToBean(decry, MySerEncyiBean.class);
//            LogCp.i(LogCp.CP, ServerDataDeal.class + "     返回码，   : " + mySerEncyiBean.getData().getResultCode());
//
//            // 数据成功了
//            if (mySerEncyiBean.getData().getResultCode().equals(AppConfig.C0000)) {
//
//
//                String jieguo = StringUtils.getSubString("{\"resultCode\"", ",\"MD5\"", decry);
//
//
////          LogCp.i(LogCp.CP, ServerDataDeal.class + "    截取出来的结果，   : " + jieguo);
//
//                // 用data gson 生成md5
//                String dataMd5 = Md5Tool.get32Md5(jieguo + AppConfig.K_MD5_APPID + AppConfig.K_MD5_KEY);
//
//                //   LogCp.i(LogCp.CP, ServerDataDeal.class + "    解密出来的 ， data 生成的Md5   : " + dataMd5);
////            //判断 自己生成的和服务器返回的是不是一样
//
//
//                // 数据相同
//                if (mySerEncyiBean.getMD5().equals(dataMd5)) {
//
//
//                    return getResponBean(jieguo, cls);
//
//
//                }
//
//            } else if (mySerEncyiBean.getData().getResultCode().equals(AppConfig.C10010017)) {
//
//
//                ShowToastUtil.showToast(context, mySerEncyiBean.getData().getResultMessage());
//                //登录过期了
//                UserManageUtil.loginUserExit(context);
////                UIHelper.showLogin(context);
//
//
//            } else {
//                //数据 失败了
//                ShowToastUtil.showToast(context, mySerEncyiBean.getData().getResultMessage());
//
//
//            }
//
//
//        }
//
//        return null;
//
//
//    }


    /**
     * 转换成调用处需要的对像类型返回
     */
    public static <T> T getResponBean(String jieGuo, Class<T> cls) {


        String string = "{" + StringUtils.getSubString("\"resultData\"", ",\"timeStamp\"", jieGuo) + "}";

        //  LogCp.i(LogCp.CP, ServerDataDeal.class + "    截出来的只包含数据 的gson jieGuo  : " + string);
//        String strStr = StringUtils.getSubString(13, string.length(), string);

//        ResultDataBean  resultDataBean = new ResultDataBean();
//        resultDataBean.setResultData(cls);

//        ResultDataBean  resultDataBeanB =   GsonUtil.jsonStrToBean(string,ResultDataBean.class);

        //     LogCp.i(LogCp.CP, ServerDataDeal.class + "   resultDataBeanB.getResultData()   的gson   : " + resultDataBeanB.getResultData());


        //   LogCp.i(LogCp.CP, ServerDataDeal.class + "    截出来的只包含数据 的gson   : " + strStr);
//
        return GsonUtil.jsonStrToBean(string, cls);

    }


}
