package com.developers.algoexplorer.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.developers.algoexplorer.fragments.Algorithm;
import com.developers.algoexplorer.fragments.Description;
import com.developers.algoexplorer.fragments.Program;

/**
 * Created by Amanjeet Singh on 12-Jan-17.
 */

public class TabPagerAdapter extends FragmentPagerAdapter {

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new Description();
            case 1:
                return new Program();
            case 2:
                return new Algorithm();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
