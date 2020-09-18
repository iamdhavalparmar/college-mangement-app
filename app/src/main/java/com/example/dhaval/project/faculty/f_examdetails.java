package com.example.dhaval.project.faculty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dhaval.project.R;

public class f_examdetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_examdetails);
    }

    public void facexamsche(View view) {
        Intent it = new Intent(this,f_examschedule.class);
        startActivity(it);
    }

    public void fac_setaing(View view) {
        Intent it = new Intent(this,f_seatingarra.class);
        startActivity(it);
    }

    public void fac_result(View view) {
        Intent it = new Intent(this,f_result.class);
        startActivity(it);
    }
}
