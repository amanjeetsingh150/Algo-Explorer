package com.developers.algoexplorer.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.developers.algoexplorer.fragments.DynamicAlgorithms;
import com.developers.algoexplorer.fragments.DynamicDescription;
import com.developers.algoexplorer.fragments.DynamicExample;
import com.developers.algoexplorer.fragments.DynamicPrograms;

/**
 * Created by Amanjeet Singh on 19-Jan-17.
 */

public class DynamicTabPagerAdapter extends FragmentPagerAdapter {

    public DynamicTabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new DynamicDescription();
            case 1:
                return new DynamicPrograms();
            case 2:
                return new DynamicAlgorithms();
            case 3:
                return new DynamicExample();
        }
        return null;
    }
    @Override
    public int getCount() {
        return 4;
    }
}
