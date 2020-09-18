package com.example.dhaval.project.principal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;
import com.example.dhaval.project.faculty.adapterleaveapprove;
import com.example.dhaval.project.faculty.f_leaveapproveList;
import com.example.dhaval.project.faculty.leaveap;
import com.example.dhaval.project.model.Leave;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class p_approveleave extends AppCompatActivity {

    private RecyclerView rv;
    private RecyclerView.Adapter adp;
    private RecyclerView.LayoutManager lm;
    List<Leave> list;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_approveleave);
        ArrayList<leaveap> list = new ArrayList<>();
        list.add(new leaveap("For medical cheakup"));
        list.add(new leaveap("marriage"));
        list.add(new leaveap("To going for trip"));

        rv =(RecyclerView)findViewById(R.id.rvapprove);
        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(this);
        adp = new adapterleaveapprove(list);
        rv.setLayoutManager(lm);
        rv.setAdapter(adp);
        setleaveapprove();

    }


    private void setleaveapprove() {
            HashMap<String, String> param=new HashMap<>();
            param.put("type","select");
            param.put("table","leave");
            param.put("where",getWhere());


            NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
                @Override
                public void setResponse(String responseStr) {
                    if (jsn.checkResponseStr(responseStr)){
                        list = jsn.getAllClassFromString(responseStr, Leave.class);
                        f_leaveapproveList adapter = new f_leaveapproveList(list);
                        rv.setLayoutManager(lm);
                        rv.setAdapter(adapter);
                    }
                }
            });
        }

    private String getWhere() {
        return "user_type=\'faculty\'";
    }
}
