package com.example.dhaval.project.principal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.dhaval.project.R;
import com.example.dhaval.project.student.s_timetable;

public class p_timetable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_timetable);
    }
        public void pro1(View view) {
            Intent it = new Intent(this,s_timetable.class);
            it.putExtra("first","first");
            startActivity(it);
        }

        public void prog2(View view) {
            Intent it = new Intent(this,s_timetable.class);
            it.putExtra("second","second");
            startActivity(it);
        }

        public void prog3(View view) {
            Intent it = new Intent(this, s_timetable.class);
            it.putExtra("third","third");
            startActivity(it);
    }

}
