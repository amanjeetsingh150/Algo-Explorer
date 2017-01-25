package com.developers.algoexplorer.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.developers.algoexplorer.fragments.SearchDescription;
import com.developers.algoexplorer.fragments.SearchPrograms;
import com.developers.algoexplorer.fragments.SearchingAlgorithms;

/**
 * Created by Amanjeet Singh on 16-Jan-17.
 */

public class SearchTabPagerAdapter extends FragmentPagerAdapter {

    public SearchTabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new SearchDescription();
            case 1:
                return new SearchPrograms();
            case 2:
                return new SearchingAlgorithms();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
