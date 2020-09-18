package com.example.dhaval.project.principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dhaval.project.R;

import java.util.List;

public class p_feedback extends AppCompatActivity {

    String str[]={"Teaching is so good","Teachers are very helpfull","Overall the infrastructure is so good"};
    String stuid[]={"stu123","stu234","stu007"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_feedback);
        ListView ls = (ListView)findViewById(R.id.list2);
       complaint adp = new complaint(this, R.layout.rawfeedback,str,stuid);
       ls.setAdapter(adp);
    }

}
