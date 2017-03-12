package com.hsk.hxqh.agp_eam.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hsk.hxqh.agp_eam.R;
import com.hsk.hxqh.agp_eam.model.LABTRANS;
import com.hsk.hxqh.agp_eam.model.WOACTIVITY;


/**
 * 工单实际员工详情
 */
public class LabtransDetailsActivity extends BaseActivity {
    private static String TAG = "LabtransDetailsActivity";

    /**
     * 返回按钮
     */
    private ImageView backImageView;
    /**
     * 标题
     */
    private TextView titleTextView;

    /**
     * 字段显示
     **/
    private TextView actualstaskid; //任务
    private TextView laborcode; //员工
    private TextView startdate; //开始日期
    private TextView starttime; //开始时间
    private TextView finishdate; //结束日期
    private TextView finishtime;//结束时间
    private TextView regularhrs;//常规时数

    /**
     * 任务
     **/
    private LABTRANS labtrans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labtrans_details);
        geiIntentData();
        findViewById();
        initView();
    }

    private void geiIntentData() {
        labtrans = (LABTRANS) getIntent().getSerializableExtra("labtrans");
    }

    @Override
    protected void findViewById() {
        backImageView = (ImageView) findViewById(R.id.menu_id);
        titleTextView = (TextView) findViewById(R.id.menu_title);

        actualstaskid = (TextView) findViewById(R.id.labtrans_actualstaskid);
        laborcode = (TextView) findViewById(R.id.labtrans_laborcode);
        startdate = (TextView) findViewById(R.id.labtrans_startdate);
        starttime = (TextView) findViewById(R.id.labtrans_starttime);
        finishdate = (TextView) findViewById(R.id.labtrans_finishdate);
        finishtime = (TextView) findViewById(R.id.labtrans_finishtime);
        regularhrs = (TextView) findViewById(R.id.labtrans_regularhrs);
    }


    @Override
    protected void initView() {
        backImageView.setBackgroundResource(R.drawable.ic_back);
        backImageView.setOnClickListener(backImageViewOnClickListener);
        titleTextView.setText(R.string.work_labtrans);

        if (labtrans != null) {
            actualstaskid.setText(labtrans.ACTUALSTASKID);
            laborcode.setText(labtrans.LABORCODE);
            startdate.setText(labtrans.STARTDATE);
            starttime.setText(labtrans.STARTTIME);
            finishdate.setText(labtrans.FINISHDATE);
            finishtime.setText(labtrans.FINISHTIME);
            regularhrs.setText(labtrans.REGULARHRS);

        }


    }


    private View.OnClickListener backImageViewOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };


}
