package com.example.hello_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class medical_Info extends AppCompatActivity {
 private ArrayList barchartList;
 private BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_info);

        barChart=findViewById(R.id.barChartId);
        getData();
        BarDataSet barDataSet=new BarDataSet(barchartList,"weights");
        BarData barData=new BarData((IBarDataSet) barDataSet);
        barChart.setData(barData);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(12f);
        barChart.getDescription().setEnabled(true);
    }

    private void getData(){
        barchartList=new ArrayList();
        barchartList.add(new BarEntry(10,30));
        barchartList.add(new BarEntry(20,40));
        barchartList.add(new BarEntry(30,50));
        barchartList.add(new BarEntry(40,60));
        barchartList.add(new BarEntry(50,70));
    }

}