package com.anyin.guwentong.api;


import com.anyin.guwentong.bean.requestbean.EncryData;
import com.anyin.guwentong.utils.ServerDataDeal;
import com.cp.mylibrary.api.MyHttpClient;
import com.cp.mylibrary.api.MyHttpParams;
import com.cp.mylibrary.api.MyResponseHandler;
import com.cp.mylibrary.utils.LogCp;

/**
 * Created by Jerry on 2016/6/23.
 */
public class MyAPI {

    /**
     * API接口
     * 这是接口类
     *
     * @author Administrator
     */


    // ====================================访问方式================================================

    /**
     * 访问服务器
     * post
     *
     * @param
     * @param url
     * @param
     */
    public static void serverPost(EncryData encryptData, String url,
                                  MyResponseHandler handler) {


        // 加密后的string
        String myEncryptData = ServerDataDeal.paramSecret(encryptData);


        MyHttpParams params = new MyHttpParams();

        params.put("encryptData", myEncryptData);

        LogCp.i(LogCp.CP, MyAPI.class + "    加 ，   params " + params.getUrlParams() + ",,");


        MyHttpClient.post(url, params, handler);

    }

    /**
     * get
     *
     * @param url
     * @param handler
     */
    public static void serverGet(String url, MyResponseHandler handler) {
        MyHttpClient.get(url, handler);
    }


    /**
     * 向服务器上传json数据
     *
     * @param
     * @param jsonStr
     */
    public static void postJsonUpServer(String url, String jsonStr,
                                        MyResponseHandler handler) {
        MyHttpClient.postJsonUpServer(url, jsonStr, handler);
    }

    // =====================================接口======================================




}
