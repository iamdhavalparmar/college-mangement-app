package com.example.dhaval.project.admin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;
import com.example.dhaval.project.model.Complaint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a_complaint extends AppCompatActivity {

    String name[] = {"Dhaval","Aakash","Meet","Sachin","Jaydeep"};
    int no[]={3,4,1,5,56};
    String desc[]={"ssdgdfgdfgfdgdfg","gdfgergdfgdsfg","ewrgdfgdsfgs","trhdfgfgdfg","wggfgdfgdfg"};
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_complaint);

        lv = (ListView)findViewById(R.id.complist);

//        adp a = new adp(this,R.layout.rawcomplaint,name,no,desc);
//        lv.setAdapter(a);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getList();
    }

    private void getList() {
        HashMap<String, String> param= jsn.getParamSelect("complaint","1");
        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                if (jsn.checkResponseStr(responseStr)){
                    List<Complaint> list = jsn.getAllClassFromString(responseStr, Complaint.class);
                    List<String> listDescription = getDetailStatus(list);
                    jsn.setListAdapter(a_complaint.this,lv,listDescription);
                }
            }
        });
    }

    private List<String> getDetailStatus(List<Complaint> list) {
        List<String> list1=new ArrayList<>();
        for (Complaint complaint : list) {
            list1.add(complaint.getDescription());
        }
        return list1;
    }


}
