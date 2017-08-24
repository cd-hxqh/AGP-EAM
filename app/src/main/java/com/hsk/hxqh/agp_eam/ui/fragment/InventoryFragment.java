package com.hsk.hxqh.agp_eam.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.hsk.hxqh.agp_eam.R;
import com.hsk.hxqh.agp_eam.ui.activity.InventoryListActivity;
import com.hsk.hxqh.agp_eam.ui.activity.ItemListActivity;
import com.hsk.hxqh.agp_eam.ui.activity.UdstockListActivity;

/**
 * Created by Administrator on 2017/2/27.
 * 库存管理
 */

public class InventoryFragment extends BaseFragment {
    private static final String TAG = "InventoryFragment";
    private RelativeLayout udstockLayout;//库存盘点
    private RelativeLayout poLayout;//入库管理
    private RelativeLayout issueLayout;//出库管理
    private RelativeLayout transferLayout;//物料调拨
    private RelativeLayout inventoryLayout;//库存查询
    private RelativeLayout itemLayout;//物资台帐
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inventory, container,
                false);

        findByIdView(view);
        initView();
        return view;
    }

    /**
     * 初始化界面组件*
     */
    private void findByIdView(View view) {
        udstockLayout = (RelativeLayout) view.findViewById(R.id.udstock_layout);
        poLayout = (RelativeLayout) view.findViewById(R.id.po_layout);
        issueLayout = (RelativeLayout) view.findViewById(R.id.invuse_issue_layout);
        transferLayout = (RelativeLayout) view.findViewById(R.id.invuse_transfer_layout);
        inventoryLayout = (RelativeLayout) view.findViewById(R.id.inventory_layout);
        itemLayout = (RelativeLayout) view.findViewById(R.id.item_layout);
    }


    /**
     * 设置事件监听*
     */
    private void initView() {
        udstockLayout.setOnClickListener(udstockLayoutOnClickListener);
        poLayout.setOnClickListener(poLayoutOnClickListener);
        issueLayout.setOnClickListener(issueLayoutOnClickListener);
        transferLayout.setOnClickListener(transferLayoutOnClickListener);
        inventoryLayout.setOnClickListener(inventoryLayoutOnClickListener);
        itemLayout.setOnClickListener(itemLayoutOnClickListener);
    }

    private View.OnClickListener udstockLayoutOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), UdstockListActivity.class);
//            intent.putExtra("type","CM");
            startActivity(intent);
        }
    };

    private View.OnClickListener poLayoutOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            Intent intent = new Intent(getActivity(), WorkOederListActivity.class);
//            intent.putExtra("type","PM");
//            startActivity(intent);
        }
    };

    private View.OnClickListener issueLayoutOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            Intent intent = new Intent(getActivity(), WorkOederListActivity.class);
//            intent.putExtra("type","PM");
//            startActivity(intent);
        }
    };

    private View.OnClickListener transferLayoutOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            Intent intent = new Intent(getActivity(), WorkOederListActivity.class);
//            intent.putExtra("type","PM");
//            startActivity(intent);
        }
    };

    private View.OnClickListener inventoryLayoutOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), InventoryListActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener itemLayoutOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), ItemListActivity.class);
//            intent.putExtra("type","PM");
            startActivity(intent);
        }
    };
}
