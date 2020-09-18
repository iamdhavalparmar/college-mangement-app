package com.example.dhaval.project.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.dhaval.project.MyParam;
import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;
import com.example.dhaval.project.model.Complaint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class s_complaint extends AppCompatActivity {

    String com[]={"dfgfdgffdsgfgf","adgdfsgfdgdfg","adfgdfsgdsfgfgfgfsdgdfg"};
    int[] no ={12,13,14};
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_complaint);

        lv = (ListView)findViewById(R.id.s_comp);

    }

    @Override
    protected void onResume() {
        super.onResume();
        getList();

    }

    private void getList() {
        HashMap<String, String> param= jsn.getParamSelect("complaint",jsn.getWhereUserId());
        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                if (jsn.checkResponseStr(responseStr)){
                    List<Complaint> list = jsn.getAllClassFromString(responseStr, Complaint.class);
                    List<String> listDetails = getDetail(list);
                    List<String> listId = getListId(list);
                    jsn.setListAdapter(s_complaint.this,lv,listDetails,listId);
                }
            }
        });
    }

    private List<String> getListId(List<Complaint> list) {
        List<String> list1=new ArrayList<>();
        for (Complaint complaint : list) {
            list1.add(complaint.getUser_id());
        }
        return list1;
    }

    private List<String> getDetail(List<Complaint> list) {
        List<String> list1 = new ArrayList<>();
        for (Complaint complaint : list) {
            list1.add(complaint.getDescription());
        }
        return list1;
    }




    public void newcomplaint(View view) {
        Intent it = new Intent(this,s_floatingcomplaint.class);
        it.putExtra("table","complaint");
        startActivity(it);
    }
}
