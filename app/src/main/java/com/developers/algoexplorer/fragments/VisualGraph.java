package com.developers.algoexplorer.fragments;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.db.chart.Tools;
import com.db.chart.model.LineSet;
import com.db.chart.renderer.AxisRenderer;
import com.db.chart.view.LineChartView;
import com.developers.algoexplorer.MainActivity;
import com.developers.algoexplorer.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

/**
 * A simple {@link Fragment} subclass.
 */
public class VisualGraph extends Fragment {


    public VisualGraph() {
        // Required empty public constructor
    }

    private LineSet ngraph,nsqgraph,nlograph,lograph;
    private Paint paint1,paint2,paint3,paint4;
    private LineChartView lineChartView;
    private TextView graphdetail;
    private AdView adView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v3= inflater.inflate(R.layout.fragment_visual_graph, container, false);
        lineChartView= (LineChartView) v3.findViewById(R.id.linechart);
        graphdetail= (TextView) v3.findViewById(R.id.graphdetail);
        adView= (AdView) v3.findViewById(R.id.adView);
        MobileAds.initialize(getActivity(),
                "ca-app-pub-3940256099942544~3347511713");
        AdRequest request = new AdRequest.Builder()
                .addTestDevice("CFF347E1F13269C9C8B2BFEAD3E6C7EC")
                .build();
        adView.loadAd(request);
        ngraph=new LineSet();
        nsqgraph=new LineSet();
        nlograph=new LineSet();
        lograph=new LineSet();
        paint1=new Paint();
        paint2=new Paint();
        paint3=new Paint();
        paint4=new Paint();
        for(int i=0;i<500;i++){
         ngraph.addPoint("",i);
        }
        for(int j=0;j<500;j++){
            nsqgraph.addPoint("",(j*j));
        }
        for(float k=0;k<500;k++){
            if(k==0) {
               nlograph.addPoint("",0);
            }
            else {
                nlograph.addPoint("", (float) (k * Math.log(k)));
            }
        }
        for(float p=0;p<500;p++){
            if(p==0) {
                lograph.addPoint("",0);
            }
            else {
                lograph.addPoint("", (float) (Math.log(p)));
            }
        }
        paint1.setColor(Color.BLACK);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setAntiAlias(true);
        paint1.setStrokeWidth(Tools.fromDpToPx(1f));

        paint2.setColor(Color.BLACK);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(Tools.fromDpToPx(1f));

        paint3.setColor(Color.BLACK);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setAntiAlias(true);
        paint3.setStrokeWidth(Tools.fromDpToPx(1f));

        lineChartView.setBorderSpacing(1)
                .setAxisBorderValues(0, 1000)
                .setXLabels(AxisRenderer.LabelPosition.OUTSIDE)
                .setYLabels(AxisRenderer.LabelPosition.OUTSIDE)
                .setLabelsColor(Color.BLUE)
                .setXAxis(false)
                .setYAxis(false)
                .setBorderSpacing(Tools.fromDpToPx(5)).setGrid(5,0,paint1);

        if(ngraph.size()>0){
            lineChartView.addData(ngraph);
            lineChartView.addData(nsqgraph);
            lineChartView.addData(nlograph);
            lineChartView.addData(lograph);
            lineChartView.show();
        }
        String des=getResources().getString(R.string.visual_disc);
        graphdetail.setText(des);
        return v3;
    }


}
