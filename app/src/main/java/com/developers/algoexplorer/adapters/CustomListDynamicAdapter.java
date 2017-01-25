package com.developers.algoexplorer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.developers.algoexplorer.R;

import java.util.ArrayList;

/**
 * Created by Amanjeet Singh on 17-Jan-17.
 */

public class CustomListDynamicAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> dynamicpro;

    public CustomListDynamicAdapter(Context context,ArrayList<String> dynamicpro){
        this.context=context;
        this.dynamicpro=dynamicpro;
    }

    @Override
    public int getCount() {
        return dynamicpro.size();
    }

    @Override
    public Object getItem(int i) {
        return dynamicpro.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater mInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=mInflater.inflate(R.layout.list_dynamic_row,null);
        ImageView img= (ImageView) view.findViewById(R.id.dynamicimg);
        TextView dynamicname=(TextView)view.findViewById(R.id.dynamic);
        String d=dynamicpro.get(i);
        switch (d){
            case "0-1 Knapsack":
                img.setImageResource(R.drawable.knapsack_list);
                dynamicname.setText("0-1 Knapsack");
                break;
            case "Binomial Coefficient":
                img.setImageResource(R.drawable.binomial_list);
                dynamicname.setText("Binomial Coefficient");
                break;
            case "Longest Common Subsequence":
                img.setImageResource(R.drawable.longest_list);
                dynamicname.setText("Longest Common Subsequence");
                break;
            case "Matrix Chain Multiplication":
                img.setImageResource(R.drawable.mcm_list);
                dynamicname.setText("Matrix Chain Multiplication");
                break;
        }
        return view;
    }
}
