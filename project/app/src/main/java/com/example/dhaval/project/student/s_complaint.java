package com.example.dhaval.project.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.dhaval.project.R;

import java.util.List;

public class s_complaint extends AppCompatActivity {

    String com[]={"dfgfdgffdsgfgf","adgdfsgfdgdfg","adfgdfsgdsfgfgfgfsdgdfg"};
    int[] no ={12,13,14};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_complaint);

        ListView lv = (ListView)findViewById(R.id.s_comp);
        complaintadp adp =new complaintadp(this,R.layout.sturawcomplaint,com,no);
        lv.setAdapter(adp);

    }

    public void newcomplaint(View view) {
        Intent it = new Intent(this,s_floatingcomplaint.class);
        startActivity(it);
    }
}
