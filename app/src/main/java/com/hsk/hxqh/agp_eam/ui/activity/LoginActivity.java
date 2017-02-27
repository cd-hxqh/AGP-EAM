package com.hsk.hxqh.agp_eam.ui.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.hsk.hxqh.agp_eam.R;
import com.hsk.hxqh.agp_eam.api.HttpManager;
import com.hsk.hxqh.agp_eam.api.HttpRequestHandler;
import com.hsk.hxqh.agp_eam.dialog.FlippingLoadingDialog;
import com.hsk.hxqh.agp_eam.unit.AccountUtils;
import com.hsk.hxqh.agp_eam.unit.MessageUtils;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * 登录界面
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {


    private static final String TAG = "LoginActivity";
    private EditText mUsername;
    private EditText mPassword;
    private Button mLogin;
    private CheckBox checkBox; //记住密码
    private TextView versionName;//版本号

    private boolean isRemember; //是否记住密码


    String userName; //用户名

    String userPassWorld; //密码

    String imei; //imei

    protected FlippingLoadingDialog mLoadingDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        imei = ((TelephonyManager) getSystemService(TELEPHONY_SERVICE))
                .getDeviceId();

        findViewById();
        initView();
    }

    @Override
    protected void findViewById() {
        mUsername = (EditText) findViewById(R.id.user_login_id);
        mPassword = (EditText) findViewById(R.id.user_login_password);
        checkBox = (CheckBox) findViewById(R.id.isremenber_password);
        mLogin = (Button) findViewById(R.id.user_login);
        versionName = (TextView) findViewById(R.id.versionName);
    }

    @Override
    protected void initView() {

        boolean isChecked = AccountUtils.getIsChecked(LoginActivity.this);
        if (isChecked) {
            mUsername.setText(AccountUtils.getUserName(LoginActivity.this));
            mPassword.setText(AccountUtils.getUserPassword(LoginActivity.this));
        }
        checkBox.setOnCheckedChangeListener(cheBoxOnCheckedChangListener);
        mLogin.setOnClickListener(this);

        versionName.setText(getVersion());

        if (!mUsername.getText().toString().equals("") && !mPassword.getText().toString().equals("")) {
            mLogin.performClick();
        }
    }

    private CompoundButton.OnCheckedChangeListener cheBoxOnCheckedChangListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            isRemember = isChecked;
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_login:
                if (mUsername.getText().length() == 0) {
                    mUsername.setError(getString(R.string.login_error_empty_user));
                    mUsername.requestFocus();
                } else if (mPassword.getText().length() == 0) {
                    mPassword.setError(getString(R.string.login_error_empty_passwd));
                    mPassword.requestFocus();
                } else {
                    login();
                }
                break;

