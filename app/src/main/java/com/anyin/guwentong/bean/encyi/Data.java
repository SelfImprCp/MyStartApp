package com.anyin.guwentong.bean.encyi;

/**
 * Created by Jerry on 2016/7/20.
 * <p/>
 * <p/>
 * {"data":{"resultCode":0,"resultMessage":"success","resultData":{"phone":"125844"},"timeStamp":1468986289953},"MD5":"2BD10777839BD31E8C060254F5C631ED"}
 * pcN3F2JqkWzBB8oALqtUxuWImoB4hqzVEEh0vEcKCFaWe5OgtyNstaYQibKMdE7hA8wqXEdlJIIsrKDQQyCVLGSZq5N2BkZgXfc2P99GuyYN+EknDcbBSyEOdOWg1VepFGFNnCqmXwaQXKX5cWEgVqAE4gYtFw/tai5Fooq3ouJObzY8ErSAOTNr9ajkRRU8+uDGOL0Z4lc=
 */
public class Data <T>{






    private String  resultCode;


    private String resultMessage;

    private T resultData;

    private String timeStamp;





    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public T getResultData() {
        return resultData;
    }

    public void setResultData(T resultData) {
        this.resultData = resultData;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }





}
