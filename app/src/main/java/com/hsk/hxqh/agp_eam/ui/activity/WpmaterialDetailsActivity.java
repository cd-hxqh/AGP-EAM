package com.hsk.hxqh.agp_eam.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hsk.hxqh.agp_eam.R;
import com.hsk.hxqh.agp_eam.model.WOACTIVITY;
import com.hsk.hxqh.agp_eam.model.WPMATERIAL;


/**
 * 工单计划物料详情
 */
public class WpmaterialDetailsActivity extends BaseActivity {
    private static String TAG = "WpmaterialDetailsActivity";

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
    private TextView itemnum; //项目
    private TextView description; //描述
    private TextView itemqty; //数量
    private TextView location; //库房
    private TextView vendor;//供应商
    private TextView requestby;//请求者
    private TextView requiredate;//要求的日期

    /**
     * 任务
     **/
    private WPMATERIAL wpmaterial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wpmaterial_details);
        geiIntentData();
        findViewById();
        initView();
    }

    private void geiIntentData() {
        wpmaterial = (WPMATERIAL) getIntent().getSerializableExtra("wpmaterial");
    }

    @Override
    protected void findViewById() {
        backImageView = (ImageView) findViewById(R.id.menu_id);
        titleTextView = (TextView) findViewById(R.id.menu_title);

        taskid = (TextView) findViewById(R.id.wpmaterial_taskid);
        itemnum = (TextView) findViewById(R.id.wpmaterial_itemnum);
        description = (TextView) findViewById(R.id.wpmaterial_description);
        itemqty = (TextView) findViewById(R.id.wpmaterial_itemqty);
        location = (TextView) findViewById(R.id.wpmaterial_location);
        vendor = (TextView) findViewById(R.id.wpmaterial_vendor);
        requestby = (TextView) findViewById(R.id.wpmaterial_requestby);
        requiredate = (TextView) findViewById(R.id.wpmaterial_requiredate);
    }


    @Override
    protected void initView() {
        backImageView.setBackgroundResource(R.drawable.ic_back);
        backImageView.setOnClickListener(backImageViewOnClickListener);
        titleTextView.setText(R.string.work_wpmaterial);

        if (wpmaterial != null) {
            taskid.setText(wpmaterial.TASKID);
            itemnum.setText(wpmaterial.ITEMNUM);
            description.setText(wpmaterial.DESCRIPTION);
            itemqty.setText(wpmaterial.ITEMQTY);
            location.setText(wpmaterial.LOCATION);
            vendor.setText(wpmaterial.VENDOR);
            requestby.setText(wpmaterial.REQUESTBY);
            requiredate.setText(wpmaterial.REQUIREDATE);

        }


    }


    private View.OnClickListener backImageViewOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };


}
