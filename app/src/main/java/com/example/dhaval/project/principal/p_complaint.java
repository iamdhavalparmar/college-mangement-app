package com.example.dhaval.project.principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;
import com.example.dhaval.project.faculty.f_leave;
import com.example.dhaval.project.model.Complaint;
import com.example.dhaval.project.model.Leave;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class p_complaint extends AppCompatActivity {

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
                    jsn.setListAdapter(p_complaint.this,lv,listDescription);
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
