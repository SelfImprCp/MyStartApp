package com.anyin.guwentong.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import com.anyin.guwentong.R;
import com.anyin.guwentong.base.BaseActivity;
import com.cp.mylibrary.custom.TitleBarView;
import com.cp.mylibrary.utils.NetWorkUtil;

import org.kymjs.kjframe.ui.BindView;

/**
 * Created by Jerry on 2016/6/20.
 * <p/>
 * 意见反馈
 */
public class FeedBackActivity extends BaseActivity {

    @BindView(id = R.id.feedback_title)
    TitleBarView feedback_title;

    @BindView(id = R.id.feedback_exit_content)
    EditText feedback_exit_content;


    @BindView(id = R.id.feedback_recyclerview)
    RecyclerView feedback_recyclerview;


    @BindView(id = R.id.feedback_commit_but, click = true)
    Button feedback_commit_but;



    @Override
    public void setRootView() {
        super.setRootView();

        setContentView(R.layout.activity_feedback);
    }

    @Override
    protected void initView() {
        super.initView();
        feedback_title.setTitleBackFinshActivity(this);
        feedback_title.setTitleStr("意见反馈");


    feedback_exit_content.setImeOptions(EditorInfo.IME_ACTION_DONE);




    }



    @Override
    public void widgetClick(View v) {
        super.widgetClick(v);

        switch (v.getId()) {

            case R.id.feedback_commit_but:


                if (NetWorkUtil.yesNext(FeedBackActivity.this)) {


                    commitFeedBack();

                }
                break;
        }
    }

    /**
     *
     */
    private void commitFeedBack() {


    }


}
