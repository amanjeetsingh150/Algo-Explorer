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
 * Created by Amanjeet Singh on 08-Jan-17.
 */
public class CustomListSortingAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> arrayList;

    public CustomListSortingAdapter(Context context, ArrayList arrayList){
       this.context=context;
        this.arrayList=arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=mInflater.inflate(R.layout.list_sort_row,null);
        TextView s=(TextView)convertView.findViewById(R.id.sort);
        ImageView sortimg=(ImageView)convertView.findViewById(R.id.sortimage);
        String name=arrayList.get(position);
        switch (name){
            case "Bubble Sort":
                sortimg.setImageResource(R.drawable.bubblesort_list);
                s.setText("Bubble Sort");
                break;
            case "Merge Sort":
                sortimg.setImageResource(R.drawable.mergesort_list);
                s.setText("Merge Sort");
                break;
            case "Insertion Sort":
                sortimg.setImageResource(R.drawable.insertionsort_list);
                s.setText("Insertion Sort");
                break;
            case "Heap Sort":
                sortimg.setImageResource(R.drawable.heapsort_list);
                s.setText("Heap Sort");
                break;
            case "Selection Sort":
                sortimg.setImageResource(R.drawable.selectionsort_list);
                s.setText("Selection Sort");
                break;
            case "Quick Sort":
                sortimg.setImageResource(R.drawable.quicksort_list);
                s.setText("Quick Sort");
        }
        return convertView;
    }
}
