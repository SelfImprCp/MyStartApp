package com.anyin.guwentong.res;


import com.anyin.guwentong.bean.responbean.RegisterBean;
import com.cp.mylibrary.res.Response;

/**
 * 注册 返回
 * Created by Jerry on 2016/7/18.
 */
public class RegisterRes extends Response {


     private RegisterBean resultData;

    public RegisterBean getResultData() {
        return resultData;
    }

    public void setResultData(RegisterBean resultData) {
        this.resultData = resultData;
    }
}
