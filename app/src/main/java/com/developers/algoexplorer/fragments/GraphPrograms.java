package com.developers.algoexplorer.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.developers.algoexplorer.DynamicActivity;
import com.developers.algoexplorer.GraphActivity;
import com.developers.algoexplorer.Programs.GraphProgramming;
import com.developers.algoexplorer.R;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

/**
 * A simple {@link Fragment} subclass.
 */
public class GraphPrograms extends Fragment {


    public GraphPrograms() {
        // Required empty public constructor
    }

    private CodeView graphpro;
    private GraphActivity graphActivity;
    private String names;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1=inflater.inflate(R.layout.fragment_graph_programs, container, false);
        graphpro= (CodeView) v1.findViewById(R.id.graphprogram);
        switch (names){
            case "Floyd–Warshall algorithm":
                addPro(GraphProgramming.floydpro);
                break;
            case "Dijkstra's algorithm":
                addPro(GraphProgramming.dijpro);
                break;
        }
        return v1;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            graphActivity= (GraphActivity) context;
            names=graphActivity.getGraphtitle();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private void addPro(String source) {
        graphpro.setTheme(CodeViewTheme.GITHUB);
        graphpro.setHorizontalScrollBarEnabled(true);
        graphpro.setVerticalScrollBarEnabled(true);
        graphpro.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //view.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        graphpro.showCode(source);
    }
}
