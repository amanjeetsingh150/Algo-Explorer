package com.developers.algoexplorer;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.developers.algoexplorer.adapters.DynamicTabPagerAdapter;

public class DynamicActivity extends AppCompatActivity {
    private static int img[]={R.drawable.knapsack,R.drawable.binomial};
    private ViewPager mPager3;
    private TabLayout dynamictab;
    private ProgressBar prog;
    private static String dynamictitle;
    private DynamicTabPagerAdapter dynamicTabPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
        prog= (ProgressBar) findViewById(R.id.prog1);
        mPager3= (ViewPager) findViewById(R.id.pager2);
        dynamictab= (TabLayout) findViewById(R.id.tab2);
        Bundle extras=getIntent().getExtras();
        dynamictitle=extras.getString("dynamicname");
        switch(dynamictitle){
            case "0-1 Knapsack":
                Glide.with(this).load(R.drawable.knapsack).listener(new RequestListener<Integer, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, Integer model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, Integer model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        prog.setVisibility(View.GONE);
                        return false;
                    }
                }).into(new GlideDrawableImageViewTarget((ImageView) findViewById(R.id.gifdynamic)));
                break;
            case "Binomial Coefficient":
                Glide.with(this).load(R.drawable.binomial).listener(new RequestListener<Integer, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, Integer model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, Integer model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        prog.setVisibility(View.GONE);
                        return false;
                    }
                }).into(new GlideDrawableImageViewTarget((ImageView) findViewById(R.id.gifdynamic)));
                break;
            case "Longest Common Subsequence":
                Glide.with(this).load(R.drawable.lcs).listener(new RequestListener<Integer, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, Integer model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, Integer model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        prog.setVisibility(View.GONE);
                        return false;
                    }
                }).into(new GlideDrawableImageViewTarget((ImageView) findViewById(R.id.gifdynamic)));
                break;
            case "Matrix Chain Multiplication":
                Glide.with(this).load(R.drawable.mcm).listener(new RequestListener<Integer, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, Integer model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, Integer model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        prog.setVisibility(View.GONE);
                        return false;
                    }
                }).into(new GlideDrawableImageViewTarget((ImageView) findViewById(R.id.gifdynamic)));
                break;
        }
        dynamictab.addTab(dynamictab.newTab().setText("Description"));
        dynamictab.addTab(dynamictab.newTab().setText("Program"));
        dynamictab.addTab(dynamictab.newTab().setText("Algorithm"));
        dynamictab.addTab(dynamictab.newTab().setText("Example"));
        dynamicTabPagerAdapter=new DynamicTabPagerAdapter(getSupportFragmentManager());
        mPager3.setAdapter(dynamicTabPagerAdapter);
        mPager3.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(dynamictab));
        dynamictab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mPager3.setCurrentItem(tab.getPosition());
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
    public static String getDynamicTitle()
    {
        return dynamictitle;
    }
}
