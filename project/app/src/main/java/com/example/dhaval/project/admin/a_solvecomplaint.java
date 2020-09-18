package com.example.dhaval.project.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dhaval.project.R;
import com.example.dhaval.project.faculty.adapterleaveapprove;
import com.example.dhaval.project.faculty.leaveap;

import java.util.ArrayList;

public class a_solvecomplaint extends AppCompatActivity {

    private RecyclerView rv;
    private RecyclerView.Adapter adp;
    private RecyclerView.LayoutManager lm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
    }
}
