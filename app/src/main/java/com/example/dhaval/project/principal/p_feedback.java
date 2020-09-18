package com.example.dhaval.project.principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;
import com.example.dhaval.project.model.Complaint;
import com.example.dhaval.project.model.Feedback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class p_feedback extends AppCompatActivity {

    String str[]={"Teaching is so good","Teachers are very helpful","Overall the infrastructure is so good"};
    String stuid[]={"stu123","stu234","stu007"};
    private ListView ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_feedback);
        ls = (ListView)findViewById(R.id.list2);
       complaint adp = new complaint(this, R.layout.rawfeedback,str,stuid);
       ls.setAdapter(adp);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getList();
    }

    private void getList() {
        HashMap<String, String> param= jsn.getParamSelect("feedback","1");
        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                if (jsn.checkResponseStr(responseStr)){
                    List<Feedback> list = jsn.getAllClassFromString(responseStr, Feedback.class);
                    List<String> listDescription = getDetailStatus(list);
                    jsn.setListAdapter(p_feedback.this,ls,listDescription);
                }
            }
        });
    }

    private List<String> getDetailStatus(List<Feedback> list) {
        List<String> list1=new ArrayList<>();
        for (Feedback feedback : list) {
            list1.add(feedback.getDescription());
        }
        return list1;
    }

}
