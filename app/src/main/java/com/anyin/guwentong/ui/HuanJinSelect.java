package com.anyin.guwentong.ui;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.anyin.guwentong.R;
import com.anyin.guwentong.base.BaseActivity;
import com.anyin.guwentong.utils.UIHelper;

import com.anyin.guwentong.utils.Uitl;
import com.zhy.autolayout.AutoLinearLayout;

import org.kymjs.kjframe.ui.BindView;

/**
 * Created by Jerry on 2016/12/9.
 * <p>
 * 这只是一个在开发阶段环境选择的界面，在正式发包后，不会现
 */

public class HuanJinSelect extends BaseActivity {


    @BindView(id = R.id.login_ceshi_img)
    private ImageView login_ceshi_img;

    @BindView(id = R.id.login_ceshi_text)
    private TextView login_ceshi_text;

    @BindView(id = R.id.login_ceshi_lin, click = true)
    private AutoLinearLayout login_ceshi_lin;


    @BindView(id = R.id.huanjin_shenchan_img)
    private ImageView huanjin_shenchan_img;

    @BindView(id = R.id.login_shenchan_text)
    private TextView login_shenchan_text;

    @BindView(id = R.id.login_shenchan_lin, click = true)
    private AutoLinearLayout login_shenchan_lin;


    @BindView(id = R.id.huanjin_kaifa_img)
    private ImageView huanjin_kaifa_img;

    @BindView(id = R.id.huanjin_kaifa_text)
    private TextView huanjin_kaifa_text;

    @BindView(id = R.id.login_kaifa_lin, click = true)
    private AutoLinearLayout login_kaifa_lin;

    @BindView(id = R.id.huanjin_button_commit, click = true)
    private Button huanjin_button_commit;



    private String CE_SHI = "47.90.23.136:9999";
    private String KAI_FA = "47.90.23.136:9999";
    private String SHEN_CHAN = "api.guwenyi.com";

    @Override
    public void setRootView() {
        super.setRootView();

        setContentView(R.layout.activity_huanjin_select);


    }


    @Override
    protected void initView() {
        super.initView();

        // 默认进入测试环境
        Uitl.getInstance().setHOST(CE_SHI);


        login_ceshi_text.setText("测试环境： " + CE_SHI);
        huanjin_kaifa_text.setText("开发环境： " + KAI_FA);

        login_shenchan_text.setText("生产环境： " + SHEN_CHAN);


    }

    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);

        switch (v.getId()) {
            case R.id.login_ceshi_lin:

                Uitl.getInstance().setHOST(CE_SHI);
                login_ceshi_img.setImageResource(R.drawable.kaihu_tongyi);
                huanjin_kaifa_img.setImageResource(R.drawable.kaihu_notongyi);
                huanjin_shenchan_img.setImageResource(R.drawable.kaihu_notongyi);

                break;

            case R.id.login_shenchan_lin:

                Uitl.getInstance().setHOST(SHEN_CHAN);


                login_ceshi_img.setImageResource(R.drawable.kaihu_notongyi);
                huanjin_kaifa_img.setImageResource(R.drawable.kaihu_notongyi);
                huanjin_shenchan_img.setImageResource(R.drawable.kaihu_tongyi);

                break;
            case R.id.login_kaifa_lin:


                Uitl.getInstance().setHOST(KAI_FA);


                login_ceshi_img.setImageResource(R.drawable.kaihu_notongyi);
                huanjin_kaifa_img.setImageResource(R.drawable.kaihu_tongyi);
                huanjin_shenchan_img.setImageResource(R.drawable.kaihu_notongyi);


                break;

            case R.id.huanjin_button_commit:


                UIHelper.showMainActivity(HuanJinSelect.this);


                break;


        }
    }


}
