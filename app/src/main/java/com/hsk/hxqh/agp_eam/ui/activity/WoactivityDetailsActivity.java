package com.hsk.hxqh.agp_eam.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hsk.hxqh.agp_eam.R;
import com.hsk.hxqh.agp_eam.model.UDWORKAPPLY;
import com.hsk.hxqh.agp_eam.model.WOACTIVITY;
import com.hsk.hxqh.agp_eam.model.WORKORDER;


/**
 * 工单任务详情
 */
public class WoactivityDetailsActivity extends BaseActivity {
    private static String TAG = "WoactivityDetailsActivity";

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
    private TextView wosequence; //
    private TextView taskid; //
    private TextView description; //
    private TextView estdur; //
    private TextView status; //

    /**
     * 任务
     **/
    private WOACTIVITY woactivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woactivity_details);
        geiIntentData();
        findViewById();
        initView();
    }

    private void geiIntentData() {
        woactivity = (WOACTIVITY) getIntent().getSerializableExtra("woactivity");
    }

    @Override
    protected void findViewById() {
        backImageView = (ImageView) findViewById(R.id.menu_id);
        titleTextView = (TextView) findViewById(R.id.menu_title);

        wosequence = (TextView) findViewById(R.id.woactivity_wosequence);
        taskid = (TextView) findViewById(R.id.woactivity_taskid);
        description = (TextView) findViewById(R.id.woactivity_description);
        estdur = (TextView) findViewById(R.id.woactivity_estdur);
        status = (TextView) findViewById(R.id.woactivity_status);
    }


    @Override
    protected void initView() {
        backImageView.setBackgroundResource(R.drawable.ic_back);
        backImageView.setOnClickListener(backImageViewOnClickListener);
        titleTextView.setText(R.string.woactivity_taskid);

        if (woactivity != null) {
            wosequence.setText(woactivity.WOSEQUENCE);
            taskid.setText(woactivity.TASKID);
            description.setText(woactivity.DESCRIPTION);
            estdur.setText(woactivity.ESTDUR);
            status.setText(woactivity.STATUS);

        }


    }


    private View.OnClickListener backImageViewOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };


}
