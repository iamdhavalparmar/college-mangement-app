package com.example.dhaval.project.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dhaval.project.R;

public class s_assignment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_assignment);
    }

    public void viewassignment(View view) {
        Intent it = new Intent(this,s_viewassi.class);
        startActivity(it);
    }

    public void uploadassignment(View view) {
        Intent it = new Intent(this,s_uploadassi.class);
        startActivity(it);
    }

    public void status(View view) {
        Intent it = new Intent(this,s_assistatus.class);
        startActivity(it);
    }
}
