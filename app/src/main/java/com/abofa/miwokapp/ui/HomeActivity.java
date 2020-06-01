package com.abofa.miwokapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.abofa.miwokapp.R;
import com.abofa.miwokapp.base.BaseActivity;
import com.abofa.miwokapp.ui.Adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    protected TabLayout tabLayout;
    protected ViewPager viewPager;
   // protected ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_home);
        initView();
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

    }


    private void initView() {
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        //imgBack =  findViewById(R.id.img_back);
        //imgBack.setOnClickListener(HomeActivity.this);
    }

    @Override
    public void onClick(View view) {
        /*if (view.getId() == R.id.img_back) {
            if (!(getBaseContext() == HomeActivity.this))
                startActivity(new Intent(getBaseContext(),HomeActivity.class));
        }*/
    }
}
