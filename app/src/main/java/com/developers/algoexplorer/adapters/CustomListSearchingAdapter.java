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
 * Created by Amanjeet Singh on 16-Jan-17.
 */

public class CustomListSearchingAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> mlist;
    public CustomListSearchingAdapter(Context context,ArrayList<String> mlist){
        this.context=context;
        this.mlist=mlist;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int i) {
        return mlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=layoutInflater.inflate(R.layout.list_search_row,null);
        ImageView img= (ImageView) view.findViewById(R.id.searchimg);
        TextView searchname=(TextView)view.findViewById(R.id.search);
        String se=mlist.get(i);
        switch(se){
            case "Linear Search":
                img.setImageResource(R.drawable.linearsearch_list);
                searchname.setText("Linear Search");
                break;
            case "Binary Search":
                img.setImageResource(R.drawable.binarysearch_list);
                searchname.setText("Binary Search");
                break;
        }
        return view;
    }
}
