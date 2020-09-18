package com.example.dhaval.project.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dhaval.project.R;
import com.example.dhaval.project.faculty.f_floatingleave;

public class s_leave extends AppCompatActivity {

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
