package com.hsk.hxqh.agp_eam.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.hsk.hxqh.agp_eam.R;
import com.hsk.hxqh.agp_eam.ui.activity.UdfaultreportActivity;

/**
 * Created by Administrator on 2017/2/27.
 * 工作申请
 */

public class UdworkapplyFragment extends BaseFragment {
    private static final String TAG = "UdworkapplyFragment";

    /**
     * 故障提报单
     **/
    private RelativeLayout udfaultreportLayout;

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
        udfaultreportLayout = (RelativeLayout) view.findViewById(R.id.udfaultreport_layout);

    }


    /**
     * 设置事件监听*
     */
    private void initView() {
        udfaultreportLayout.setOnClickListener(udfaultreportLayoutOnClickListener);

    }


    private View.OnClickListener udfaultreportLayoutOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), UdfaultreportActivity.class);
            startActivityForResult(intent, 0);
        }
    };


}
