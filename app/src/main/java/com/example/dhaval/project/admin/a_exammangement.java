package com.example.dhaval.project.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dhaval.project.R;

public class a_exammangement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_exammangement);
    }

    public void uploadschedule(View view) {
        Intent it = new Intent(this,a_uploadschedule.class);
        startActivity(it);
    }

    public void uploadseating(View view) {
        Intent it = new Intent(this,a_uploadseating.class);
        startActivity(it);
    }

    public void uploadresult(View view) {
        Intent it = new Intent(this,a_uploadresult.class);
        startActivity(it);
    }
}
