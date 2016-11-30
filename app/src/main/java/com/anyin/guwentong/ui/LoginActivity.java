package com.anyin.guwentong.ui;

import android.app.Dialog;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.anyin.guwentong.R;
import com.anyin.guwentong.base.BaseActivity;
import com.anyin.guwentong.utils.UIHelper;

import com.anyin.guwentong.api.MyAPI;
import com.anyin.guwentong.app.AppConfig;
import com.anyin.guwentong.utils.Uitl;
import com.cp.mylibrary.api.MyResponseHandler;
import com.cp.mylibrary.custom.TitleBarView;
import com.cp.mylibrary.dialog.DialogHelper;
import com.cp.mylibrary.utils.KeyBoardUtils;
import com.cp.mylibrary.utils.LoginUitl;
import com.cp.mylibrary.utils.NetWorkUtil;
import com.umeng.analytics.MobclickAgent;

import org.kymjs.kjframe.ui.BindView;

/**
 * Created by Jerry on 2016/10/13.
 */
public class LoginActivity extends BaseActivity {


    @BindView(id = R.id.login_title)
    private TitleBarView login_title;

    @BindView(id = R.id.login_register, click = true)
    private TextView login_register;
    @BindView(id = R.id.login_forgetpass, click = true)
    private TextView login_forgetpass;

    @BindView(id = R.id.login_phone_delecte_all, click = true)
    private TextView login_phone_delecte_all;

    @BindView(id = R.id.login_password_show, click = true)
    private ImageView login_password_show;


    @BindView(id = R.id.login_input_name)
    private EditText login_input_name;


    @BindView(id = R.id.login_input_password)
    private EditText login_input_password;


    @BindView(id = R.id.loging_commit, click = true)
    private Button loging_commit;


    private boolean passWordIsShow = false;


    private Dialog waitDialog;


    @Override
    public void setRootView() {
        super.setRootView();

        setContentView(R.layout.activity_login);
    }


    @Override
    protected void initView() {
        super.initView();

        login_title.setTitleBackFinshActivity(this);
        login_title.setTitleStr("登录");
        login_title.setTitleBackImg(R.drawable.close);
//        login_title.setFenGeXianIsShow
//

        passWordIsShow = LoginUitl.showOrHidePassWord(passWordIsShow, login_input_password);


        login_input_name.setImeOptions(EditorInfo.IME_ACTION_DONE);
        login_input_password.setImeOptions(EditorInfo.IME_ACTION_DONE);


    }


    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);

        switch (v.getId()) {
            case R.id.login_register:

                closeAllInput();


                if (NetWorkUtil.yesNext(LoginActivity.this)) {

                    MobclickAgent.onEvent(LoginActivity.this, "登录页面进入注册");

                    UIHelper.showRegister(LoginActivity.this);

                }


                break;

            case R.id.login_forgetpass:
                closeAllInput();

                if (NetWorkUtil.yesNext(LoginActivity.this)) {
                    MobclickAgent.onEvent(LoginActivity.this, "注册界面进入忘记密码");


                }
                break;


            case R.id.loging_commit:
                closeAllInput();

                if (NetWorkUtil.yesNext(LoginActivity.this)) {
                    commitLogin();


                }


                break;


            case R.id.login_phone_delecte_all:
                closeAllInput();

                login_input_name.setText("");


                break;


            case R.id.login_password_show:


                closeAllInput();



                passWordIsShow = LoginUitl.showOrHidePassWord(passWordIsShow, login_input_password);


                if (passWordIsShow) {
                    login_password_show.setImageResource(R.drawable.password_hide);

                } else {
                    login_password_show.setImageResource(R.drawable.password_show);

                }


                break;


        }
    }


    /**
     *
     */
    private void commitLogin() {


        if (AppConfig.isDevelop) {
            //18744044462 博明
            // 13725312913
//
//            String strUserName = "18102762391";
//            String strUserPwd = "123456";


            String strUserName = "13560255894";
            String strUserPwd = "123456";


            waitDialog = DialogHelper.getWaitDialog(this, "登录中...");
            waitDialog.show();


        } else {

            if (LoginUitl.checkLogin(this, login_input_name, login_input_password)) {

                String strUserName = login_input_name.getText().toString();
                String strUserPwd = login_input_password.getText().toString();


                waitDialog = DialogHelper.getWaitDialog(this, "登录中...");
                waitDialog.show();




                //   }


            }
        }


    }


    /**
     * 登录的处理
     */

    private MyResponseHandler loginHandler = new MyResponseHandler() {
        @Override
        public void dataSuccess(String s) {




        }

        @Override
        public void dataFinish() {

            if (waitDialog != null) {

                waitDialog.dismiss();

            }
        }

        @Override
        public void dataFailuer(int i, String s) {

        }
    };


    /**
     * 关闭箭牌
     */

    private void closeAllInput() {


        KeyBoardUtils.closeKeybord2(login_input_name, LoginActivity.this);


        KeyBoardUtils.closeKeybord2(login_input_password, LoginActivity.this);


    }









}
