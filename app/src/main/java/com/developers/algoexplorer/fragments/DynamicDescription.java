package com.developers.algoexplorer.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.developers.algoexplorer.DynamicActivity;
import com.developers.algoexplorer.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DynamicDescription extends Fragment {

    private TextView dynamicdescription,formula,complexity;
    private DynamicActivity dynamicActivity;
    private String dynamicname,des,form;
    private ArrayList<String> complexities=new ArrayList<>();
    public DynamicDescription() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_dynamic_description, container, false);
        dynamicdescription= (TextView) v.findViewById(R.id.dynamicdesc);
        formula=(TextView)v.findViewById(R.id.formula);
        complexity= (TextView) v.findViewById(R.id.comp);
        complexities.add(0,"O(nW)");
        complexities.add(1,"O(n*k)");
        complexities.add(2,"O(mn)");
        complexities.add(3,"O(N^3)");
        switch(dynamicname){
            case "0-1 Knapsack":
                des=getResources().getString(R.string.knapsack_desc);
                dynamicdescription.setText(des);
                form=getResources().getString(R.string.knapsack_formula);
                formula.setText(form);
                complexity.setText(complexities.get(0)+"\nwhere n is the number of items and W is the capacity of knapsack.");
                break;
            case "Binomial Coefficient":
                des=getResources().getString(R.string.binomial_desc);
                dynamicdescription.setText(des);
                form=getResources().getString(R.string.binomial_formula);
                formula.setText(form);
                complexity.setText(complexities.get(1));
                break;
            case "Longest Common Subsequence":
                des=getResources().getString(R.string.lcs_desc);
                dynamicdescription.setText(des);
                form=getResources().getString(R.string.lcs_formula);
                formula.setText(form);
                complexity.setText(complexities.get(2)+"for finding LCS length");
                break;
            case "Matrix Chain Multiplication":
                des=getResources().getString(R.string.mcm_desc);
                dynamicdescription.setText(des);
                form=getResources().getString(R.string.mcm_formula);
                formula.setText(form);
                complexity.setText(complexities.get(3));
                break;
        }

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            dynamicActivity = (DynamicActivity) context;
            dynamicname = dynamicActivity.getDynamicTitle();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
