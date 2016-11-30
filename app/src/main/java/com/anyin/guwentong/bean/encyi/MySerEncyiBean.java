package com.anyin.guwentong.bean.encyi;


/**
 * /**
 * Created by Jerry on 2016/7/20.
 * <p/>
 * <p/>
 * 访问服务器的加密 bean
 * *  /
 * <p/>
 * {"data":{"resultCode":0,"resultMessage":"success","resultData":{"phone":"125844"},"timeStamp":1468986289953},"MD5":"2BD10777839BD31E8C060254F5C631ED"}
 * pcN3F2JqkWzBB8oALqtUxuWImoB4hqzVEEh0vEcKCFaWe5OgtyNstaYQibKMdE7hA8wqXEdlJIIsrKDQQyCVLGSZq5N2BkZgXfc2P99GuyYN+EknDcbBSyEOdOWg1VepFGFNnCqmXwaQXKX5cWEgVqAE4gYtFw/tai5Fooq3ouJObzY8ErSAOTNr9ajkRRU8+uDGOL0Z4lc=
 */
public class MySerEncyiBean  {

    private Data  data;
    private String MD5;

    public  Data  getData() {
        return data;
    }

    public void setData( Data  data) {
        this.data = data;
    }

    public String getMD5() {
        return MD5;
    }

    public void setMD5(String MD5) {
        this.MD5 = MD5;
    }
}
