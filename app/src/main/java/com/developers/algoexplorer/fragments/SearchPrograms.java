package com.developers.algoexplorer.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.developers.algoexplorer.Programs.SearchingPrograms;
import com.developers.algoexplorer.R;
import com.developers.algoexplorer.SearchingActivity;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchPrograms extends Fragment {

    private CodeView searchprogram;
    private SearchingActivity searchingActivity;
    private String searchtitle;
    public SearchPrograms() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1= inflater.inflate(R.layout.fragment_search_programs, container, false);
        searchprogram= (CodeView) v1.findViewById(R.id.program1);
        switch(searchtitle){
            case "Binary Search":
                addSearchPrograms(SearchingPrograms.BINARY_SEARCH_PROGRAM);
                break;
            case "Linear Search":
                addSearchPrograms(SearchingPrograms.LINEAR_SEARCH_PROGRAM);
                break;
        }

        return v1;
    }

    private void addSearchPrograms(String source) {
        searchprogram.setTheme(CodeViewTheme.GITHUB);
        searchprogram.setHorizontalScrollBarEnabled(true);
        searchprogram.setVerticalScrollBarEnabled(true);
        searchprogram.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //view.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        searchprogram.showCode(source);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            searchingActivity= (SearchingActivity) context;
            searchtitle=searchingActivity.getSearchName();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
