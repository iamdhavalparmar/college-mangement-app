package com.example.dhaval.project.student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.dhaval.project.MyParam;
import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;
import com.example.dhaval.project.model.Attendance;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class s_attendance extends AppCompatActivity {

    DatePicker datePicker;
    TextView attendanceTitle;
    ListView listView;
    ProgressBar progressBar;
    private String date;
    private String noAttendanceText = "No attendance available for this date";
    private String attendanceText = "Attendance for this date";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_attendance);

        listView = findViewById(R.id.listView);
        datePicker = findViewById(R.id.datePicker);
        attendanceTitle = findViewById(R.id.attendanceTitle);
        progressBar = findViewById(R.id.progressBar);


        Calendar cal = Calendar.getInstance();
        date = cal.get(Calendar.YEAR)+"/"  + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.DAY_OF_MONTH);
        setDataOfDate(date);

        cal.setTimeInMillis(System.currentTimeMillis());
        datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                date = dayOfMonth+"/"  +(month+1) + "/" + year ;
                setDataOfDate(date);
            }
        });
    }

    private static final String TAG = "s_attendance";
    private void setDataOfDate(String date) {
        progressBar.setVisibility(View.VISIBLE);
        attendanceTitle.setVisibility(View.GONE);
        listView.setVisibility(View.GONE);
        HashMap<String, String> param=new HashMap<>();
        param.put("type","select");
        param.put("table","attendance");
        param.put("where",getWhere());
        Log.e(TAG, "setDataOfDate: " + param.toString());
        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                Log.e(TAG, "setResponse: " + responseStr);
                if (jsn.checkResponseStr(responseStr)) {
                    attendanceTitle.setText(attendanceText);
                    listView.setVisibility(View.VISIBLE);
                    List<Attendance> list = jsn.getAllClassFromString(responseStr, Attendance.class);
                    setAdapter(list);
                }else {
                    attendanceTitle.setText(noAttendanceText);
                }
                progressBar.setVisibility(View.GONE);
                attendanceTitle.setVisibility(View.VISIBLE);

            }
        });
    }

    private void setAdapter(List<Attendance> list) {
        studentAttendanceAdapter adapter=new studentAttendanceAdapter(this,R.layout.student_attendance_list_item,list);
        listView.setAdapter(adapter);
    }

    private String getWhere() {
        return "roll_no="+ MyParam.userId+" and date=\'"+date+"\'";
    }
}
