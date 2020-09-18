package com.example.dhaval.project.faculty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dhaval.project.R;

public class f_assignment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_assignment);
    }

    public void viewassignment(View view) {

        Intent it = new Intent(this,f_viewassignment.class);
        startActivity(it);
    }

    public void checkassignment(View view) {
        Intent it = new Intent(this,f_checkassignment.class);
        startActivity(it);
    }
}
