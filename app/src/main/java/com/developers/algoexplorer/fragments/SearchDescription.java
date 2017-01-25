package com.developers.algoexplorer.fragments;


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
import com.developers.algoexplorer.SearchingActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchDescription extends Fragment {

    private TextView searchdescription,bestcase,worstcase,averagecase,space;
    private DatabaseReference reference;
    private SearchingActivity searchingActivity;
    private String searchtitle,searchinfo;
    private ArrayList<String> searchinfoList=new ArrayList<String>();
    private ArrayList<String> bestcasecomplexities=new ArrayList<String>();
    private ArrayList<String> worstcasecomplexities=new ArrayList<String>();
    private ArrayList<String> avgcasecomplexities=new ArrayList<String>();
    private ArrayList<String> spacecomplexities=new ArrayList<>();
    public SearchDescription() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_search_description, container, false);
        searchdescription= (TextView) v.findViewById(R.id.searchdesc);
        bestcase= (TextView) v.findViewById(R.id.search_best);
        worstcase= (TextView) v.findViewById(R.id.search_worst);
        averagecase= (TextView) v.findViewById(R.id.search_average);
        space=(TextView)v.findViewById(R.id.search_space);
        bestcasecomplexities.add(0,"O(1)");
        bestcasecomplexities.add(1,"O(1)");
        worstcasecomplexities.add(0,"O(log n)");
        worstcasecomplexities.add(1,"O(n)");
        avgcasecomplexities.add(0,"O(log n)");
        avgcasecomplexities.add(1,"O(n)");
        spacecomplexities.add(0,"O(1)");
        spacecomplexities.add(1,"O(1) iterative");
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        reference=database.getReference("info_search");
        reference.keepSynced(true);
        if(isNetworkAvailable()){
            getSearchinginfo();
        }
        else{
            Toast.makeText(getActivity(),"Check your net connectivity",Toast.LENGTH_SHORT).show();
        }
        return v;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    private void getSearchinginfo() {
        final ProgressDialog progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data:dataSnapshot.getChildren()){
                    for(DataSnapshot in:data.child("info_search").getChildren()){
                        searchinfo=in.getValue().toString();
                        for(DataSnapshot d:in.getChildren()){
                            searchinfoList.add(d.getValue().toString());
                        }
                    }
                }
                switch (searchtitle){
                    case "Binary Search":
                        String info=searchinfoList.get(0);
                        searchdescription.setText(info);
                        bestcase.setText("Best Case: "+bestcasecomplexities.get(0));
                        worstcase.setText("Worst Case: "+worstcasecomplexities.get(0));
                        averagecase.setText("Average Case: "+avgcasecomplexities.get(0));
                        space.setText(""+spacecomplexities.get(0));
                        progressDialog.cancel();
                        break;
                    case "Linear Search":
                        String info1=searchinfoList.get(1);
                        searchdescription.setText(info1);
                        bestcase.setText("Best Case: "+bestcasecomplexities.get(1));
                        worstcase.setText("Worst Case: "+worstcasecomplexities.get(1));
                        averagecase.setText("Average Case: "+avgcasecomplexities.get(1));
                        space.setText(""+spacecomplexities.get(1));
                        progressDialog.cancel();
                        break;
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
               Log.e("SearchDescription","Error in Info "+databaseError.toException());
            }
        });


    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            searchingActivity = (SearchingActivity) context;
            searchtitle=searchingActivity.getSearchName();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
