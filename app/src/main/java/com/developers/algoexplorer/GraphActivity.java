package com.developers.algoexplorer;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.developers.algoexplorer.adapters.GraphTabPagerAdapter;

public class GraphActivity extends AppCompatActivity {
    private ViewPager mPager4;
    private TabLayout graphtab;
    private static String graphtitle;
    private GraphTabPagerAdapter graphTabPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        mPager4= (ViewPager) findViewById(R.id.pager3);
        graphtab= (TabLayout) findViewById(R.id.tab3);
        Bundle extras=getIntent().getExtras();
        graphtitle=extras.getString("graphname");
        switch (graphtitle){
            case "Floyd–Warshall algorithm":
                Glide.with(this).load(R.drawable.floydwarshall).into(new GlideDrawableImageViewTarget((ImageView) findViewById(R.id.gifgraph)));
                break;
            case "Dijkstra's algorithm":
                Glide.with(this).load(R.drawable.dijkstra_animation).into(new GlideDrawableImageViewTarget((ImageView) findViewById(R.id.gifgraph)));
                break;
        }
        graphtab.addTab(graphtab.newTab().setText("Description"));
        graphtab.addTab(graphtab.newTab().setText("Programs"));
        graphtab.addTab(graphtab.newTab().setText("Algorithms"));
        graphTabPagerAdapter=new GraphTabPagerAdapter(getSupportFragmentManager());
        mPager4.setAdapter(graphTabPagerAdapter);
        mPager4.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(graphtab));
        graphtab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               mPager4.setCurrentItem(tab.getPosition());
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
    public static String getGraphtitle(){
        return graphtitle;
    }
}
