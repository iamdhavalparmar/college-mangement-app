package com.example.dhaval.project.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dhaval.project.R;

public class a_managestudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_managestudent);
    }

    public void student1(View view) {
        Intent it = new Intent(this,a_managestu1.class);
        startActivity(it);
    }

    public void student2(View view) {
        Intent it = new Intent(this,a_managestu2.class);
        startActivity(it);
    }

    public void student3(View view) {
        Intent it = new Intent(this,a_managestu3.class);
        startActivity(it);
    }
}
