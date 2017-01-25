package com.developers.algoexplorer.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.developers.algoexplorer.Programs.SortingPrograms;
import com.developers.algoexplorer.R;
import com.developers.algoexplorer.SortingActivity;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

/**
 * A simple {@link Fragment} subclass.
 */
public class Program extends Fragment {

    private SortingActivity sort;
    private String title1;
    private CodeView program;
    public Program() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v2= inflater.inflate(R.layout.fragment_program, container, false);
        program= (CodeView) v2.findViewById(R.id.program);
        switch(title1){
            case "Bubble Sort":addCode(SortingPrograms.BUBBLE_SORT_PROG);
                break;
            case "Merge Sort":addCode(SortingPrograms.MERGE_SORT_PROGRAM);
                break;
            case "Insertion Sort":addCode(SortingPrograms.INSERTION_SORT_PROGRAM);
                break;
            case "Quick Sort":addCode(SortingPrograms.QUICK_SORT_PROGRAM);
                break;
            case "Heap Sort":addCode(SortingPrograms.HEAP_SORT_PROGRAM);
                break;
            case "Selection Sort":addCode(SortingPrograms.SELECTION_SORT_PROGRAM);
                break;
        }
        return v2;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            sort = (SortingActivity) context;
            title1 = sort.gettitle();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private void addCode(String source){
        program.setTheme(CodeViewTheme.GITHUB);
        program.setHorizontalScrollBarEnabled(true);
        program.setVerticalScrollBarEnabled(true);
        program.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //view.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        program.showCode(source);
    }
}
