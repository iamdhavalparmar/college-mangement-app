package com.example.dhaval.project.faculty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dhaval.project.R;
import com.example.dhaval.project.principal.adapterleave;
import com.example.dhaval.project.principal.leave;

import java.util.ArrayList;

public class f_leave extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_leave);

    }

    public void newaleave(View view) {
        Intent it = new Intent(this,f_floatingleave.class);
        startActivity(it);
    }
}
