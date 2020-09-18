package com.example.dhaval.project.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dhaval.project.R;

public class s_exam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_exam);
    }

    public void stu_seating(View view) {
        Intent it = new Intent(this,s_seating.class);
        startActivity(it);
    }

    public void stu_exsched(View view) {
        Intent it  = new Intent(this,s_examschedule.class);
        startActivity(it);
    }

    public void stu_result(View view) {
        Intent it = new Intent(this,s_seating.class);
        startActivity(it);
    }
}
