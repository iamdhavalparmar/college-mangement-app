package com.example.dhaval.project.admin;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;
import com.example.dhaval.project.faculty.AttendanceListAdapter;
import com.example.dhaval.project.model.UserLogin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a_staffattendance extends AppCompatActivity {


    ArrayList<String> selectedit = new ArrayList<>();
    private static final String TAG = "a_staffattendance";
    private String[] items;
    private List<UserLogin> staffList;
    private AttendanceListAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_staffattendance);

        listView = (ListView)findViewById(R.id.staffatd);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        items = new String[]{"English","maths","science"};


//        showStudentList();


        oldAdapter();


    }

    private void oldAdapter() {
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,R.layout.raw_attendance,R.id.check, items);
        listView.setAdapter(adp);
        listView.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = ((TextView)view).getText().toString();
                if(selectedit.contains(selected)){
                    selectedit.remove(selected);
                    view.setBackgroundColor(Color.RED);
                }
                else {
                    selectedit.add(selected);
                    view.setBackgroundColor(Color.GREEN);
                }

                Log.e(TAG, "onItemClick: " + selectedit.toString());
            }
        });
    }

    public void saveResult(View view) {
        Toast.makeText(this, "Total "+items.length+" Selected "+selectedit.size(), Toast.LENGTH_SHORT).show();
        HashMap<String, String> param=new HashMap<>();
        param.put("type","save");
        param.put("table","attendance");
        param.put("roll_no","999");
        param.put("date","111");
        param.put("id","1");
        param.put("semester","1");
        param.put("lacture","staff");
        param.put("available",""+selectedit.size());
        param.put("total",""+items.length);

        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                if (jsn.checkResponseStr(responseStr)){
                    Toast.makeText(a_staffattendance.this, "Saved ... ", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(a_staffattendance.this, "Failed ... ", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void showStudentList() {
        staffList = new ArrayList<>();
        HashMap<String, String> param=new HashMap<>();
        param.put("type","select");
        param.put("table","user_login");
        param.put("where",getWhere());
        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                if (jsn.checkResponseStr(responseStr)){
                    staffList =jsn.getAllClassFromString(responseStr, UserLogin.class);
                }else {
                    staffList = new ArrayList<>();
                }

                setAdapter(staffList);
            }
        });
    }

    private void setAdapter(List<UserLogin> studentList) {
        adapter = new AttendanceListAdapter(this,R.layout.attendence_list_item,studentList);
        listView.setAdapter(adapter);
    }

    private String getWhere() {
        return "user_type = \'staff\'";
    }
}
