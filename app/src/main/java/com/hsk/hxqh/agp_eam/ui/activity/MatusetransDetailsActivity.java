package com.hsk.hxqh.agp_eam.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hsk.hxqh.agp_eam.R;
import com.hsk.hxqh.agp_eam.model.MATUSETRANS;
import com.hsk.hxqh.agp_eam.model.WPMATERIAL;


/**
 * 工单实际物料详情
 */
public class MatusetransDetailsActivity extends BaseActivity {
    private static String TAG = "MatusetransDetailsActivity";

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
    private TextView itemnum; //项目
    private TextView description; //描述
    private TextView storeloc; //库房
    private TextView positivequantity; //数量
    private TextView binnum;//货柜
    private TextView lotnum;//批次
    private TextView rotassetnum;//周转资产
    private TextView issuetype;//交易类型
    private TextView enterby;//输入人
    private TextView actualdate;//实际日期

    /**
     * 物料
     **/
    private MATUSETRANS matusetrans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matusetrans_details);
        geiIntentData();
        findViewById();
        initView();
    }

    private void geiIntentData() {
        matusetrans = (MATUSETRANS) getIntent().getSerializableExtra("matusetrans");
    }

    @Override
    protected void findViewById() {
        backImageView = (ImageView) findViewById(R.id.menu_id);
        titleTextView = (TextView) findViewById(R.id.menu_title);

        actualstaskid = (TextView) findViewById(R.id.matusetrans_actualstaskid);
        itemnum = (TextView) findViewById(R.id.matusetrans_itemnum);
        description = (TextView) findViewById(R.id.matusetrans_description);
        storeloc = (TextView) findViewById(R.id.matusetrans_storeloc);
        positivequantity = (TextView) findViewById(R.id.matusetrans_positivequantity);
        binnum = (TextView) findViewById(R.id.matusetrans_binnum);
        lotnum = (TextView) findViewById(R.id.matusetrans_lotnum);
        rotassetnum = (TextView) findViewById(R.id.matusetrans_rotassetnum);
        issuetype = (TextView) findViewById(R.id.matusetrans_issuetype);
        enterby = (TextView) findViewById(R.id.matusetrans_enterby);
        actualdate = (TextView) findViewById(R.id.matusetrans_actualdate);
    }


    @Override
    protected void initView() {
        backImageView.setBackgroundResource(R.drawable.ic_back);
        backImageView.setOnClickListener(backImageViewOnClickListener);
        titleTextView.setText(R.string.work_matusetrans);

        if (matusetrans != null) {
            actualstaskid.setText(matusetrans.ACTUALSTASKID);
            itemnum.setText(matusetrans.ITEMNUM);
            description.setText(matusetrans.DESCRIPTION);
            storeloc.setText(matusetrans.STORELOC);
            positivequantity.setText(matusetrans.POSITIVEQUANTITY);
            binnum.setText(matusetrans.BINNUM);
            lotnum.setText(matusetrans.LOTNUM);
            rotassetnum.setText(matusetrans.ROTASSETNUM);
            issuetype.setText(matusetrans.ISSUETYPE);
            enterby.setText(matusetrans.ENTERBY);
            actualdate.setText(matusetrans.ACTUALDATE);

        }


    }


    private View.OnClickListener backImageViewOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };


}
