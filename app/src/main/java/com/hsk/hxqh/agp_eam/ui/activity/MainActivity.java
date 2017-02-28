package com.hsk.hxqh.agp_eam.ui.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hsk.hxqh.agp_eam.R;
import com.hsk.hxqh.agp_eam.ui.fragment.AssetFragment;
import com.hsk.hxqh.agp_eam.ui.widget.SlidingMenu;

public class MainActivity extends BaseActivity {

    private SlidingMenu mMenu;
    private TextView menutitle;

    private RelativeLayout AssetLayout;//资产查询

    private AssetFragment assetFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        findViewById();
        initView();
    }

    protected void findViewById(){
        mMenu = (SlidingMenu) findViewById(R.id.id_menu);
        menutitle = (TextView) findViewById(R.id.menu_title);
        AssetLayout = (RelativeLayout) findViewById(R.id.asset_layout);
    }

    protected void initView(){
        AssetLayout.setOnClickListener(new layoutClickListener(2));
    }

    class layoutClickListener implements View.OnClickListener{
        int positiong;
        private layoutClickListener(int positiong){
            this.positiong = positiong;
        }

        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            switch (positiong){
                case 1:
                    break;
                case 2:
                    if (assetFragment == null) {
                        assetFragment = new AssetFragment();
                        Bundle bundle = new Bundle();
                        assetFragment.setArguments(bundle);
                    }
                    fragmentTransaction.replace(R.id.container, assetFragment).commit();
                    menutitle.setText(R.string.asset_text);
                    mMenu.toggle();
                    break;
                case 3:
                    break;
            }
        }
    }

    public void toggleMenu(View view) {
        mMenu.toggle();
    }
}
