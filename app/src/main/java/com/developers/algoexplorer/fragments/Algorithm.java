package com.developers.algoexplorer.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.developers.algoexplorer.Algorithms.SortingAlgorithms;
import com.developers.algoexplorer.Programs.SortingPrograms;
import com.developers.algoexplorer.R;
import com.developers.algoexplorer.SortingActivity;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

/**
 * A simple {@link Fragment} subclass.
 */
public class Algorithm extends Fragment {
    private CodeView algoview;
    private SortingActivity sortingActivity;
    private String titlealgo;
    public Algorithm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1= inflater.inflate(R.layout.fragment_algorithm, container, false);
        algoview= (CodeView) v1.findViewById(R.id.algorithm);
        switch(titlealgo){
            case "Bubble Sort":addAlgo(SortingAlgorithms.BUBBLE_SORT_ALGO);
                break;
            case "Merge Sort":addAlgo(SortingAlgorithms.MERGE_SORT_ALGO);
                break;
            case "Insertion Sort":addAlgo(SortingAlgorithms.INSERTION_SORT_ALGORITHM);
                break;
            case "Quick Sort":addAlgo(SortingAlgorithms.QUICK_SORT_ALGORITHM);
                break;
            case "Heap Sort":addAlgo(SortingAlgorithms.HEAP_SORT_ALGORITHM);
                break;
            case "Selection Sort":addAlgo(SortingAlgorithms.SELECTION_SORT_ALGORITHM);
                break;
        }
        return v1;
    }

    private void addAlgo(String algoCode) {
        algoview.setTheme(CodeViewTheme.GITHUB);
        algoview.setHorizontalScrollBarEnabled(true);
        algoview.setVerticalScrollBarEnabled(true);
        algoview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //view.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        algoview.showCode(algoCode);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            sortingActivity= (SortingActivity) context;
            titlealgo=sortingActivity.gettitle();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
