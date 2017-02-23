package com.hsk.hxqh.agp_eam.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.hsk.hxqh.agp_eam.R;
import com.hsk.hxqh.agp_eam.ui.widget.SlidingMenu;

public class MainActivity extends AppCompatActivity {

    private SlidingMenu mMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mMenu = (SlidingMenu) findViewById(R.id.id_menu);
    }

    public void toggleMenu(View view) {
        mMenu.toggle();
    }
}
