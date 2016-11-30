package com.anyin.guwentong.event;


import com.anyin.guwentong.bean.responbean.User;
import com.cp.mylibrary.event.BaseEvent;

/**
 *  用户登录 的事件
 * Created by Jerry on 2016/6/23.
 */
public class LoginEvent extends BaseEvent {

     // 当前 登录 用户
     private User loginUser ;

    public User getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }
}
