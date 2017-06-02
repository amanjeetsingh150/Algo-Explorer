package com.developers.algoexplorer;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.developers.algoexplorer.adapters.SearchTabPagerAdapter;

public class SearchingActivity extends AppCompatActivity {
    private ViewPager mPager2;
    private TabLayout searchtab;
    private static String search;
    private static int img=R.drawable.searchingalgo;
    private SearchTabPagerAdapter searchTabPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);
        mPager2=(ViewPager)findViewById(R.id.pager1);
        searchtab=(TabLayout)findViewById(R.id.tab1);
        Bundle bundle=getIntent().getExtras();
        search=bundle.getString("searchname");
        switch(search){
            case "Linear Search":
                Glide.with(this).load(img).into(new GlideDrawableImageViewTarget((ImageView) findViewById(R.id.gif1)));
                break;
            case "Binary Search":
                Glide.with(this).load(img).into(new GlideDrawableImageViewTarget((ImageView) findViewById(R.id.gif1)));
                break;
        }
        searchtab.addTab(searchtab.newTab().setText("Description"));
        searchtab.addTab(searchtab.newTab().setText("Program"));
        searchtab.addTab(searchtab.newTab().setText("Algorithm"));
        searchTabPagerAdapter=new SearchTabPagerAdapter(getSupportFragmentManager());
        mPager2.setAdapter(searchTabPagerAdapter);
        mPager2.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(searchtab));
        searchtab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public static String getSearchName(){
        return search;
    }
}
