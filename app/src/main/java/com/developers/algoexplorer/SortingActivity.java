package com.developers.algoexplorer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.developers.algoexplorer.adapters.TabPagerAdapter;
import com.developers.algoexplorer.fragments.Description;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SortingActivity extends AppCompatActivity{
    private ViewPager mPager;
    private TabLayout tab;
    private ProgressBar progressBar;
    private static String title;
    private static int images[]=new int[]{R.drawable.bubble,R.drawable.mergesort,R.drawable.insertionsort,R.drawable.quicksort,
                                          R.drawable.heapsort,R.drawable.selection};

    private TabPagerAdapter tabPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorting);
        mPager= (ViewPager) findViewById(R.id.pager);
        tab=(TabLayout)findViewById(R.id.tab);
        progressBar= (ProgressBar) findViewById(R.id.prog);
        progressBar.setVisibility(View.VISIBLE);
        Bundle extras=getIntent().getExtras();
        title=extras.getString("sortname");
        switch (title){
            case "Bubble Sort":
                Glide.with(this).load(images[0]).into(new GlideDrawableImageViewTarget((ImageView) findViewById(R.id.gif)));
                break;
            case "Merge Sort":
                Glide.with(this).load(images[1]).into(new GlideDrawableImageViewTarget((ImageView) findViewById(R.id.gif)));
                break;
            case "Insertion Sort":
                Glide.with(this).load(images[2]).into(new GlideDrawableImageViewTarget((ImageView) findViewById(R.id.gif)));
                break;
            case "Quick Sort":
                Glide.with(this).load(images[3]).into(new GlideDrawableImageViewTarget((ImageView) findViewById(R.id.gif)));
                break;
            case "Heap Sort":
                Glide.with(this).load(images[4]).into(new GlideDrawableImageViewTarget((ImageView) findViewById(R.id.gif)));
                break;
            case "Selection Sort":
                Glide.with(this).load(images[5]).into(new GlideDrawableImageViewTarget((ImageView) findViewById(R.id.gif)));
                break;
        }
        Bundle bundle=new Bundle();
        bundle.putString(Description.DESC,title);
        Description description=new Description();
        description.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().commit();
        tab.addTab(tab.newTab().setText("Description"));
        tab.addTab(tab.newTab().setText("C++ Program"));
        tab.addTab(tab.newTab().setText("Algorithm"));
        tabPagerAdapter=new TabPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(tabPagerAdapter);
        mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mPager.setCurrentItem(tab.getPosition());
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

    public static String gettitle() {
        return title;
    }
}
