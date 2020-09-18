package com.example.dhaval.project.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;
import com.example.dhaval.project.faculty.adapterleaveapprove;
import com.example.dhaval.project.faculty.leaveap;
import com.example.dhaval.project.model.Complaint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a_solvecomplaint extends AppCompatActivity {

    private RecyclerView rv;
    private RecyclerView.Adapter adp;
    private RecyclerView.LayoutManager lm;
    List<Complaint> list;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_solvecomplaint);

        ArrayList<compap> list = new ArrayList<>();
        list.add(new compap("For medical cehckup"));
        list.add(new compap("For merriege"));
        list.add(new compap("To going somewhere"));

        rv =(RecyclerView)findViewById(R.id.solvecomplaint);
        rv.setHasFixedSize(true);


        lm = new LinearLayoutManager(this);
        adp = new solvecomplaintadp(list);
        rv.setLayoutManager(lm);
        rv.setAdapter(adp);

        setComplaintList();

    }

    private void setComplaintList() {
        HashMap<String, String> param=new HashMap<>();
        param.put("type","select");
        param.put("table","complaint");

        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                if (jsn.checkResponseStr(responseStr)){
                    list = jsn.getAllClassFromString(responseStr, Complaint.class);
                    a_complaintListAdapter adapter = new a_complaintListAdapter(list);
                    rv.setLayoutManager(lm);
                    rv.setAdapter(adapter);
                }
            }
        });
    }
}
