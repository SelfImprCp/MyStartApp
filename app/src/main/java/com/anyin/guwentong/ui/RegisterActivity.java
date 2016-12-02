package com.anyin.guwentong.ui;

import android.app.Dialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.anyin.guwentong.R;
import com.anyin.guwentong.base.BaseActivity;
import com.anyin.guwentong.bean.responbean.RegisterBean;

import com.cp.mylibrary.api.MyResponseHandler;
import com.cp.mylibrary.custom.TimerTextView;
import com.cp.mylibrary.custom.TitleBarView;
import com.cp.mylibrary.dialog.DialogHelper;
import com.cp.mylibrary.utils.KeyBoardUtils;
import com.cp.mylibrary.utils.LogCp;
import com.cp.mylibrary.utils.LoginUitl;
import com.cp.mylibrary.utils.NetWorkUtil;
import com.cp.mylibrary.utils.ShowToastUtil;
import com.cp.mylibrary.utils.StringUtils;
import com.zhy.autolayout.AutoLinearLayout;

import org.kymjs.kjframe.ui.BindView;

/**
 * Created by Jerry on 2016/10/13.
 */
public class RegisterActivity extends BaseActivity {


    @BindView(id = R.id.register_title)
    private TitleBarView register_title;


    @BindView(id = R.id.register_input_name)
    private EditText register_input_name;


    @BindView(id = R.id.register_input_yanzhenma)
    private EditText register_input_yanzhenma;


    @BindView(id = R.id.register_input_password)
    private EditText register_input_password;

    @BindView(id = R.id.register_yaoqinma_edit)
    private EditText register_yaoqinma_edit;


    @BindView(id = R.id.register_input_yanzhenma_text, click = true)
    private TextView register_input_yanzhenma_text;


//    @BindView(id = R.id.register_input_yanzhenma_lin, click = true)
//    private AutoRelativeLayout register_input_yanzhenma_lin;


    @BindView(id = R.id.reginster_get_yanzhengma)
    private TimerTextView reginster_get_yanzhengma;


    // 删除
    @BindView(id = R.id.register_delecte_phone_all, click = true)
    private TextView register_delecte_phone_all;

    @BindView(id = R.id.login_password_show, click = true)
    private TextView login_password_show;

    @BindView(id = R.id.register_password_show, click = true)
    private ImageView register_password_show;

    @BindView(id = R.id.register_commit_button, click = true)
    private Button register_commit_button;


    @BindView(id = R.id.register_yaoqinma_tongyixieyi_img, click = true)
    private ImageView register_yaoqinma_tongyixieyi_img;


    @BindView(id = R.id.register_yaoqinma_tongyixieyi_text, click = true)
    private TextView register_yaoqinma_tongyixieyi_text;

    @BindView(id = R.id.register_all_lin, click = true)
    private AutoLinearLayout register_all_lin;


    private boolean passWordIsShow = false;
    private boolean tongYiXieYi = true;


    private Dialog waitDialog;


    @Override
    public void setRootView() {
        super.setRootView();
        setContentView(R.layout.activity_register);

    }

    @Override
    protected void initView() {
        super.initView();


        register_title.setTitleBackFinshActivity(this);
        register_title.setTitleStr("注册");
        register_title.setTitleBackImg(R.drawable.close);

        passWordIsShow = LoginUitl.showOrHidePassWord(passWordIsShow, register_input_password);


        register_input_name.setImeOptions(EditorInfo.IME_ACTION_DONE);


        register_input_yanzhenma.setImeOptions(EditorInfo.IME_ACTION_DONE);


        register_input_password.setImeOptions(EditorInfo.IME_ACTION_DONE);


        register_yaoqinma_edit.setImeOptions(EditorInfo.IME_ACTION_DONE);


        // 手机号的删除

        register_input_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    register_delecte_phone_all.setVisibility(View.VISIBLE);

                } else {
                    register_delecte_phone_all.setVisibility(View.GONE);

                }
            }
        });


    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);

        switch (v.getId()) {


            case R.id.register_all_lin:


                closeAllInput();

//


                break;


            case R.id.register_input_yanzhenma_text:


                // 关闭箭牌

                closeAllInput();
                if (NetWorkUtil.yesNext(RegisterActivity.this)) {

                    getYanZhenMa();

                }

                break;


            //  删除手机号的按钮

            case R.id.register_delecte_phone_all:
                closeAllInput();

                register_input_name.setText("");

                break;

            // 显示隐藏密码
            case R.id.register_password_show:
                closeAllInput();

                passWordIsShow = LoginUitl.showOrHidePassWord(passWordIsShow, register_input_password);


                if (passWordIsShow) {
                    register_password_show.setImageResource(R.drawable.password_hide);

                } else {

                    register_password_show.setImageResource(R.drawable.password_show);

                }


                break;


            // 查看协议
            case R.id.register_yaoqinma_tongyixieyi_text:
                closeAllInput();


                break;

            // 同意协议
            case R.id.register_yaoqinma_tongyixieyi_img:
                closeAllInput();

                if (tongYiXieYi) {

                    tongYiXieYi = false;
                    register_yaoqinma_tongyixieyi_img.setImageResource(R.drawable.register_nogou);

                } else {

                    tongYiXieYi = true;

                    register_yaoqinma_tongyixieyi_img.setImageResource(R.drawable.register_gou);

                }

                break;
            // 提交注册
            case R.id.register_commit_button:
                closeAllInput();

                if (NetWorkUtil.yesNext(RegisterActivity.this)) {
                    commitServer();
                }


                break;


        }
    }


    /**
     * 注册
     */
    private void commitServer() {
        //先检查手机号和密码
        boolean isLogin = LoginUitl.checkLogin(this, register_input_name, register_input_password);
        String strYanZhenMa = register_input_yanzhenma.getText().toString();


        if (!tongYiXieYi) {
            ShowToastUtil.showToast(this, "请先同意小树投服务协议");
            return;

        }

//
//        if (null == yanZhenMaRes) {
//            ShowToastUtil.showToast(this, "请获取验证码");
//            return;
//        }

        if (StringUtils.isEmpty(strYanZhenMa)) {
            ShowToastUtil.showToast(this, "验证码不能为空");
            return;

        }


        if (strYanZhenMa.length() != 6) {
            ShowToastUtil.showToast(this, "验证码为6位数字");
            return;

        }


//        if (strYanZhenMa.length() == 6 && !yanZhenMaRes.getResultData().getCode().equals(strYanZhenMa)) {
//            ShowToastUtil.showToast(this, "验证码输入错误");
//            return;
//
//        }


        // 可以去注册 了
        waitDialog = DialogHelper.getWaitDialog(this, "提交中");
        waitDialog.show();


    }


    private void getYanZhenMa() {

        LogCp.i(LogCp.CP, RegisterActivity.class + "   手机 号 " + register_input_name.getText().toString() + "," + LoginUitl.checkLoginName(RegisterActivity.this, register_input_name));

        if (!LoginUitl.checkLoginName(RegisterActivity.this, register_input_name)) {
            return;
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


        KeyBoardUtils.closeKeybord2(register_input_name, RegisterActivity.this);


        KeyBoardUtils.closeKeybord2(register_input_yanzhenma, RegisterActivity.this);
        KeyBoardUtils.closeKeybord2(register_input_password, RegisterActivity.this);
        KeyBoardUtils.closeKeybord2(register_yaoqinma_edit, RegisterActivity.this);

    }


}
