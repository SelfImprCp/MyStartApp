package com.anyin.guwentong.utils;

import android.content.Context;


import com.anyin.guwentong.bean.responbean.User;
import com.anyin.guwentong.event.LoginEvent;
import com.anyin.guwentong.app.AppConfig;
import com.anyin.guwentong.event.ExitUserEvent;
import com.cp.mylibrary.utils.FileUtil;
import com.cp.mylibrary.utils.GsonUtil;
import com.cp.mylibrary.utils.LogCp;
import com.cp.mylibrary.utils.StringUtils;

import de.greenrobot.event.EventBus;

/**
 * Created by Jerry on 2016/7/22.
 * <p/>
 * 当前登录用户管理 类，
 */
public class UserManageUtil {


    /**
     * 保存当前登录用户
     *
     * @param user
     */
    public static void saveLoginUser(Context context, User user) {


        LogCp.i(LogCp.CP, UserManageUtil.class + " 修改信息，保存用户信息，年临： 设置默认之前 " + user.getBornDate());


        // 如果 为null就设置 默认值

        if (StringUtils.isEmpty(user.getHeadImage())) {
            user.setHeadImage("");

        }


        if (StringUtils.isEmpty(user.getNickName())) {
            user.setNickName(" 小爱");

        }




        if (StringUtils.isEmpty(user.getBornDate())) {
            user.setBornDate("1995-06-21");

        }


        if (StringUtils.isEmpty(user.getSex() + "")) {
            user.setSex(1);

        }


        if (StringUtils.isEmpty(user.getAddress())) {
            user.setAddress("广东 广州");

        }


        if (StringUtils.isEmpty(user.getIntegral())) {
            user.setIntegral("0");

        }

        LogCp.i(LogCp.CP, UserManageUtil.class + " 修改信息，保存用户信息，话 ： " + user.getUserPhone());


        // 以文件的方式保存用户


        FileUtil fileUtil = new FileUtil(context);
        try {
            String userGson = GsonUtil.beanTojsonStr(user);


            fileUtil.savePrivateDataDataPackageFiles(AppConfig.USER_FILE_NAME, userGson);
        } catch (Exception e) {
            e.printStackTrace();
        }


        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setLoginUser(user);
        EventBus.getDefault().post(loginEvent);

        LogCp.i(LogCp.CP, UserManageUtil.class + "发出 用户登录 成功的事件 事件 ");


    }


    /**
     * 返回当前登录用户，调用处为空判断
     *
     * @return
     */

    public static User getLoginUser(Context context) {


        User loginUser = null;


        FileUtil fileUtilT = new FileUtil(context);

        try {


            String readContent = fileUtilT.readDataDataPackageFiles(AppConfig.USER_FILE_NAME);
            if (!StringUtils.isEmpty(readContent)) {
                loginUser = GsonUtil.jsonStrToBean(readContent, User.class);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return loginUser;


    }


    /**
     * 是否有登录 用户。
     *
     * @return
     */
    public static boolean userIsLogin(Context context) {


        FileUtil fileUtilT = new FileUtil(context);

        User loginUser = null;

        try {


            String readContent = fileUtilT.readDataDataPackageFiles(AppConfig.USER_FILE_NAME);
            if (!StringUtils.isEmpty(readContent)) {
                loginUser = GsonUtil.jsonStrToBean(readContent, User.class);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        boolean isLogin = false;
        if (loginUser != null) {
            isLogin = true;
        }
        return isLogin;
    }


    /**
     * 用户退出，清除所有用户信息
     */

    public static void loginUserExit(Context context) {


        boolean isDelete = FileUtil.delelteFile(FileUtil.getDataDataFilePath(context), AppConfig.USER_FILE_NAME);


        LogCp.i(LogCp.CP, UserManageUtil.class + "  用户退出后，， 删除用户文件, " + isDelete);


        ExitUserEvent exitUserEvent = new ExitUserEvent();

        EventBus.getDefault().post(exitUserEvent);

        LogCp.i(LogCp.CP, UserManageUtil.class + "发出 用户 退出的事件  ");

        // 关闭消息

        PushMessageBind pushMessage = new PushMessageBind(context);
        try {
            pushMessage.stopPushMsg();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
