package com.example.dhaval.project.student;


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dhaval.project.MyParam;
import com.example.dhaval.project.R;
import com.example.dhaval.project.admin.a_complaintListAdapter;
import com.example.dhaval.project.admin.a_floatingholiday;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;
import com.example.dhaval.project.model.Complaint;
import com.example.dhaval.project.model.HolidayList;

import java.util.HashMap;
import java.util.List;

public class s_holiday extends AppCompatActivity {



    List<HolidayList> list;
    private RecyclerView rv;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_holiday);
        fab=findViewById(R.id.fabholi);
        rv =(RecyclerView)findViewById(R.id.s_hdlv);


        if (MyParam.usertype.equals("admin")){
            fab.setVisibility(View.VISIBLE);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(s_holiday.this,a_floatingholiday.class);
                startActivity(it);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        setHolidayList();

    }

    private void setHolidayList() {
        HashMap<String, String> param=new HashMap<>();
        param.put("type","select");
        param.put("table","holiday_list");

        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                if (jsn.checkResponseStr(responseStr)){
                    list = jsn.getAllClassFromString(responseStr, HolidayList.class);
                    s_holidayListAdapter adapter = new s_holidayListAdapter(list);
                    rv.setAdapter(adapter);
                }
            }
        });
    }

}
