package com.example.dhaval.project.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dhaval.project.R;

public class s_floatingcomplaint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_floatingcomplaint);
    }

    public void save(View view) {
        Intent it = new Intent(this,s_complaint.class);
        startActivity(it);
    }
}
