package com.developers.algoexplorer.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.developers.algoexplorer.Algorithms.SearchingAlgos;
import com.developers.algoexplorer.R;
import com.developers.algoexplorer.SearchingActivity;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchingAlgorithms extends Fragment {
    private SearchingActivity searchingActivity;
    private String searchname;
    private CodeView algo;
    public SearchingAlgorithms() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v2= inflater.inflate(R.layout.fragment_searching_algorithms, container, false);
        algo= (CodeView) v2.findViewById(R.id.searchalgorithm);
        switch(searchname){
            case "Binary Search":
                 addAlgos(SearchingAlgos.BINARY_SEARCH_ALGORITHM);
                break;
            case "Linear Search":
                addAlgos(SearchingAlgos.LINEAR_SEARCH_ALGORITHM);
                break;
        }
        return v2;
    }

    private void addAlgos(String algocode) {
        algo.setTheme(CodeViewTheme.GITHUB);
        algo.setHorizontalScrollBarEnabled(true);
        algo.setVerticalScrollBarEnabled(true);
        algo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //view.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        algo.showCode(algocode);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            searchingActivity = (SearchingActivity) context;
            searchname=searchingActivity.getSearchName();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
