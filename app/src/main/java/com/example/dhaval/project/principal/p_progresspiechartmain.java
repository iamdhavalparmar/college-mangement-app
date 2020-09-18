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

public class p_progresspiechartmain extends AppCompatActivity {

    int data[];
    String name[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_progresspiechartmain);

        PieChart chart  = (PieChart)findViewById(R.id.mainprogress);

        if(getIntent().getStringExtra("first") != null && getIntent().getStringExtra("subject").equals("ADVANCE C")){
            data = new int[] {18,2};
            name = new String[] {"Completed","Remaining"};
                List<PieEntry> pie1 = new ArrayList<>();
                for(int i=0; i<data.length; i++){
                    pie1.add(new PieEntry(data[i],name[i]));
                }

                PieDataSet dataSet = new PieDataSet((List<PieEntry>) pie1,"Syllabus Progress");
                dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                PieData data = new PieData(dataSet);
                data.setValueTextSize(20);
                chart.setData(data);
                chart.invalidate();
        }
        else if(getIntent().getStringExtra("first") != null && getIntent().getStringExtra("subject").equals("DHTML")){
            data = new int[] {16,4};
            name = new String[] {"Completed","Remaining"};
            List<PieEntry> pie1 = new ArrayList<>();
            for(int i=0; i<data.length; i++){
                pie1.add(new PieEntry(data[i],name[i]));
            }

            PieDataSet dataSet = new PieDataSet((List<PieEntry>) pie1,"Syllabus Progress");
            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            PieData data = new PieData(dataSet);
            data.setValueTextSize(20);
            chart.setData(data);
            chart.invalidate();
        }
        else if(getIntent().getStringExtra("first") != null && getIntent().getStringExtra("subject").equals("MATHS")){
            data = new int[] {10,10};
            name = new String[] {"Completed","Remaining"};
            List<PieEntry> pie1 = new ArrayList<>();
            for(int i=0; i<data.length; i++){
                pie1.add(new PieEntry(data[i],name[i]));
            }

            PieDataSet dataSet = new PieDataSet((List<PieEntry>) pie1,"Syllabus Progress");
            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            PieData data = new PieData(dataSet);
            data.setValueTextSize(20);
            chart.setData(data);
            chart.invalidate();
        }
        else if(getIntent().getStringExtra("first") != null && getIntent().getStringExtra("subject").equals("DBMS")){
            data = new int[] {12,8};
            name = new String[] {"Completed","Remaining"};
            List<PieEntry> pie1 = new ArrayList<>();
            for(int i=0; i<data.length; i++){
                pie1.add(new PieEntry(data[i],name[i]));
            }

            PieDataSet dataSet = new PieDataSet((List<PieEntry>) pie1,"Syllabus Progress");
            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            PieData data = new PieData(dataSet);
            data.setValueTextSize(20);
            chart.setData(data);
            chart.invalidate();
        }
        else if(getIntent().getStringExtra("second") != null && getIntent().getStringExtra("subject").equals("DBMS2")){
            data = new int[] {9,11};
            name = new String[] {"Completed","Remaining"};
            List<PieEntry> pie1 = new ArrayList<>();
            for(int i=0; i<data.length; i++){
                pie1.add(new PieEntry(data[i],name[i]));
            }

            PieDataSet dataSet = new PieDataSet((List<PieEntry>) pie1,"Syllabus Progress");
            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            PieData data = new PieData(dataSet);
            data.setValueTextSize(20);
            chart.setData(data);
            chart.invalidate();
        }
        else if(getIntent().getStringExtra("second") != null && getIntent().getStringExtra("subject").equals("JAVA")){
            data = new int[] {5,15};
            name = new String[] {"Completed","Remaining"};
            List<PieEntry> pie1 = new ArrayList<>();
            for(int i=0; i<data.length; i++){
                pie1.add(new PieEntry(data[i],name[i]));
            }

            PieDataSet dataSet = new PieDataSet((List<PieEntry>) pie1,"Syllabus Progress");
            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            PieData data = new PieData(dataSet);
            data.setValueTextSize(20);
            chart.setData(data);
            chart.invalidate();
        }
        else if(getIntent().getStringExtra("second") != null && getIntent().getStringExtra("subject").equals("VB.NET")){
            data = new int[] {11,9};
            name = new String[] {"Completed","Remaining"};
            List<PieEntry> pie1 = new ArrayList<>();
            for(int i=0; i<data.length; i++){
                pie1.add(new PieEntry(data[i],name[i]));
            }

            PieDataSet dataSet = new PieDataSet((List<PieEntry>) pie1,"Syllabus Progress");
            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            PieData data = new PieData(dataSet);
            data.setValueTextSize(20);
            chart.setData(data);
            chart.invalidate();
        }
        else if(getIntent().getStringExtra("second") != null && getIntent().getStringExtra("subject").equals("OOAD")){
            data = new int[] {19,1};
            name = new String[] {"Completed","Remaining"};
            List<PieEntry> pie1 = new ArrayList<>();
            for(int i=0; i<data.length; i++){
                pie1.add(new PieEntry(data[i],name[i]));
            }

            PieDataSet dataSet = new PieDataSet((List<PieEntry>) pie1,"Syllabus Progress");
            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            PieData data = new PieData(dataSet);
            data.setValueTextSize(20);
            chart.setData(data);
            chart.invalidate();
        }
        else if(getIntent().getStringExtra("third") != null && getIntent().getStringExtra("subject").equals("ASP.NET")){
            data = new int[] {4,16};
            name = new String[] {"Completed","Remaining"};
            List<PieEntry> pie1 = new ArrayList<>();
            for(int i=0; i<data.length; i++){
                pie1.add(new PieEntry(data[i],name[i]));
            }

            PieDataSet dataSet = new PieDataSet((List<PieEntry>) pie1,"Syllabus Progress");
            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            PieData data = new PieData(dataSet);
            data.setValueTextSize(20);
            chart.setData(data);
            chart.invalidate();
        }
        else if(getIntent().getStringExtra("third") != null && getIntent().getStringExtra("subject").equals("DBA")){
            data = new int[] {2,18};
            name = new String[] {"Completed","Remaining"};
            List<PieEntry> pie1 = new ArrayList<>();
            for(int i=0; i<data.length; i++){
                pie1.add(new PieEntry(data[i],name[i]));
            }

            PieDataSet dataSet = new PieDataSet((List<PieEntry>) pie1,"Syllabus Progress");
            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            PieData data = new PieData(dataSet);
            data.setValueTextSize(20);
            chart.setData(data);
            chart.invalidate();
        }
        else if(getIntent().getStringExtra("third") != null && getIntent().getStringExtra("subject").equals("MULTIMEDIA")){
            data = new int[] {20,0};
            name = new String[] {"Completed","Remaining"};
            List<PieEntry> pie1 = new ArrayList<>();
            for(int i=0; i<data.length; i++){
                pie1.add(new PieEntry(data[i],name[i]));
            }

            PieDataSet dataSet = new PieDataSet((List<PieEntry>) pie1,"Syllabus Progress");
            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            PieData data = new PieData(dataSet);
            data.setValueTextSize(20);
            chart.setData(data);
            chart.invalidate();
        }
        else if(getIntent().getStringExtra("third") != null && getIntent().getStringExtra("subject").equals("PROJECT")){
            data = new int[] {6,14};
            name = new String[] {"Completed","Remaining"};
            List<PieEntry> pie1 = new ArrayList<>();
            for(int i=0; i<data.length; i++){
                pie1.add(new PieEntry(data[i],name[i]));
            }

            PieDataSet dataSet = new PieDataSet((List<PieEntry>) pie1,"Syllabus Progress");
            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            PieData data = new PieData(dataSet);
            data.setValueTextSize(20);
            chart.setData(data);
            chart.invalidate();
        }

    }


}
