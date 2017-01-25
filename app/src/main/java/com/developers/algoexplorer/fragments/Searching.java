package com.developers.algoexplorer.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.developers.algoexplorer.R;
import com.developers.algoexplorer.SearchingActivity;
import com.developers.algoexplorer.adapters.CustomListSearchingAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Searching extends Fragment {

    private ArrayList<String> searchname=new ArrayList<String>();
    private ListView searchList;
    private CustomListSearchingAdapter adapter;
    private Intent intent;
    public Searching() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1= inflater.inflate(R.layout.fragment_searching, container, false);
        searchname.add(0,"Linear Search");
        searchname.add(1,"Binary Search");
        searchList=(ListView)v1.findViewById(R.id.list2);
        adapter=new CustomListSearchingAdapter(getActivity(),searchname);
        searchList.setAdapter(adapter);
        searchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent=new Intent(getActivity(), SearchingActivity.class);
                intent.putExtra("searchname",searchname.get(i));
                startActivity(intent);
            }
        });
        return v1;
    }

}
