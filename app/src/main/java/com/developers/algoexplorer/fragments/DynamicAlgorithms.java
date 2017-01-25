package com.developers.algoexplorer.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.developers.algoexplorer.Algorithms.DynamicProgrammingAlgos;
import com.developers.algoexplorer.DynamicActivity;
import com.developers.algoexplorer.R;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

/**
 * A simple {@link Fragment} subclass.
 */
public class DynamicAlgorithms extends Fragment {

    private CodeView dynamicalgo;
    private String title;
    private DynamicActivity  dynamicActivity;
    public DynamicAlgorithms() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v2= inflater.inflate(R.layout.fragment_dynamic_algorithms, container, false);
        dynamicalgo= (CodeView) v2.findViewById(R.id.dynamicalgorithm);
        switch (title){
            case "0-1 Knapsack":
                addAlgo(DynamicProgrammingAlgos.knapsackalgo);
                break;
            case "Binomial Coefficient":
                addAlgo(DynamicProgrammingAlgos.binomialalgo);
                break;
            case "Longest Common Subsequence":
                addAlgo(DynamicProgrammingAlgos.lcsalgo);
                break;
            case "Matrix Chain Multiplication":
                addAlgo(DynamicProgrammingAlgos.mcmalgo);
                break;
        }
        return v2;
    }

    private void addAlgo(String algo) {
        dynamicalgo.setTheme(CodeViewTheme.GITHUB);
        dynamicalgo.setHorizontalScrollBarEnabled(true);
        dynamicalgo.setVerticalScrollBarEnabled(true);
        dynamicalgo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //view.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        dynamicalgo.showCode(algo);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            dynamicActivity = (DynamicActivity) context;
            title=dynamicActivity.getDynamicTitle();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
