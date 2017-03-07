package com.hsk.hxqh.agp_eam.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsk.hxqh.agp_eam.R;

/**
 * Created by Administrator on 2017/2/27.
 * 工作申请
 */

public class UdworkapplyFragment extends BaseFragment {
    private static final String TAG = "UdworkapplyFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_udworkapplylist, container,
                false);

        findByIdView(view);
        initView();
        return view;
    }

    /**
     * 初始化界面组件*
     */
    private void findByIdView(View view) {

    }


    /**
     * 设置事件监听*
     */
    private void initView() {


    }


}
