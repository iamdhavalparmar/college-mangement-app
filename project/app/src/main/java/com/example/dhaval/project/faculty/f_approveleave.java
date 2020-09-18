package com.example.dhaval.project.faculty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dhaval.project.R;
import com.example.dhaval.project.principal.adapterleave;
import com.example.dhaval.project.principal.leave;

import java.util.ArrayList;

public class f_approveleave extends AppCompatActivity {

    private RecyclerView rv;
    private RecyclerView.Adapter adp;
    private RecyclerView.LayoutManager lm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_approveleave);
        ArrayList<leaveap> list = new ArrayList<>();
        list.add(new leaveap("For medical cehckup"));
        list.add(new leaveap("For merriege"));
        list.add(new leaveap("To going somewhere"));

        rv =(RecyclerView)findViewById(R.id.rvapprove);
        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(this);
        adp = new adapterleaveapprove(list);
        rv.setLayoutManager(lm);
        rv.setAdapter(adp);
    }
}
