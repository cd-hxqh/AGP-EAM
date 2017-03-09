package com.hsk.hxqh.agp_eam.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.hsk.hxqh.agp_eam.R;
import com.hsk.hxqh.agp_eam.model.UDFAULTREPORT;


/**
 * 故障提报单详情
 */
public class UdfaultreportDetailsActivity extends BaseActivity {
    private static String TAG = "UdfaultreportDetailsActivity";

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
    private TextView udfaultreportnumTextView; //故障编号
    private TextView descriptionTextView; //描述
    private TextView assetnumTextView; //资产编号
    private TextView assetdesTextView; //资产描述
    private TextView locationTextView; //位置编号
    private TextView locdescTextView; //位置编号
    private TextView stationdesTextView; //站场
    private TextView statusTextView; //状态
    private TextView createbynameTextView; //创建人
    private TextView createdateTextView; //创建时间
    private CheckBox udinsideCheckBox; //站场内?
    private CheckBox udinlocationCheckBox; //需要派工？
    private CheckBox udsjgyCheckBox; //技术整改？
    private TextView faultdescTextView; //故障描述
    private TextView reasonTextView; //故障原因
    private TextView conclusionTextView; //故障总结
    private TextView materialTextView; //消耗物料

    /**
     * 故障提报单
     **/
    private UDFAULTREPORT udfaultreport;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udfaultreportnum_details);
        geiIntentData();
        findViewById();
        initView();
    }

    private void geiIntentData() {
        udfaultreport = (UDFAULTREPORT) getIntent().getSerializableExtra("udfaultreport");
    }

    @Override
    protected void findViewById() {
        backImageView = (ImageView) findViewById(R.id.menu_id);
        titleTextView = (TextView) findViewById(R.id.menu_title);

        udfaultreportnumTextView = (TextView) findViewById(R.id.udfaultreportnum_text_id);
        descriptionTextView = (TextView) findViewById(R.id.description_text_id);
        assetnumTextView = (TextView) findViewById(R.id.asset_assetnum_id);
        assetdesTextView = (TextView) findViewById(R.id.asset_desc_id);
        locationTextView = (TextView) findViewById(R.id.asset_location_id);
        locdescTextView = (TextView) findViewById(R.id.asset_locdesc_id);
        stationdesTextView = (TextView) findViewById(R.id.stationdes_text_id);
        statusTextView = (TextView) findViewById(R.id.status_text_id);
        createbynameTextView = (TextView) findViewById(R.id.createbyname_text_id);
        createdateTextView = (TextView) findViewById(R.id.createdate_text_id);
        udinsideCheckBox = (CheckBox) findViewById(R.id.udinside＿text＿id);
        udinlocationCheckBox = (CheckBox) findViewById(R.id.udinlocation_text_id);
        udsjgyCheckBox = (CheckBox) findViewById(R.id.udsjgy_text_id);
        faultdescTextView = (TextView) findViewById(R.id.faultdesc_text_id);
        reasonTextView = (TextView) findViewById(R.id.reason_text_id);
        conclusionTextView = (TextView) findViewById(R.id.conclusion_text_id);
        materialTextView = (TextView) findViewById(R.id.material_text_id);
    }


    @Override
    protected void initView() {
        backImageView.setBackgroundResource(R.drawable.ic_back);
        backImageView.setOnClickListener(backImageViewOnClickListener);
        titleTextView.setText(R.string.udfaultreport_text);

        if (udfaultreport != null) {
            udfaultreportnumTextView.setText(udfaultreport.getUDFAULTREPORTNUM());
            descriptionTextView.setText(udfaultreport.getDESCRIPTION());
            assetnumTextView.setText(udfaultreport.getASSETNUM());
            assetdesTextView.setText(udfaultreport.getASSETDES());
            locationTextView.setText(udfaultreport.getLOCATION());
            locdescTextView.setText(udfaultreport.getLOCATIONDES());
            stationdesTextView.setText(udfaultreport.getSTATIONDES());
            statusTextView.setText(udfaultreport.getSTATUS());
            createbynameTextView.setText(udfaultreport.getCREATEBYNAME());
            createdateTextView.setText(udfaultreport.getCREATEDATE());
            if (udfaultreport.getUDINSIDE().equals("Y")) {
                udinsideCheckBox.setChecked(true);
            } else {
                udinsideCheckBox.setChecked(false);
            }
            if (udfaultreport.getUDINLOCATION().equals("Y")) {
                udinlocationCheckBox.setChecked(true);
            } else {
                udinlocationCheckBox.setChecked(false);
            }
            if (udfaultreport.getUDSJGY().equals("Y")) {
                udsjgyCheckBox.setChecked(true);
            } else {
                udsjgyCheckBox.setChecked(false);
            }
            faultdescTextView.setText(udfaultreport.getFAULTDESC());
            reasonTextView.setText(udfaultreport.getREASON());
            conclusionTextView.setText(udfaultreport.getCONCLUSION());
            materialTextView.setText(udfaultreport.getMATERIAL());
        }


    }


    private View.OnClickListener backImageViewOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };


}
