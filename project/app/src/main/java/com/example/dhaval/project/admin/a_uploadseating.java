package com.example.dhaval.project.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dhaval.project.R;

public class a_uploadseating extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_uploadseating);
    }

    public void newexamsseating(View view) {
        Intent it = new Intent(this,a_examseatingfloating.class);
        startActivity(it);
    }
}