//            case R.id.ip_address_id:
//                mMenuItems = new ArrayList<>();
//                addIpData();
//                NormalListDialog();
//                break;

        }
    }


    /**
     * 登陆*
     */
    private void login() {

        getLoadingDialog(getString(R.string.login_loging)).show();

        HttpManager.loginWithUsername(LoginActivity.this,
                mUsername.getText().toString(),
                mPassword.getText().toString(), imei,
                new HttpRequestHandler<String>() {
                    @Override
                    public void onSuccess(String data) {

                        MessageUtils.showMiddleToast(LoginActivity.this, "登录成功");
                        mLoadingDialog.dismiss();
//                        AccountUtils.setIpAddress(LoginActivity.this,adress);
                        if (isRemember) {
                            AccountUtils.setChecked(LoginActivity.this, true);
                            //记住密码
                            AccountUtils.setUserNameAndPassWord(LoginActivity.this, mUsername.getText().toString(), mPassword.getText().toString());
                        }
                        try {//保存登录返回信息
                            JSONObject object = new JSONObject(data);
                            JSONObject LoginDetails = object.getJSONObject("userLoginDetails");
                            AccountUtils.setLoginDetails(LoginActivity.this, LoginDetails.getString("insertOrg"), LoginDetails.getString("insertSite"),
                                    LoginDetails.getString("personId"), object.getString("userName"), LoginDetails.getString("displayName"));
//                            findByDepartment(LoginDetails.getString("personId"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        AccountUtils.setIsOffLine(LoginActivity.this, false);
                        startIntent();

                    }

                    @Override
                    public void onSuccess(String data, int totalPages, int currentPage) {
                        MessageUtils.showMiddleToast(LoginActivity.this, getString(R.string.login_successful_hint));
                        AccountUtils.setIsOffLine(LoginActivity.this, false);
                        startIntent();
                    }

                    @Override
                    public void onFailure(String error) {
                        MessageUtils.showErrorMessage(LoginActivity.this, error);
                        mLoadingDialog.dismiss();
                    }
                });
    }


    private void startIntent() {
        Intent inetnt = new Intent();
        inetnt.setClass(this, MainActivity.class);
        startActivityForResult(inetnt, 0);
    }
//
//    /**
//     * 离线登录*
//     */
//    private void LoginOffline() {
//        final NormalDialog dialog = new NormalDialog(LoginActivity.this);
//        dialog.content("确定离线登录吗?")//
//                .showAnim(mBasIn)//
//                .dismissAnim(mBasOut)//
//                .show();
//        dialog.setOnBtnClickL(
//                new OnBtnClickL() {
//                    @Override
//                    public void onBtnClick() {
//                        dialog.dismiss();
//                    }
//                },
//                new OnBtnClickL() {
//                    @Override
//                    public void onBtnClick() {
//                        AccountUtils.setIsOffLine(LoginActivity.this, true);
//                        startIntent();
//                        Toast.makeText(LoginActivity.this, "离线登录成功", Toast.LENGTH_SHORT).show();
//                        dialog.dismiss();
//                    }
//                });
//    }

//    private long exitTime = 0;
//
//    @Override
//    public void onBackPressed() {
//        if ((System.currentTimeMillis() - exitTime) > 2000) {
//            Toast.makeText(this, getString(R.string.exit_text), Toast.LENGTH_SHORT).show();
//            exitTime = System.currentTimeMillis();
//        } else {
//            AppManager.AppExit(LoginActivity.this);
//        }
//    }

//    /**
//     * 根据PersionId查询所属部门*
//     */
//    private void findByDepartment(String persionId) {
//        HttpManager.getData(LoginActivity.this, HttpManager.getPersonUrl1(persionId), new HttpRequestHandler<Results>() {
//            @Override
//            public void onSuccess(Results results) {
//
//                ArrayList<Person> item = JsonUtils.parsingPerson(results.getResultlist());
//
//                if (item != null || item.size() != 0) {
//                    AccountUtils.setDepartment(LoginActivity.this, item.get(0).department);
//                }
//            }
//
//            @Override
//            public void onSuccess(Results results, int totalPages, int currentPage) {
//
//
//            }
//
//            @Override
//            public void onFailure(String error) {
//
//            }
//        });
//    }


    //    private void NormalListDialog() {
//        final NormalListDialog dialog = new NormalListDialog(LoginActivity.this, mMenuItems);
//        dialog.title("请选择")//
//                .showAnim(mBasIn)//
//                .dismissAnim(mBasOut)//
//                .show();
//        dialog.setOnOperItemClickL(new OnOperItemClickL() {
//            @Override
//            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.i(TAG, "ip=" + idadresss[position]);
//                String ip = idadresss[position];
//                if (ip.contains("√")) {
//                    ip.replace("√", "");
//                }
//                AccountUtils.setIpAddress(LoginActivity.this, getResources().getStringArray(R.array.address_text)[position].split(" ")[1].trim());
//                adress = getResources().getStringArray(R.array.address_text)[position].split(" ")[1].trim();
//                dialog.dismiss();
//            }
//        });
//    }
//
//
//    /**
//     * 设置服务端地址*
//     */
//    private void addIpData() {
//        String[] inspotypes = getResources().getStringArray(R.array.address_text);
//        idadresss = getResources().getStringArray(R.array.address_text);
//
//        for (int i = 0; i < inspotypes.length; i++) {
//            if (adress != null && adress.equals(inspotypes[i].split(" ")[1])) {
//                mMenuItems.add(new DialogMenuItem("√  " + inspotypes[i], 0));
//            } else {
//                mMenuItems.add(new DialogMenuItem("    " + inspotypes[i], 0));
//            }
//        }
//    }
//
//
//    private class MyUICheckUpdateCallback implements UICheckUpdateCallback {
//        @Override
//        public void onCheckComplete() {
//            Log.i(TAG, "onCheckComplete");
//        }
//
//    }
//
    public String getVersion() {
        try {
            PackageManager manager = this.getPackageManager();
            PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return this.getString(R.string.can_not_find_version_name);
        }
    }

    private FlippingLoadingDialog getLoadingDialog(String msg) {
        if (mLoadingDialog == null)
            mLoadingDialog = new FlippingLoadingDialog(this, msg);
        return mLoadingDialog;
    }
}
