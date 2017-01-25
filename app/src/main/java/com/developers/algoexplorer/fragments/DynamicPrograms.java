package com.developers.algoexplorer.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.developers.algoexplorer.DynamicActivity;
import com.developers.algoexplorer.Programs.DynamicProgrammingProg;
import com.developers.algoexplorer.R;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

/**
 * A simple {@link Fragment} subclass.
 */
public class DynamicPrograms extends Fragment {

    private CodeView dynamicpro;
    private DynamicActivity dynamicActivity;
    private String names;
    public DynamicPrograms() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_dynamic_programs, container, false);
        dynamicpro= (CodeView) v.findViewById(R.id.program2);
        switch (names){
            case "0-1 Knapsack":
                addPro(DynamicProgrammingProg.Knapsack);
                break;
            case "Binomial Coefficient":
                addPro(DynamicProgrammingProg.binomial);
                break;
            case "Longest Common Subsequence":
                addPro(DynamicProgrammingProg.LcsProg);
                break;
            case "Matrix Chain Multiplication":
                addPro(DynamicProgrammingProg.MCM_prog);
                break;
        }
        return v;
    }

    private void addPro(String source) {
        dynamicpro.setTheme(CodeViewTheme.GITHUB);
        dynamicpro.setHorizontalScrollBarEnabled(true);
        dynamicpro.setVerticalScrollBarEnabled(true);
        dynamicpro.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //view.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        dynamicpro.showCode(source);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            dynamicActivity= (DynamicActivity) context;
            names=dynamicActivity.getDynamicTitle();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
