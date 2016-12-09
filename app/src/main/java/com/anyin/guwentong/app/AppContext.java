package com.anyin.guwentong.app;

import android.app.Notification;
import android.content.Context;
import android.os.Handler;

import com.anyin.guwentong.R;
import com.anyin.guwentong.utils.Uitl;
import com.cp.mylibrary.api.MyHttpClient;
import com.cp.mylibrary.app.Config;
import com.cp.mylibrary.app.MyBaseApp;
import com.cp.mylibrary.utils.ImageLoaderUtils;
import com.cp.mylibrary.utils.LogCp;
import com.umeng.message.PushAgent;
import com.umeng.message.UTrack;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.entity.UMessage;


public class AppContext extends MyBaseApp {
    private Notification mNotification;
    public static final int NOTIFY_ID = 0x912;// 通知ID
    private PushAgent mPushAgent;

    private static AppContext context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;


        if (!AppConfig.isDevelop)
        {
            MyHttpClient.initHttp(Uitl.getInstance().getHOST());


        }

        // 友盟推送
        initUMPush();

        // 配置图片

        ImageLoaderUtils.configImageLoader(this, R.drawable.default_100_100, R.drawable.default_100_100, R.drawable.default_100_100, Config.DEFAULT_SAVE_FILE_PATH);

        // 处理tab
        initViewPageSetting();


    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    /**
     * 友盟推送消息回调
     */
    private void initUMPush() {

        // 使用自定义的NotificationHandler，来结合友盟统计处理消息通知
        // 参考http://bbs.umeng.com/thread-11112-1-1.html
        // CustomNotificationHandler notificationClickHandler = new
        // CustomNotificationHandler();

        // 友盟推送


        //{"seqNo":"w20160822085454815ad5722c891da4096997fe72c9c1326aa","title":"爱理钱包转入成功","userId":"f8bb500a-ed22-4434-a23c-20626c36e531","content":"你于2012年1月1日转入爱理钱包1000.1元已确认成功  3333 ccc "}


        mPushAgent = PushAgent.getInstance(this);


        mPushAgent.setDebugMode(true);

        // 友盟推送

        UmengMessageHandler messageHandler = new UmengMessageHandler() {

            @Override
            public void dealWithNotificationMessage(Context context, UMessage msg) {
                super.dealWithNotificationMessage(context, msg);

            }

            @Override
            public void dealWithCustomMessage(Context arg0, final UMessage msg) {
                new Handler().post(new Runnable() {

                    @Override
                    public void run() {
                        // 对自定义消息的处理方式，点击或者忽略
                        boolean isClickOrDismissed = true;
                        if (isClickOrDismissed) {
                            // 自定义消息的点击统计
                            UTrack.getInstance(getApplicationContext())
                                    .trackMsgClick(msg);
                        } else {
                            // 自定义消息的忽略统计
                            UTrack.getInstance(getApplicationContext())
                                    .trackMsgDismissed(msg);
                        }
                        // UIHelper.showToast("友盟推送的自定义消息 " + msg.custom);


                        // ********************** 处理业务

                        LogCp.i(LogCp.CP, AppContext.class + "  收到友盟的自定义消息 "
                                + msg.custom + " msg.extra;;" + msg.extra);


//                        PushMesgBean pushMesgBean = GsonUtil.jsonStrToBean(msg.custom, PushMesgBean.class);
//

//                        // 处理新补丁，补丁使用360加固后，会用不了，暂时不做
//                        if (pushMesgBean.getContent().equals("有新补丁")) {
//
//
//
//
//
////          ShowToastUtil.showToast(this, "测试热补丁修改后，我已经修改了，修改了 ");
//
//                            //   ShowToastUtil.showToast(this,"测试热补丁修改 前前前前前，， ");
//
//                            // 下载补丁
//
//
////        ShowToastUtil.showToast(MainActivity.this, "下载文件来了");
//
////        FileUtil fileUtil = new FileUtil(MainActivity.this);
////        fileUtil.dowloadFile(Config.APATCH_NAME, "http://h5image.oss-cn-shanghai.aliyuncs.com/out.apatch");
//
//
//                        } else
//                        // 处理推送消息
//                        {
//
//
//                            // 设置 弹出通知
//
//                            int icon = R.drawable.ic_launcher;
//                            CharSequence tickerText = "小树投";
//                            long when = System.currentTimeMillis();
//
//                            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
//                                    context);
//                            // 定义NotificationManager
//                            String ns = Context.NOTIFICATION_SERVICE;
//                            NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
//                            // 定义通知栏展现的内容信息
//
//                            mNotification = new Notification(icon, tickerText, when);
//                            mNotification.flags = Notification.FLAG_AUTO_CANCEL;
//                            // 设置默认声音
//                            mNotification.defaults |= Notification.DEFAULT_SOUND;
//                            // 设定震动(需加VIBRATE权限)
//                            // mNotification.defaults |=
//                            // Notification.DEFAULT_VIBRATE;
//                            mNotification.contentView = null;
//
//
//                            Intent intentCC = new Intent(context,
//                                    MessageListActivity.class);
//
//                            PendingIntent pendingIntent = PendingIntent
//                                    .getActivity(context, 0, intentCC, 0);
////
////                        mNotification.setLatestEventInfo(context,
////                                pushMesgBean.getTitle(), pushMesgBean.getContent(),
////                                pendingIntent);
//
//                            Notification notification = new Notification.Builder(context)
//                                    .setAutoCancel(true)
//                                    .setContentTitle(pushMesgBean.getTitle())
//                                    .setContentText(pushMesgBean.getContent())
//                                    .setContentIntent(pendingIntent)
//                                    .setSmallIcon(R.drawable.ic_launcher)
//                                    .setWhen(System.currentTimeMillis())
//                                    .build();
//
//
//                            mNotificationManager.notify(NOTIFY_ID,
//                                    notification);// 通知一下才会生效哦
//
//                            mBuilder.setContentIntent(pendingIntent);
//
//
//                            NewMessageEvent newMessageEvent = new NewMessageEvent();
//                            EventBus.getDefault().post(newMessageEvent);
//
//                        }


                        // ****************************

                    }
                });
            }


        };

        mPushAgent.setMessageHandler(messageHandler);

    }


    private void initViewPageSetting() {
//
//        MyTabSetting myTabSetting = new MyTabSetting();
//        //设置圆角大小
//        myTabSetting.setmCorners(8);
//        //设置边框宽度
//        myTabSetting.setmStrokeWidth(2);
//        //设置边框颜色
//        myTabSetting.setmStrokeColor("#269edc");
//        // 设置选中时内部的填充颜色
//        myTabSetting.setmSolidColor("#269edc");
//        //设置没有选中时内部填充颜色
//        myTabSetting.setmNoSelectSolidColor("#FFFFFF");
//        //设置选中时文字的颜色
//        myTabSetting.setmTextSelectColor("#FFFFFF");
//        // 设置 没有选中时文字的颜色
//        myTabSetting.setmTextNormalColor("#269edc");


    }


}
