package com.hsk.hxqh.agp_eam.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hsk.hxqh.agp_eam.R;
import com.hsk.hxqh.agp_eam.model.UDWORKAPPLY;


/**
 * 工作申请详情
 */
public class UdworkapplyDetailsActivity extends BaseActivity {
    private static String TAG = "UdworkapplyDetailsActivity";

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
    private TextView woapplynumTextView; //工作申请编号
    private TextView descriptionTextView; //工作申请描述
    private TextView createbynameTextView; //创建人
    private TextView assetnumTextView; //资产编号
    private TextView assetdesTextView; //资产描述
    private TextView locationTextView; //位置编号
    private TextView locdescTextView; //位置编号
    private TextView statusTextView; //状态
    private TextView stationdesTextView; //站场
    private TextView purposeTextView; //目的
    private TextView workexeTextView; //工作执行人数
    private TextView preparedbynameTextView; //准备人姓名
    private TextView preparedbytitleTextView; //职位
    private TextView createdateTextView; //开始时间
    private TextView workdatesTextView; //工期
    private TextView plannumTextView; //年度计划编号
    private TextView jpnumTextView; //作业计划编号

    /**
     * 故障提报单
     **/
    private UDWORKAPPLY udworkapply;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udworkapply_details);
        geiIntentData();
        findViewById();
        initView();
    }

    private void geiIntentData() {
        udworkapply = (UDWORKAPPLY) getIntent().getSerializableExtra("udworkapply");
    }

    @Override
    protected void findViewById() {
        backImageView = (ImageView) findViewById(R.id.menu_id);
        titleTextView = (TextView) findViewById(R.id.menu_title);

        woapplynumTextView = (TextView) findViewById(R.id.woapplynum_text_id);
        descriptionTextView = (TextView) findViewById(R.id.description_text_id);
        createbynameTextView = (TextView) findViewById(R.id.createbyname_text_id);
        assetnumTextView = (TextView) findViewById(R.id.asset_assetnum_id);
        assetdesTextView = (TextView) findViewById(R.id.asset_desc_id);
        locationTextView = (TextView) findViewById(R.id.asset_location_id);
        locdescTextView = (TextView) findViewById(R.id.asset_locdesc_id);
        statusTextView = (TextView) findViewById(R.id.status_text_id);
        stationdesTextView = (TextView) findViewById(R.id.stationdes_text_id);
        purposeTextView = (TextView) findViewById(R.id.purpose_text_id);
        workexeTextView = (TextView) findViewById(R.id.workexe_text_id);
        preparedbynameTextView = (TextView) findViewById(R.id.preparedbyname_text_id);
        preparedbytitleTextView = (TextView) findViewById(R.id.preparedbytitle_text_id);
        createdateTextView = (TextView) findViewById(R.id.startdate_text_id);
        workdatesTextView = (TextView) findViewById(R.id.workdates_text_id);
        plannumTextView = (TextView) findViewById(R.id.plannum_text_id);
        jpnumTextView = (TextView) findViewById(R.id.jpnum_text_id);
    }


    @Override
    protected void initView() {
        backImageView.setBackgroundResource(R.drawable.ic_back);
        backImageView.setOnClickListener(backImageViewOnClickListener);
        titleTextView.setText(R.string.udworkapply_text);

        if (udworkapply != null) {
            woapplynumTextView.setText(udworkapply.getWOAPPLYNUM());
            descriptionTextView.setText(udworkapply.getDESCRIPTION());
            createbynameTextView.setText(udworkapply.getCREATEBYNAME());
            assetnumTextView.setText(udworkapply.getASSETNUM());
            assetdesTextView.setText(udworkapply.getASSETDES());
            locationTextView.setText(udworkapply.getLOCATION());
            locdescTextView.setText(udworkapply.getLOCATIONDES());
            statusTextView.setText(udworkapply.getSTATUS());
            stationdesTextView.setText(udworkapply.getSTATIONDES());
            purposeTextView.setText(udworkapply.getPURPOSE());
            workexeTextView.setText(udworkapply.getWORKEXE());
            preparedbynameTextView.setText(udworkapply.getPREPAREDBYNAME());
            preparedbytitleTextView.setText(udworkapply.getPREPAREDBYTITLE());
            createdateTextView.setText(udworkapply.getCREATEDATE());
            workdatesTextView.setText(udworkapply.getWORKDATES());
            plannumTextView.setText(udworkapply.getPLANNUM());
            jpnumTextView.setText(udworkapply.getJPNUM());

        }


    }


    private View.OnClickListener backImageViewOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };


}
