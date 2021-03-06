package com.example.dhaval.project.principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;
import com.example.dhaval.project.model.Attendance;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class p_ntatd extends AppCompatActivity {

    int[] data = {15,9};
    String[] name = {"Present","Absent"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_ntatd);

//        setupPiechar();

        getData();
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

    private void getData() {

        HashMap<String, String> param = new HashMap<>();
        param.put("type", "select");
        param.put("table", Attendance.getTableName());
        param.put("where", "id=1");

        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                if (jsn.checkResponseStr(responseStr)) {
                    Attendance attendance = (Attendance) jsn.getSingleObjectFromString(responseStr, Attendance.class);

                    int total = Integer.parseInt(attendance.getTotal());
                    int present = Integer.parseInt(attendance.getAvailable());

                    List<PieEntry> pieEntries = new ArrayList<>();
                    pieEntries.add(new PieEntry(total - present, "Absent"));
                    pieEntries.add(new PieEntry(present, "Present"));

                    PieDataSet dataSet = new PieDataSet(pieEntries, "Attendnacne");
                    dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                    PieData data = new PieData(dataSet);
                    PieChart chart = (PieChart) findViewById(R.id.ntatd);
                    data.setValueTextSize(20);
                    chart.setData(data);
                    chart.invalidate();
                }
            }
        });

    }
}
