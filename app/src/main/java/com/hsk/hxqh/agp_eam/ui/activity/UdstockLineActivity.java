package com.hsk.hxqh.agp_eam.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hsk.hxqh.agp_eam.R;
import com.hsk.hxqh.agp_eam.adpter.BaseQuickAdapter;
import com.hsk.hxqh.agp_eam.adpter.Item_InventoryAdapter;
import com.hsk.hxqh.agp_eam.adpter.UdstockLineAdapter;
import com.hsk.hxqh.agp_eam.api.HttpManager;
import com.hsk.hxqh.agp_eam.api.HttpRequestHandler;
import com.hsk.hxqh.agp_eam.api.JsonUtils;
import com.hsk.hxqh.agp_eam.bean.Results;
import com.hsk.hxqh.agp_eam.model.ITEM;
import com.hsk.hxqh.agp_eam.model.UDSTOCK;
import com.hsk.hxqh.agp_eam.model.UDSTOCKLINE;
import com.hsk.hxqh.agp_eam.ui.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by think on 2015/12/3.
 * 库存盘点子表列表页面
 */
public class UdstockLineActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, SwipeRefreshLayout.OnLoadListener{

    private ImageView backImageView;
    private TextView titleTextView;
    private ImageView menuImageView;

    LinearLayoutManager layoutManager;
    public RecyclerView recyclerView;
    private LinearLayout nodatalayout;
    private UdstockLineAdapter udstockLineAdapter;
    private SwipeRefreshLayout refresh_layout = null;
    private int page = 1;
    public UDSTOCK udstock;
    public ArrayList<UDSTOCKLINE> assetArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        getIntentDate();
        findViewById();
        initView();
    }

    private void getIntentDate() {
        udstock = (UDSTOCK) getIntent().getSerializableExtra("udstock");
//        woactivityList = (ArrayList<Woactivity>) getIntent().getSerializableExtra("woactivityList");
    }

    @Override
    protected void findViewById() {
        backImageView = (ImageView) findViewById(R.id.menu_id);
        titleTextView = (TextView) findViewById(R.id.menu_title);
        menuImageView = (ImageView) findViewById(R.id.title_more);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_id);
        refresh_layout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        nodatalayout = (LinearLayout) findViewById(R.id.have_not_data_id);
