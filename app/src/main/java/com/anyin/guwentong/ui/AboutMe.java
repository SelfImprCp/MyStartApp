package com.anyin.guwentong.ui;



import com.anyin.guwentong.R;
import com.anyin.guwentong.base.BaseActivity;
import com.cp.mylibrary.custom.TitleBarView;

import org.kymjs.kjframe.ui.BindView;

/**
 * 关于我们，
 *
 * @author Administrator
 */

public class AboutMe extends BaseActivity {


//    @BindView(id = R.id.about_text_version)
//    private TextView about_text_version;
//
    @BindView(id = R.id.activity_about_titlebar)
    private TitleBarView activity_about_titlebar;
//
//
//
    @Override
    public void setRootView() {
        super.setRootView();

        setContentView(R.layout.activity_about);
    }

    @Override
    protected void initView() {
        super.initView();
        //设置标题
        activity_about_titlebar.setTitleStr("关于我们");

//		//返回
        activity_about_titlebar.setTitleBackFinshActivity(this);





    }




}
