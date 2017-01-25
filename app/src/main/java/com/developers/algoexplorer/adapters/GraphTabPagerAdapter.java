package com.developers.algoexplorer.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.developers.algoexplorer.fragments.GraphAlgorithms;
import com.developers.algoexplorer.fragments.GraphDescription;
import com.developers.algoexplorer.fragments.GraphPrograms;

/**
 * Created by Amanjeet Singh on 23-Jan-17.
 */

public class GraphTabPagerAdapter extends FragmentPagerAdapter {

    public GraphTabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new GraphDescription();
            case 1:
                return new GraphPrograms();
            case 2:
                return new GraphAlgorithms();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