//        confirmlayout = (LinearLayout) findViewById(R.id.button_layout);
//        confirmBtn = (Button) findViewById(R.id.confirm);
    }

    @Override
    protected void initView() {
        backImageView.setBackgroundResource(R.drawable.ic_back);
        backImageView.setOnClickListener(backOnClickListener);
        titleTextView.setText(getResources().getString(R.string.udstockline));
        menuImageView.setImageResource(R.drawable.ic_add);
//        menuImageView.setOnClickListener(menuImageViewOnClickListener);
//        confirmlayout.setVisibility(View.GONE);
//        confirmBtn.setOnClickListener(confirmBtnOnClickListener);
        layoutManager = new LinearLayoutManager(UdstockLineActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        woactivityAdapter = new WoactivityAdapter(Work_WoactivityActivity.this);
//        recyclerView.setAdapter(woactivityAdapter);

        refresh_layout.setColor(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        refresh_layout.setOnRefreshListener(this);
        refresh_layout.setOnLoadListener(this);

//        mBasIn = new BounceTopEnter();
//        mBasOut = new SlideBottomExit();

    }

    @Override
    public void onStart() {
        super.onStart();
        refresh_layout.setRefreshing(true);
        initAdapter(new ArrayList<UDSTOCKLINE>());
        assetArrayList = new ArrayList<>();
        getData();
    }

    private View.OnClickListener backOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    /**
     * 获取数据*
     */
    private void getData() {
        HttpManager.getDataPagingInfo(UdstockLineActivity.this, HttpManager.getUdstocklineUrl(udstock.getSTOCKNUM(),page, 20), new HttpRequestHandler<Results>() {
            @Override
            public void onSuccess(Results results) {
                Log.i(TAG, "data=" + results);
            }

            @Override
            public void onSuccess(Results results, int totalPages, int currentPage) {
                ArrayList<UDSTOCKLINE> item = JsonUtils.parsingUDSTOCKLINE(UdstockLineActivity.this, results.getResultlist());
                refresh_layout.setRefreshing(false);
                refresh_layout.setLoading(false);
                if (item == null || item.isEmpty()) {
                    nodatalayout.setVisibility(View.VISIBLE);
                } else {

                    if (item != null || item.size() != 0) {
                        if (page == 1) {
                            assetArrayList = new ArrayList<UDSTOCKLINE>();
                            initAdapter(assetArrayList);
                        }
                        for (int i = 0; i < item.size(); i++) {
                            assetArrayList.add(item.get(i));
                        }
                        addData(item);
                    }
                    nodatalayout.setVisibility(View.GONE);

                    initAdapter(assetArrayList);
                }
            }

            @Override
            public void onFailure(String error) {
                refresh_layout.setRefreshing(false);
                nodatalayout.setVisibility(View.VISIBLE);
            }
        });

    }


    /**
     * 获取数据*
     */
    private void initAdapter(final List<UDSTOCKLINE> list) {
        udstockLineAdapter = new UdstockLineAdapter(UdstockLineActivity.this, R.layout.list_item_udstockline, list);
        recyclerView.setAdapter(udstockLineAdapter);
        udstockLineAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Intent intent = new Intent(Asset_beijianActivity.this, AssetDetailsActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("asset", assetArrayList.get(position));
//                intent.putExtras(bundle);
//                startActivityForResult(intent, 0);
            }
        });
    }

    /**
     * 添加数据*
     */
    private void addData(final List<UDSTOCKLINE> list) {
        udstockLineAdapter.addData(list);
    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        switch (resultCode) {
//            case 1://新增
//                if (data != null) {
//                    Woactivity woactivity = (Woactivity) data.getSerializableExtra("woactivity");
//                    woactivityAdapter.add(woactivity);
//                    initAdapter(woactivityAdapter.getData());
//                    nodatalayout.setVisibility(View.GONE);
//                }
//                confirmlayout.setVisibility(View.VISIBLE);
//                setNodataLayout();
//                break;
//            case 2://修改
//                if (data != null) {
//                    Woactivity woactivity = (Woactivity) data.getSerializableExtra("woactivity");
//                    int position = data.getIntExtra("position", 0);
//                    woactivityAdapter.set(position, woactivity);
//                    initAdapter(woactivityAdapter.getData());
//                    woactivityAdapter.notifyDataSetChanged();
//                }
//                confirmlayout.setVisibility(View.VISIBLE);
//                setNodataLayout();
//                break;
//            case 3://本地任务删除
//                if (data != null) {
//                    int position = data.getIntExtra("position", 0);
//                    woactivityAdapter.remove(position);
//                    initAdapter(woactivityAdapter.getData());
//                    woactivityAdapter.notifyDataSetChanged();
//                }
//                confirmlayout.setVisibility(View.VISIBLE);
//                setNodataLayout();
//                break;
//            case 4://服务器任务删除操作
//                if (data != null) {
//                    Woactivity woactivity = (Woactivity) data.getSerializableExtra("woactivity");
//                    int position = data.getIntExtra("position", 0);
//                    deleteList.add(woactivity);
//                    woactivityAdapter.remove(position);
//                    initAdapter(woactivityAdapter.getData());
//                    woactivityAdapter.notifyDataSetChanged();
//                }
//                confirmlayout.setVisibility(View.VISIBLE);
//                setNodataLayout();
//                break;
//        }
//    }

    @Override
    public void onRefresh() {
//        if (!workOrder.isnew&& (woactivityList == null || woactivityList.size() == 0)) {
        page = 1;
        getData();
//        }else {
//            refresh_layout.setRefreshing(false);
//        }
    }

    @Override
    public void onLoad() {
//        if (!workOrder.isnew) {
//            if (woactivityList.size() <= 20) {
//                page = 1;
//            } else {
//                page = woactivityList.size() / 20 + 1;
//            }
        page++;
        getData();
//        }else {
//            refresh_layout.setLoading(false);
//        }
    }
}
