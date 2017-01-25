package com.developers.algoexplorer.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.developers.algoexplorer.Algorithms.GraphAlgos;
import com.developers.algoexplorer.GraphActivity;
import com.developers.algoexplorer.R;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

/**
 * A simple {@link Fragment} subclass.
 */
public class GraphAlgorithms extends Fragment {


    public GraphAlgorithms() {
        // Required empty public constructor
    }

    private CodeView algoview;
    private GraphActivity graphActivity;
    private String graphname;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_graph_algorithms, container, false);
        algoview= (CodeView) v.findViewById(R.id.graphalgorithm);
        switch (graphname){
            case "Floyd–Warshall algorithm":
                addAlgo(GraphAlgos.floydalgo);
                break;
            case "Dijkstra's algorithm":
                addAlgo(GraphAlgos.dijalgo);
                break;
        }
        return v;

    }

    private void addAlgo(String algo) {

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
        algoview.showCode(algo);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            graphActivity= (GraphActivity) context;
            graphname=graphActivity.getGraphtitle();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
