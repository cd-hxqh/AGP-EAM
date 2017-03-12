package com.hsk.hxqh.agp_eam.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hsk.hxqh.agp_eam.R;
import com.hsk.hxqh.agp_eam.model.WOACTIVITY;
import com.hsk.hxqh.agp_eam.model.WPLABOR;


/**
 * 工单计划员工详情
 */
public class WplaborDetailsActivity extends BaseActivity {
    private static String TAG = "WplaborDetailsActivity";

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
    private TextView taskid; //任务
    private TextView laborcode; //创员工
    private EditText quantity; //数量

    /**
     * 任务
     **/
    private WPLABOR wplabor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wplabor_details);
        geiIntentData();
        findViewById();
        initView();
    }

    private void geiIntentData() {
        wplabor = (WPLABOR) getIntent().getSerializableExtra("wplabor");
    }

    @Override
    protected void findViewById() {
        backImageView = (ImageView) findViewById(R.id.menu_id);
        titleTextView = (TextView) findViewById(R.id.menu_title);

        taskid = (TextView) findViewById(R.id.wplabor_taskid);
        laborcode = (TextView) findViewById(R.id.wplabor_laborcode);
        quantity = (EditText) findViewById(R.id.wplabor_quantity);
    }


    @Override
    protected void initView() {
        backImageView.setBackgroundResource(R.drawable.ic_back);
        backImageView.setOnClickListener(backImageViewOnClickListener);
        titleTextView.setText(R.string.work_wplabor);

        if (wplabor != null) {
            taskid.setText(wplabor.TASKID);
            laborcode.setText(wplabor.LABORCODE);
            quantity.setText(wplabor.QUANTITY);

        }


    }


    private View.OnClickListener backImageViewOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };


}
