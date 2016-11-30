package com.anyin.guwentong.main;


import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anyin.guwentong.R;
import com.anyin.guwentong.api.MyAPI;
import com.anyin.guwentong.app.AppConfig;
import com.anyin.guwentong.base.BaseFragment;

import com.anyin.guwentong.bean.responbean.User;

import com.anyin.guwentong.event.ExitUserEvent;
import com.anyin.guwentong.event.LoginEvent;
import com.anyin.guwentong.event.NewMessageEvent;
import com.anyin.guwentong.event.UserChangeUserHeadEvent;

import com.anyin.guwentong.utils.ServerDataDeal;
import com.anyin.guwentong.utils.UIHelper;
import com.anyin.guwentong.utils.Uitl;
import com.anyin.guwentong.utils.UserManageUtil;

import com.cp.mylibrary.api.MyResponseHandler;
import com.cp.mylibrary.custom.BadgeView;
import com.cp.mylibrary.dialog.DialogHelper;
import com.cp.mylibrary.dialog.ShareDialog;
import com.cp.mylibrary.pullto.XRefreshView;
import com.cp.mylibrary.utils.LogCp;
import com.cp.mylibrary.utils.NetWorkUtil;
import com.cp.mylibrary.utils.SharePreferencesUitl;
import com.cp.mylibrary.utils.ShowToastUtil;
import com.cp.mylibrary.utils.StringUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.umeng.analytics.MobclickAgent;
import com.zhy.autolayout.AutoRelativeLayout;

import org.kymjs.kjframe.widget.RoundImageView;

/**
 * 我的界面
 */

public class MyFragment extends BaseFragment implements View.OnClickListener {


    private RoundImageView my_img_head;

    private AutoRelativeLayout my_jijin_rel, my_baodan_rel;
    private AutoRelativeLayout my_fenxianceping_rel, my_jijin_jilv_rel, my_anquan_rel;

    private LinearLayout my_fragment_fundshuhui_lin, my_fragment_message_badgeview_lin, my_fragment_licaitixian_lin, my_fragment_liquan_lin, my_fragment_qiandao_lin, my_fragment_jifen_lin, my_fragment_fenxiang_lin;

    private FrameLayout my_fragment_message;


    private BadgeView my_fragment_message_badgeview;

    private XRefreshView fragment_my_refresh_view;


    private TextView my_fragment_zuorishouyi;


    private TextView my_fragment_chicangzongzichan;
    private TextView my_fragment_leijishouyi;


    private Dialog waitDialog;


    private ShareDialog mDialog;




    public MyFragment() {
    }


