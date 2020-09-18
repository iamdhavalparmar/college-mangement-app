package com.example.dhaval.project.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dhaval.project.R;
import com.example.dhaval.project.general.PersonListActivity;
import com.example.dhaval.project.model.Str;

public class a_managestudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_managestudent);
    }

    public void student1(View view) {
        Intent it = new Intent(this, PersonListActivity.class);
        it.putExtra(Str.user_type,Str.student);
        it.putExtra(Str.semester,"1");
        startActivity(it);
    }

    public void student2(View view) {
        Intent it = new Intent(this,PersonListActivity.class);
        it.putExtra(Str.user_type,Str.student);
        it.putExtra(Str.semester,"3");
        startActivity(it);
    }

    public void student3(View view) {
        Intent it = new Intent(this,PersonListActivity.class);
        it.putExtra(Str.user_type,Str.student);
        it.putExtra(Str.semester,"5");
        startActivity(it);
    }
}
