package com.developers.algoexplorer.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.developers.algoexplorer.GraphActivity;
import com.developers.algoexplorer.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GraphDescription extends Fragment {


    public GraphDescription() {
        // Required empty public constructor
    }

    private TextView graphdescription,graphcomplexity,graphspacecomplexity;
    private GraphActivity graphActivity;
    private ArrayList<String> complexities=new ArrayList<String>();
    private ArrayList<String> spacecomplexities=new ArrayList<>();
    private String graphtitle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_graph_description, container, false);
        graphdescription= (TextView) v.findViewById(R.id.graphdesc);
        graphcomplexity= (TextView) v.findViewById(R.id.graphcomp);
        graphspacecomplexity= (TextView) v.findViewById(R.id.graphcomp2);
        complexities.add(0,"O(|V|^3) where V is number of vertices");
        complexities.add(1,"O(|V|^2) where V is number of vertices");
        spacecomplexities.add(0,"O(|V|^2)");
        spacecomplexities.add(1,"O(|V|)");
        switch (graphtitle){
            case "Floyd–Warshall algorithm":
                String des=getResources().getString(R.string.floyd_desc);
                graphdescription.setText(des);
                graphcomplexity.setText(complexities.get(0));
                graphspacecomplexity.setText(spacecomplexities.get(0));
                break;
            case "Dijkstra's algorithm":
                String des1=getResources().getString(R.string.dij_desc);
                graphdescription.setText(des1);
                graphcomplexity.setText(complexities.get(1));
                graphspacecomplexity.setText(spacecomplexities.get(1));
                break;
        }
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            graphActivity= (GraphActivity) context;
            graphtitle=graphActivity.getGraphtitle();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
