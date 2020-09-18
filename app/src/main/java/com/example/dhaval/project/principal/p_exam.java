package com.example.dhaval.project.principal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dhaval.project.R;

public class p_exam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_exam);
    }

    public void schedule(View view) {
        Intent it = new Intent(this,p_examschd.class);
        startActivity(it);
    }

    public void seating(View view) {
        Intent it = new Intent(this,p_examseat.class);
        startActivity(it);
    }
}
