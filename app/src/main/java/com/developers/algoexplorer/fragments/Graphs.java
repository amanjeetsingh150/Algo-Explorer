package com.developers.algoexplorer.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.developers.algoexplorer.GraphActivity;
import com.developers.algoexplorer.R;
import com.developers.algoexplorer.adapters.CustomListGraphAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Graphs extends Fragment {


    public Graphs() {
        // Required empty public constructor
    }

    private ListView graphlist;
    private ArrayList<String> graphalgo=new ArrayList<String>();
    private CustomListGraphAdapter adapter;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_graphs, container, false);
        graphlist= (ListView) v.findViewById(R.id.list4);
        graphalgo.add(0,"Floyd–Warshall algorithm");
        graphalgo.add(1,"Dijkstra's algorithm");
        adapter=new CustomListGraphAdapter(getActivity(),graphalgo);
        graphlist.setAdapter(adapter);
        graphlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(), GraphActivity.class);
                intent.putExtra("graphname",graphalgo.get(i));
                startActivity(intent);
            }
        });
        return v;
    }

}
