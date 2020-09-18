package com.example.dhaval.project.principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;
import com.example.dhaval.project.model.Progress;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PieChartActivity extends AppCompatActivity {

    private String subject;
    private PieChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        chart = (PieChart)findViewById(R.id.mainprogress);

        subject = getIntent().getStringExtra("subject").toLowerCase();

        getProgress(subject);
    }

    private static final String TAG = "PieChartActivity";
    private void getProgress(String subject) {
        HashMap<String, String> param = new HashMap<>();
        param.put("type","select");
        param.put("table","progress");
        param.put("where","subject=\'"+subject+"\'");
        Log.e(TAG, "getProgress: " + param.toString());
        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                Log.e(TAG, "setResponse: " + responseStr);
                if (jsn.checkResponseStr(responseStr)){
                    Progress progress = (Progress) jsn.getSingleObjectFromString(responseStr, Progress.class);
                    setPieChart(progress);
                }
            }
        });
    }

    private void setPieChart(Progress progress) {
        List<PieEntry> pieEntryList=new ArrayList<>();
        String progressValue = progress.getProgress();
        float progressValueFloat = Float.parseFloat(progressValue);
        float remainingValueFloat = 100-progressValueFloat;
        pieEntryList.add(new PieEntry(progressValueFloat,"Completed"));
        pieEntryList.add(new PieEntry(remainingValueFloat,"Remaining"));

        PieDataSet dataSet = new PieDataSet((List<PieEntry>) pieEntryList,"Syllabus Progress");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data = new PieData(dataSet);
        data.setValueTextSize(20);
        chart.setData(data);
        chart.invalidate();
    }
}


