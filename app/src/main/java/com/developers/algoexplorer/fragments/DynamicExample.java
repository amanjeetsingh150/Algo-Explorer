package com.developers.algoexplorer.fragments;


import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.developers.algoexplorer.DynamicActivity;
import com.developers.algoexplorer.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * A simple {@link Fragment} subclass.
 */
public class DynamicExample extends Fragment {



    private AssetManager as;
    private InputStream is;
    private TextView exp;
    private DynamicActivity activity;
    private String methodname;
    public DynamicExample() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v2= inflater.inflate(R.layout.fragment_dynamic_example, container, false);
        exp= (TextView) v2.findViewById(R.id.exp);
        as=getActivity().getAssets();
        try {
            switch(methodname){
                case "0-1 Knapsack":
                    is=as.open("knapsackexp.txt");
                    break;
                case "Binomial Coefficient":
                    is=as.open("binomialexp.txt");
                    break;
                case "Longest Common Subsequence":
                    is=as.open("lcsexp.txt");
                    break;
                case "Matrix Chain Multiplication":
                    is=as.open("mcmexp.txt");
                    break;

            }
            BufferedReader bis=new BufferedReader(new InputStreamReader(is));
            StringBuffer buffer=new StringBuffer();
            String line="";
            while((line=bis.readLine())!=null){
                buffer.append(line+"\n");
            }
            String txt=buffer.toString();
            exp.setText(txt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v2;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity= (DynamicActivity) context;
        methodname=activity.getDynamicTitle();
    }
}
