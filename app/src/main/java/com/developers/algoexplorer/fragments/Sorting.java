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
import com.developers.algoexplorer.SortingActivity;
import com.developers.algoexplorer.adapters.CustomListSortingAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Sorting extends Fragment {
    private ArrayList<String> sortname;
    private ListView mList;
    private CustomListSortingAdapter adapter;
 ;  private Intent intent;
    public Sorting() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_sorting, container, false);
        sortname=new ArrayList<String>();
        sortname.add("Bubble Sort");
        sortname.add("Merge Sort");
        sortname.add("Insertion Sort");
        sortname.add("Quick Sort");
        sortname.add("Heap Sort");
        sortname.add("Selection Sort");
        mList= (ListView) v.findViewById(R.id.list);
        adapter=new CustomListSortingAdapter(getActivity(),sortname);
        mList.setAdapter(adapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent=new Intent(getActivity(),SortingActivity.class);
                intent.putExtra("sortname",sortname.get(position));
                startActivity(intent);
            }
        });
        return v;
    }

}
