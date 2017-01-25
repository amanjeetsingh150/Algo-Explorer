package com.developers.algoexplorer.fragments;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.developers.algoexplorer.R;
import com.developers.algoexplorer.SortingActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * A simple {@link Fragment} subclass.
 */
public class Description extends Fragment{
    private DatabaseReference infoRef;
    private String info,title;
    private TextView description,best,average,worst,spac;
    private static final String TAG="Description";
    public static final String DESC="title";
    private ArrayList<String> infoList=new ArrayList<String>();
    SortingActivity sortingActivity;
    private ArrayList<String> bestcomplexitylist=new ArrayList<>();
    private ArrayList<String> averagecomplexities=new ArrayList<>();
    private ArrayList<String> worstcomplexities=new ArrayList<>();
    private ArrayList<String> spacecomplexities=new ArrayList<>();

    public Description() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_description, container, false);
        Log.d(TAG,"onCreateView");
        description=(TextView)v.findViewById(R.id.desc);
        best=(TextView)v.findViewById(R.id.bestcase);
        worst=(TextView)v.findViewById(R.id.worstcase);
        average=(TextView)v.findViewById(R.id.averagecase);
        spac=(TextView)v.findViewById(R.id.space);
        bestcomplexitylist.add(0,"Ω(n)");
        bestcomplexitylist.add(1,"Ω(n log(n))");
        bestcomplexitylist.add(2,"Ω(n)");
        bestcomplexitylist.add(3,"Ω(n log(n))");
        bestcomplexitylist.add(4,"Ω(n log(n))");
        bestcomplexitylist.add(5,"Ω(n^2)");
        averagecomplexities.add(0,"Θ(n^2)");
        averagecomplexities.add(1,"Θ(n log(n))");
        averagecomplexities.add(2,"Θ(n^2)");
        averagecomplexities.add(3,"Θ(n log(n))");
        averagecomplexities.add(4,"Θ(n log(n))");
        averagecomplexities.add(5,"Θ(n^2)");
        worstcomplexities.add(0,"O(n^2)");
        worstcomplexities.add(1,"O(n log(n))");
        worstcomplexities.add(2,"O(n^2)");
        worstcomplexities.add(3,"O(n^2)");
        worstcomplexities.add(4,"O(n log(n))");
        worstcomplexities.add(5,"O(n^2)");
        spacecomplexities.add(0,"O(1)");
        spacecomplexities.add(1,"O(n)");
        spacecomplexities.add(2,"O(1)");
        spacecomplexities.add(3,"O(log(n))");
        spacecomplexities.add(4,"O(1)");
        spacecomplexities.add(5,"O(1)");
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        infoRef=database.getReference("info");
        infoRef.keepSynced(true);
        if(isNetworkAvailable()){
            getInfoSorting();
        }
        else{
            Toast.makeText(getActivity(),"Check your net connectivity",Toast.LENGTH_SHORT).show();
        }
        return v;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            sortingActivity= (SortingActivity) context;
            title=sortingActivity.gettitle();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    private void getInfoSorting() {
        final ProgressDialog progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading.....");
        progressDialog.show();
        infoRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    for(DataSnapshot in:child.child("info").getChildren()){
                        info = in.getValue().toString();
                        for(DataSnapshot inf:in.getChildren()){
                            infoList.add(inf.getValue().toString());
                        }
                    }
                }
                switch(title){
                    case "Bubble Sort":
                        String inf=infoList.get(0);
                        description.setText(inf);
                        best.setText("Best case: "+bestcomplexitylist.get(0));
                        average.setText("Average case: "+averagecomplexities.get(0));
                        worst.setText("Worst case: "+worstcomplexities.get(0));
                        spac.setText(""+spacecomplexities.get(0));
                        progressDialog.cancel();
                        break;
                    case "Merge Sort":
                        String inf1=infoList.get(3);
                        description.setText(inf1);
                        best.setText("Best case: "+bestcomplexitylist.get(1));
                        average.setText("Average case: "+averagecomplexities.get(1));
                        worst.setText("Worst case: "+worstcomplexities.get(1));
                        spac.setText(""+spacecomplexities.get(1));
                        progressDialog.cancel();
                        break;
                    case "Insertion Sort":
                        String inf2=infoList.get(5);
                        description.setText(inf2);
                        best.setText("Best case: "+bestcomplexitylist.get(2));
                        average.setText("Average case: "+averagecomplexities.get(2));
                        worst.setText("Worst case: "+worstcomplexities.get(2));
                        spac.setText(""+spacecomplexities.get(2));
                        progressDialog.cancel();
                        break;
                    case "Quick Sort":
                        String inf3=infoList.get(2);
                        description.setText(inf3);
                        best.setText("Best case: "+bestcomplexitylist.get(3));
                        average.setText("Average case: "+averagecomplexities.get(3));
                        worst.setText("Worst case: "+worstcomplexities.get(3));
                        spac.setText(""+spacecomplexities.get(3));
                        progressDialog.cancel();
                        break;
                    case "Heap Sort":
                        String inf4=infoList.get(1);
                        description.setText(inf4);
                        best.setText("Best case: "+bestcomplexitylist.get(4));
                        average.setText("Average case: "+averagecomplexities.get(4));
                        worst.setText("Worst case: "+worstcomplexities.get(4));
                        spac.setText(""+spacecomplexities.get(4));
                        progressDialog.cancel();
                        break;
                    case "Selection Sort":
                        String inf5=infoList.get(4);
                        description.setText(inf5);
                        best.setText("Best case: "+bestcomplexitylist.get(5));
                        average.setText("Average case: "+averagecomplexities.get(5));
                        worst.setText("Worst case: "+worstcomplexities.get(5));
                        spac.setText(""+spacecomplexities.get(5));
                        progressDialog.cancel();
                        break;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG,"Error in Info "+databaseError.toException());
            }
        });
    }
}
