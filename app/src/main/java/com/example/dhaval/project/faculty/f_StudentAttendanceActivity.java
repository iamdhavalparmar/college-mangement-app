package com.example.dhaval.project.faculty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;
import com.example.dhaval.project.model.AttendenceCheck;
import com.example.dhaval.project.model.UserLogin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class f_StudentAttendanceActivity extends AppCompatActivity {

    Spinner spinner;
    EditText subjectName;
    ListView listView;
    Button saveButton;
    private List<String> spinnerList;
    private List<UserLogin> studentList;
    private String selectedSemester;
    private AttendanceListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f__student_attrndence);

        listView = findViewById(R.id.listView);
        saveButton = findViewById(R.id.saveButton);
        subjectName = findViewById(R.id.subjectName);
        spinner = findViewById(R.id.spinner);

        setSpinner();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedSemester = spinnerList.get(position);
                showStudentList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAttendance();
            }
        });



    }

    private static final String TAG = "f_StudentAttrndenceActi";
    private void saveAttendance() {
        List<AttendenceCheck> list = adapter.attendenceList;
        HashMap<String, String> param = getParamList(list);
        param.put("type","saveArray");
        param.put("table","attendance");
        param.put("date",getTodayDate());
        param.put("lacture",subjectName.getText().toString());
        param.put("semester",selectedSemester);
        Log.e(TAG, "saveAttendance: " + param.toString());
        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                Toast.makeText(f_StudentAttendanceActivity.this, "Saved ... ", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private String getTodayDate() {
        Calendar calendar = Calendar.getInstance();
        return
                calendar.get(Calendar.DAY_OF_MONTH) + "/"+
                        (calendar.get(Calendar.MONTH)+1) + "/"+
                calendar.get(Calendar.YEAR) ;
    }

    private HashMap<String, String> getParamList(List<AttendenceCheck> list) {
        HashMap<String,String> param=new HashMap<>();
        int i=0;
        for (AttendenceCheck attendence : list) {
            param.put("roll_no["+ i +"]",attendence.getUserId());
            param.put("present["+ i +"]",getBit(attendence.isChecked()));
            i++;
        }
        return param;
    }

    private String getBit(boolean checked) {
        if (checked) return "1";
        else return "0";
    }

    private void showStudentList() {
        studentList = new ArrayList<>();
        HashMap<String, String> param=new HashMap<>();
        param.put("type","select");
        param.put("table","user_login");
        param.put("where",getWhere());
        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                if (jsn.checkResponseStr(responseStr)){
                    studentList=jsn.getAllClassFromString(responseStr, UserLogin.class);
                }else {
                    studentList = new ArrayList<>();
                }

                setAdapter(studentList);
            }
        });
    }

    private void setAdapter(List<UserLogin> studentList) {
        adapter = new AttendanceListAdapter(this,R.layout.attendence_list_item,studentList);
        listView.setAdapter(adapter);
    }

    private String getWhere() {
        return "semester = "+selectedSemester;
    }


    private void setSpinner() {
        spinnerList = new ArrayList<>();
        spinnerList.add("1");
        spinnerList.add("3");
        spinnerList.add("5");
        spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, spinnerList));
    }
}
