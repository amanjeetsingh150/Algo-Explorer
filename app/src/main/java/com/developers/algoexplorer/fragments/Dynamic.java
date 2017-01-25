package com.developers.algoexplorer.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.developers.algoexplorer.DynamicActivity;
import com.developers.algoexplorer.R;
import com.developers.algoexplorer.adapters.CustomListDynamicAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Dynamic extends Fragment {

    private ArrayList<String> dynamicname=new ArrayList<>();
    private ListView dynamicnamelist;
    private CustomListDynamicAdapter dynamicAdapter;
    private Intent intent;
    public Dynamic() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_dynamic, container, false);
        dynamicnamelist= (ListView) v.findViewById(R.id.list3);
        dynamicname.add(0,"0-1 Knapsack");
        dynamicname.add(1,"Binomial Coefficient");
        dynamicname.add(2,"Longest Common Subsequence");
        dynamicname.add(3,"Matrix Chain Multiplication");
        dynamicAdapter=new CustomListDynamicAdapter(getActivity(),dynamicname);
        dynamicnamelist.setAdapter(dynamicAdapter);
        dynamicnamelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent=new Intent(getActivity(), DynamicActivity.class);
                intent.putExtra("dynamicname",dynamicname.get(i));
                startActivity(intent);
            }
        });
        return v;
    }

}
