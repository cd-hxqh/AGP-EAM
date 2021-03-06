package com.hsk.hxqh.agp_eam.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hsk.hxqh.agp_eam.R;
import com.hsk.hxqh.agp_eam.adpter.BaseQuickAdapter;
import com.hsk.hxqh.agp_eam.adpter.WoactivityAdapter;
import com.hsk.hxqh.agp_eam.api.HttpManager;
import com.hsk.hxqh.agp_eam.api.HttpRequestHandler;
import com.hsk.hxqh.agp_eam.api.JsonUtils;
import com.hsk.hxqh.agp_eam.bean.Results;
import com.hsk.hxqh.agp_eam.model.WOACTIVITY;
import com.hsk.hxqh.agp_eam.model.WORKORDER;
import com.hsk.hxqh.agp_eam.ui.activity.AssetDetailsActivity;
import com.hsk.hxqh.agp_eam.ui.activity.WoactivityDetailsActivity;
import com.hsk.hxqh.agp_eam.ui.widget.SwipeRefreshLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * 工单任务的fragment
 */
@SuppressLint("ValidFragment")
public class WoactivityFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, SwipeRefreshLayout.OnLoadListener {
    private static String TAG = "WoactivityFragment";

    LinearLayoutManager layoutManager;
    /**
     * RecyclerView*
     */
    public RecyclerView recyclerView;
    /**
     * 暂无数据*
     */
    public LinearLayout nodatalayout;
    /**
     * 界面刷新*
     */
    private SwipeRefreshLayout refresh_layout = null;
    /**
     * 适配器*
     */
    public WoactivityAdapter woactivityAdapter;
    /**
     * 编辑框*
     */
    private EditText search;
    /**
     * 查询条件*
     */
    private String searchText = "";
    private int page = 1;

    private String istask;
    WORKORDER workorder;
    ArrayList<WOACTIVITY> items = new ArrayList<WOACTIVITY>();

    public WoactivityFragment(WORKORDER workOrder, ArrayList<WOACTIVITY> woactivities,String istask) {
        this.workorder = workOrder;
        this.items = woactivities;
        this.istask = istask;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list, container,
                false);

        findByIdView(view);
        initView();
        return view;
    }

    /**
     * 初始化界面组件*
     */
    private void findByIdView(View view) {

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_id);
        refresh_layout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_container);
        nodatalayout = (LinearLayout) view.findViewById(R.id.have_not_data_id);
        search = (EditText) view.findViewById(R.id.search_edit);
    }


    /**
     * 设置事件监听*
     */
    private void initView() {
//        setSearchEdit();

        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        refresh_layout.setColor(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        refresh_layout.setRefreshing(true);

        refresh_layout.setOnRefreshListener(this);
        refresh_layout.setOnLoadListener(this);


    }

    @Override
    public void onStart() {
        super.onStart();
        refresh_layout.setRefreshing(true);
        initAdapter(new ArrayList<WOACTIVITY>());
        items = new ArrayList<>();
        getData();
    }

    @Override
    public void onLoad() {
        page++;
        getData();
    }

    @Override
    public void onRefresh() {
        page = 1;
        getData();
    }


//    private void setSearchEdit() {
//        SpannableString msp = new SpannableString("XX搜索");
//        Drawable drawable = getResources().getDrawable(R.drawable.ic_search);
//        msp.setSpan(new ImageSpan(drawable), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
//        search.setHint(msp);
//        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//                    // 先隐藏键盘
//                    ((InputMethodManager) search.getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
//                            .hideSoftInputFromWindow(
//                                    getActivity().getCurrentFocus()
//                                            .getWindowToken(),
//                                    InputMethodManager.HIDE_NOT_ALWAYS);
//                    searchText = search.getText().toString();
//                    woactivityAdapter.removeAll(items);
//                    items = new ArrayList<WOACTIVITY>();
//                    nodatalayout.setVisibility(View.GONE);
//                    refresh_layout.setRefreshing(true);
//                    page = 1;
//                    getData(searchText);
//                    return true;
//                }
//                return false;
//            }
//        });
//    }


    /**
     * 获取数据*
     */
    private void getData() {
        HttpManager.getDataPagingInfo(getActivity(), HttpManager.getWoactivityUrl(workorder.WONUM,istask, page, 20), new HttpRequestHandler<Results>() {
            @Override
            public void onSuccess(Results results) {
                Log.i(TAG, "data=" + results);
            }

            @Override
            public void onSuccess(Results results, int totalPages, int currentPage) {
                ArrayList<WOACTIVITY> item = JsonUtils.parsingWOACTIVITY(getActivity(), results.getResultlist());
                refresh_layout.setRefreshing(false);
                refresh_layout.setLoading(false);
                if (item == null || item.isEmpty()) {
                    nodatalayout.setVisibility(View.VISIBLE);
                } else {

                    if (item != null || item.size() != 0) {
                        if (page == 1) {
                            items = new ArrayList<WOACTIVITY>();
                            initAdapter(items);
                        }
                        for (int i = 0; i < item.size(); i++) {
                            items.add(item.get(i));
                        }
                        addData(item);
                    }
                    nodatalayout.setVisibility(View.GONE);

                    initAdapter(items);
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
    private void initAdapter(final List<WOACTIVITY> list) {
        woactivityAdapter = new WoactivityAdapter(getActivity(), R.layout.list_item_woactivity, list);
        recyclerView.setAdapter(woactivityAdapter);
        woactivityAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), WoactivityDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("woactivity", items.get(position));
                bundle.putSerializable("workorder", workorder);
                bundle.putSerializable("woactivities", items);
                intent.putExtras(bundle);
                startActivityForResult(intent, 0);
            }
        });
    }

    /**
     * 添加数据*
     */
    private void addData(final List<WOACTIVITY> list) {
        woactivityAdapter.addData(list);
    }
}
