package com.example.dhaval.project.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;
import com.example.dhaval.project.faculty.f_floatingleave;
import com.example.dhaval.project.model.Leave;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class s_leave extends AppCompatActivity {

    ListView uploadleave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_leave);

        uploadleave= findViewById(R.id.uploadleave);
    }
    public void newaleave(View view) {
        Intent it = new Intent(this,f_floatingleave.class);
        it.putExtra("table","leave");
        startActivity(it);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getList();
    }

    private void getList() {
        HashMap<String, String> param= jsn.getParamSelect("leave",jsn.getWhereUserId());
        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                if (jsn.checkResponseStr(responseStr)){
                    List<Leave> list = jsn.getAllClassFromString(responseStr, Leave.class);
                    List<String> listDetails = getDetailDescription(list);
                    List<String> listStatus = getDetailStatus(list);
                    List<String> listId = getLeaveNo(list);
                    jsn.setListAdapter(s_leave.this,uploadleave,listDetails,listStatus,listId);
                }
            }
        });
    }

    private List<String> getLeaveNo(List<Leave> list) {
        List<String> list1=new ArrayList<>();
        for (Leave leave : list) {
            list1.add(leave.getUser_id());
        }
        return list1;
    }

    private List<String> getDetailStatus(List<Leave> list) {
        List<String> list1 = new ArrayList<>();
        for (Leave leave : list) {
            list1.add(leave.getStatus());
        }
        return list1;
    }

    private List<String> getDetailDescription(List<Leave> list) {
        List<String> list1=new ArrayList<>();
        for (Leave leave : list) {
            list1.add(leave.getDescription());
        }
        return list1;
    }
}