    @Override
    protected View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        return view;
    }


    @Override
    public void initView(View view) {
        my_img_head = (RoundImageView) view.findViewById(R.id.my_img_head);
        my_img_head.setOnClickListener(this);

        my_jijin_rel = (AutoRelativeLayout) view.findViewById(R.id.my_jijin_rel);
        my_jijin_rel.setOnClickListener(this);

        my_fenxianceping_rel = (AutoRelativeLayout) view.findViewById(R.id.my_fenxianceping_rel);
        my_fenxianceping_rel.setOnClickListener(this);

        my_jijin_jilv_rel = (AutoRelativeLayout) view.findViewById(R.id.my_jijin_jilv_rel);
        my_jijin_jilv_rel.setOnClickListener(this);
        my_anquan_rel = (AutoRelativeLayout) view.findViewById(R.id.my_anquan_rel);
        my_anquan_rel.setOnClickListener(this);


        my_baodan_rel = (AutoRelativeLayout) view.findViewById(R.id.my_baodan_rel);
        my_baodan_rel.setOnClickListener(this);


        my_fragment_fundshuhui_lin = (LinearLayout) view.findViewById(R.id.my_fragment_fundshuhui_lin);
        my_fragment_licaitixian_lin = (LinearLayout) view.findViewById(R.id.my_fragment_licaitixian_lin);
        my_fragment_liquan_lin = (LinearLayout) view.findViewById(R.id.my_fragment_liquan_lin);

        my_fragment_qiandao_lin = (LinearLayout) view.findViewById(R.id.my_fragment_qiandao_lin);

        my_fragment_jifen_lin = (LinearLayout) view.findViewById(R.id.my_fragment_jifen_lin);

        my_fragment_message_badgeview_lin = (LinearLayout) view.findViewById(R.id.my_fragment_message_badgeview_lin);

        my_fragment_fenxiang_lin = (LinearLayout) view.findViewById(R.id.my_fragment_fenxiang_lin);


        my_fragment_fundshuhui_lin.setOnClickListener(this);
        my_fragment_licaitixian_lin.setOnClickListener(this);
        my_fragment_qiandao_lin.setOnClickListener(this);
        my_fragment_jifen_lin.setOnClickListener(this);
        my_fragment_fenxiang_lin.setOnClickListener(this);


        my_fragment_liquan_lin.setOnClickListener(this);

        my_fragment_message = (FrameLayout) view.findViewById(R.id.my_fragment_message);

        my_fragment_message.setOnClickListener(this);


        my_fragment_zuorishouyi = (TextView) view.findViewById(R.id.my_fragment_zuorishouyi);
        my_fragment_chicangzongzichan = (TextView) view.findViewById(R.id.my_fragment_chicangzongzichan);
        my_fragment_leijishouyi = (TextView) view.findViewById(R.id.my_fragment_leijishouyi);


        my_fragment_message_badgeview = (BadgeView) view.findViewById(R.id.my_fragment_message_badgeview);


        // 刷新
        fragment_my_refresh_view = (XRefreshView) view.findViewById(R.id.fragment_my_refresh_view);


        fragment_my_refresh_view.setAutoRefresh(false);
        fragment_my_refresh_view.setPullLoadEnable(false);
        fragment_my_refresh_view.setPinnedTime(1000);
        fragment_my_refresh_view.setAutoLoadMore(false);
        fragment_my_refresh_view.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {

            @Override
            public void onRefresh() {


                LogCp.i(LogCp.CP, MyFragment.class + " 来刷新了。。");


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fragment_my_refresh_view.stopRefresh();
                        //

                    }
                }, 2000);

                // 刷新调用 接口
                getFragmentData();


            }


        });


    }

    @Override
    public void initData() {

        LogCp.i(LogCp.CP, MyFragment.class + "处理数据");


    }


    @Override
    public void onResume() {
        super.onResume();


        boolean isLogin = UserManageUtil.userIsLogin(getActivity());

        LogCp.i(LogCp.CP, MyFragment.class + "用户是否登录 " + isLogin);


        // 用户没有登录
        if (!isLogin) {
            noLoginShowUi();


        } else {
            loginShowUi();
        }


        // 取未读消息
//        getMessageNoReadSum();

    }


    /**
     * 登录时UI显示的情况
     */

    private void loginShowUi() {

        User loginUser = UserManageUtil.getLoginUser(getActivity());


        LogCp.i(LogCp.CP, MyFragment.class + "用户是否登录 话    " + loginUser.getUserPhone());

//        String newPhone = StringUtils.phone4Xing(loginUser.getUserPhone());


        if (!StringUtils.isEmpty(loginUser.getHeadImage())) {

//        my_img_head
            ImageLoader.getInstance().displayImage(loginUser.getHeadImage(), my_img_head);


        } else {
            my_img_head.setImageResource(R.drawable.no_login_head);
        }


        // 取数据


        //  if (mainFundAmountRes == null) {
        getFragmentData();

//        } else {
//            fillUITop();
//        }

    }


    /**
     * 没有登录时UI显示 的情况
     */
    private void noLoginShowUi() {


        my_img_head.setImageResource(R.drawable.no_login_head);


//        private TextView my_fragment_zuorishouyi;
//
//
//        private TextView my_fragment_chicangzongzichan;


        my_fragment_zuorishouyi.setText("0.00");
        my_fragment_chicangzongzichan.setText("0.00");
        my_fragment_leijishouyi.setText("0.00");


    }


    /**
     * 取首页的数据
     */
    private void getFragmentData() {


        User user = UserManageUtil.getLoginUser(getActivity());
        if (user != null) {



        }


    }




    @Override
    protected void widgetClick(View v) {
        super.widgetClick(v);
        switch (v.getId()) {
            // 头像
            case R.id.my_img_head:


                User user = UserManageUtil.getLoginUser(getActivity());

                if (NetWorkUtil.yesNext(getActivity())) {


                    if (user == null) {
                        MobclickAgent.onEvent(getActivity(), "从我的进入登录");

                        UIHelper.showLogin(getActivity());


                    } else {
                        MobclickAgent.onEvent(getActivity(), "从我的进入个人中心");


                    }


                }

                break;

            // 我的基金
            case R.id.my_jijin_rel:


//                User users = UserManageUtil.getLoginUser(getActivity());

                if (NetWorkUtil.yesNext(getActivity())) {
                    boolean isLoginttt = UserManageUtil.userIsLogin(getActivity());


                    if (!isLoginttt) {
                        ShowToastUtil.showToast(getActivity(), "请先登录");
                        UIHelper.showLogin(getActivity());
                    } else {
                        MobclickAgent.onEvent(getActivity(), "从我的进入我的基金 ");
                       }

                }

                break;


            //风险测评
            case R.id.my_fenxianceping_rel:


                if (NetWorkUtil.yesNext(getActivity())) {
                    boolean isLoginttt = UserManageUtil.userIsLogin(getActivity());


                    if (!isLoginttt) {
                        ShowToastUtil.showToast(getActivity(), "请先登录");
                        UIHelper.showLogin(getActivity());
                    } else {



                    }

                }


                break;

            //基金记录
            case R.id.my_jijin_jilv_rel:


                if (NetWorkUtil.yesNext(getActivity())) {
                    boolean isLoginttt = UserManageUtil.userIsLogin(getActivity());

                    if (!isLoginttt) {
                        ShowToastUtil.showToast(getActivity(), "请先登录");
                        UIHelper.showLogin(getActivity());
                    } else {
                 }

                }

                break;


            // 理财提现
            case R.id.my_fragment_licaitixian_lin:


//                if (mDialog == null)
//                    mDialog = new ShareDialog(getActivity()  ,getActivity());
//                mDialog.setShareInfo("标题","内容","www.baidu.com","http://img0.imgtn.bdimg.com/it/u=1126541908,2603454962&fm=21&gp=0.jpg");
//                mDialog.setCancelable(true);
//                mDialog.setCanceledOnTouchOutside(true);
//                mDialog.setTitle(R.string.share_to);
//                mDialog.show();
//
//
//

                ShowToastUtil.showToast(getActivity(), "暂无理财提现");


                break;


            // 基金赎回
            case R.id.my_fragment_fundshuhui_lin:


                if (NetWorkUtil.yesNext(getActivity())) {
                    boolean isLoginttt = UserManageUtil.userIsLogin(getActivity());

                    if (!isLoginttt) {
                        ShowToastUtil.showToast(getActivity(), "请先登录");
                        UIHelper.showLogin(getActivity());
                    } else {

                    }

                }


                break;


            // 进入 消息 列表
            case R.id.my_fragment_message:


                if (NetWorkUtil.yesNext(getActivity())) {
                    boolean isLoginttt = UserManageUtil.userIsLogin(getActivity());

                    if (!isLoginttt) {
                        ShowToastUtil.showToast(getActivity(), "请先登录");
                        UIHelper.showLogin(getActivity());
                    } else {

                    }

                }


                break;


            // 我的礼券
            case R.id.my_fragment_liquan_lin:


                if (NetWorkUtil.yesNext(getActivity())) {
                    boolean isLoginttt = UserManageUtil.userIsLogin(getActivity());

                    if (!isLoginttt) {
                        ShowToastUtil.showToast(getActivity(), "请先登录");
                        UIHelper.showLogin(getActivity());
                    } else {



                    }

                }


                break;

            // 积分
            case R.id.my_fragment_jifen_lin:


                if (NetWorkUtil.yesNext(getActivity())) {

                    User userS = UserManageUtil.getLoginUser(getActivity());

                    if (userS != null) {


                    } else {
                        ShowToastUtil.showToast(getActivity(), "请先登录");
                        UIHelper.showLogin(getActivity());
                    }


                }


                break;


            // 每日签到
            case R.id.my_fragment_qiandao_lin:
                if (NetWorkUtil.yesNext(getActivity())) {
                    boolean isLoginttt = UserManageUtil.userIsLogin(getActivity());

                    if (!isLoginttt) {
                        ShowToastUtil.showToast(getActivity(), "请先登录");
                        UIHelper.showLogin(getActivity());
                    } else {

                    }

                }


                break;


            // 分享
            case R.id.my_fragment_fenxiang_lin:


                if (NetWorkUtil.yesNext(getActivity())) {

                    User userS = UserManageUtil.getLoginUser(getActivity());


                    if (userS != null) {

                        if (mDialog == null)
                            mDialog = new ShareDialog(getActivity(), getActivity());
                        mDialog.setShareInfo("标题", "内容", "www.baidu.com", "http://pic1.duowan.com/jx3/0906/108315967740/108316321588.jpg");
                        mDialog.setCancelable(true);
                        mDialog.setCanceledOnTouchOutside(true);
                        mDialog.setTitle(R.string.share_to);
                        mDialog.show();
                    } else {
                        ShowToastUtil.showToast(getActivity(), "请先登录");
                        UIHelper.showLogin(getActivity());

                    }

                }


                break;


            // 安全中心
            case R.id.my_anquan_rel:


                break;


            // 保单列表
            case R.id.my_baodan_rel:
                if (NetWorkUtil.yesNext(getActivity())) {

                    User userS = UserManageUtil.getLoginUser(getActivity());


                    if (userS != null) {


                    } else {
                        ShowToastUtil.showToast(getActivity(), "请先登录");
                        UIHelper.showLogin(getActivity());

                    }
                }

                break;


        }

    }







    ///////////////////////////////////////////事件/////////////////////////////////////


    /**
     * 有新消息 来了
     *
     * @param event
     */
    public void onEvent(NewMessageEvent event) {

        LogCp.i(LogCp.CP, MyFragment.class + "   收到新消息 的事件   , ");

        my_fragment_message_badgeview_lin.setVisibility(View.VISIBLE);

        if (!my_fragment_message_badgeview.getText().toString().equals("99+")) {
            int messageAll = StringUtils.toInt(my_fragment_message_badgeview.getText().toString(), 0);

            if (messageAll == 0) {
                messageAll = 1;
                my_fragment_message_badgeview.setText(messageAll + "");
            } else if (messageAll > 99) {
                my_fragment_message_badgeview.setText("99+");

            } else {
                messageAll = messageAll + 1;
                my_fragment_message_badgeview.setText(messageAll + "");
            }

        } else {
            my_fragment_message_badgeview.setText("99+");


        }


    }

    /**
     * 用户退出
     *
     * @param event
     */
    public void onEvent(ExitUserEvent event) {


        noLoginShowUi();


    }


    /**
     * 用户登录
     *
     * @param event
     */
    public void onEvent(LoginEvent event) {


        loginShowUi();


    }

    public void onEvent(UserChangeUserHeadEvent event) {
        LogCp.i(LogCp.CP, MyFragment.class + "  收到修改头像的事件  , ");

        User user = UserManageUtil.getLoginUser(getActivity());

//        my_img_head
        ImageLoader.getInstance().displayImage(user.getHeadImage(), my_img_head);

    }


}