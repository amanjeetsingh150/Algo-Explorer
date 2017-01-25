package com.developers.algoexplorer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.developers.algoexplorer.R;

import java.util.ArrayList;

/**
 * Created by Amanjeet Singh on 23-Jan-17.
 */

public class CustomListGraphAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> graphlist;

    public CustomListGraphAdapter(Context context, ArrayList<String> graphlist){
        this.context=context;
        this.graphlist=graphlist;
    }

    @Override
    public int getCount() {
        return graphlist.size();
    }

    @Override
    public Object getItem(int i) {
        return graphlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(R.layout.list_graph_row,null);
        ImageView img= (ImageView) view.findViewById(R.id.graphimg);
        TextView graphname=(TextView)view.findViewById(R.id.graph);
        String gr=graphlist.get(i);
        switch(gr){
            case "Floyd–Warshall algorithm":
                img.setImageResource(R.drawable.floyd_list);
                graphname.setText("Floyd–Warshall algorithm");
                break;
            case "Dijkstra's algorithm":
                Glide.with(context).load(R.drawable.dijkstra_list).into(new GlideDrawableImageViewTarget(img));
                graphname.setText("Dijkstra's algorithm");
                break;
        }
        return view;
    }
}
