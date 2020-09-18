package com.example.dhaval.project.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;
import com.example.dhaval.project.model.Complaint;
import com.example.dhaval.project.model.Feedback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class s_feedback extends AppCompatActivity {

    String com[] = {"dfgfdgffdsgfgf", "adgdfsgfdgdfg", "adfgdfsgdsfgfgfgfsdgdfg"};
    int[] no = {12, 13, 14};
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_feedback);
        lv = (ListView) findViewById(R.id.feedlist1);
//        complaintadp adp = new complaintadp(this, R.layout.sturawcomplaint, com, no);
//        lv.setAdapter(adp);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getList();
    }

    private void getList() {
        HashMap<String, String> param= jsn.getParamSelect("feedback",jsn.getWhereUserId());
        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                if (jsn.checkResponseStr(responseStr)){
                    List<Feedback> list = jsn.getAllClassFromString(responseStr, Feedback.class);
                    List<String> listDetails = getDetail(list);
                    List<String> listId = getListId(list);
                    jsn.setListAdapter(s_feedback.this,lv,listDetails,listId);
                }
            }
        });
    }

    private List<String> getListId(List<Feedback> list) {
        List<String> list1=new ArrayList<>();
        for (Feedback feedback : list) {
            list1.add(feedback.getUser_id());
        }
        return list1;
    }

    private List<String> getDetail(List<Feedback> list) {
        List<String> list1 = new ArrayList<>();
        for (Feedback feedback : list) {
            list1.add(feedback.getDescription());
        }
        return list1;
    }


    public void newfeedback(View view) {
        Intent it = new Intent(this, s_floatingcomplaint.class);
        it.putExtra("table", "feedback");
        startActivity(it);
    }
}