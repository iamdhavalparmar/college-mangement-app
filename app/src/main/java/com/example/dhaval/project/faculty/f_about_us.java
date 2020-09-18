package com.example.dhaval.project.faculty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.dhaval.project.R;


public class f_about_us extends AppCompatActivity {
    TextView mtv,mtv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_about_us);
        mtv=(TextView)findViewById(R.id.aboutus);
        mtv2=(TextView)findViewById(R.id.aboutus2);
        mtv.setText("This App provides an interface between college and the students");
        mtv2.setText("This App was founded by Dhaval Parmar , Aakash Patel and Asmita Prajapati.");
    }
}
