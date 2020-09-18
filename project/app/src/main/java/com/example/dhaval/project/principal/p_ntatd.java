package com.example.dhaval.project.principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dhaval.project.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class p_ntatd extends AppCompatActivity {

    int[] data = {15,9};
    String[] name = {"Present","Absent"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_ntatd);
        setupPiechar();
    }

    private void setupPiechar() {

            List<PieEntry> pie1 = new ArrayList<>();
            for(int i=0; i<data.length; i++){
                pie1.add(new PieEntry(data[i],name[i]));
            }

            PieDataSet dataSet = new PieDataSet((List<PieEntry>) pie1,"Attendnacne");
            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            PieData data = new PieData(dataSet);
            PieChart chart  = (PieChart)findViewById(R.id.ntatd);
            chart.setData(data);
            data.setValueTextSize(20);
            chart.invalidate();

    }

}
