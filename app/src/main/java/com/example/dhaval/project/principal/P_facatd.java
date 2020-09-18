package com.example.dhaval.project.principal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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

public class P_facatd extends AppCompatActivity {

    int[] data = {18, 3};
    String[] name = {"Present", "Absent"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_facatd);

//        setupPiechar();

        getData();
    }

    private void getData() {

        HashMap<String, String> param = new HashMap<>();
        param.put("type", "getFacultyAttendance");

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
                    PieChart chart = (PieChart) findViewById(R.id.facatd);
                    data.setValueTextSize(20);
                    chart.setData(data);
                    chart.invalidate();
                }
            }
        });

    }

    private void setupPiechar() {

        List<PieEntry> pie1 = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            pie1.add(new PieEntry(data[i], name[i]));
        }

        PieDataSet dataSet = new PieDataSet((List<PieEntry>) pie1, "Attendnacne");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data = new PieData(dataSet);
        PieChart chart = (PieChart) findViewById(R.id.facatd);
        data.setValueTextSize(20);
        chart.setData(data);
        chart.invalidate();
    }


}
