package com.example.dhaval.project;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dhaval.project.admin.admin_dashboard;
import com.example.dhaval.project.faculty.Attendance_take;
import com.example.dhaval.project.faculty.faculty_dashboard;
import com.example.dhaval.project.principal.principal_dashboard;
import com.example.dhaval.project.student.student_dashboard;

public class login extends AppCompatActivity {
    RelativeLayout relly1, relly2;
    TextView t1;
    EditText e1,e2;
    Button b;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            relly1.setVisibility(View.VISIBLE);
            relly2.setVisibility(View.VISIBLE);
            t1.setVisibility(View.GONE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        relly1 = (RelativeLayout) findViewById(R.id.rellay1);
        relly2 = (RelativeLayout) findViewById(R.id.relly2);
        t1 = (TextView) findViewById(R.id.slogan);

        handler.postDelayed(runnable, 3000);


        e1=(EditText)findViewById(R.id.username);
        e2=(EditText)findViewById(R.id.pass);
        b=(Button)findViewById(R.id.loginbt);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(e1.getText().toString(),e2.getText().toString());
                Log.d("username",e1.getText().toString());
                Log.d("password",e1.getText().toString());
            }
        });

        }

    private void validate(String username,String password){


        if((username.equals("principal")) && (password.equals("principal"))){

            Intent it = new Intent(this,principal_dashboard.class );
            startActivity(it);
        }
        else if((username.equals("student")) && (password.equals("student"))){
            Intent it = new Intent(this,student_dashboard.class );
            startActivity(it);
        }
        else if((username.equals("faculty")) && (password.equals("faculty"))){
            Intent it = new Intent(this,faculty_dashboard.class);
            startActivity(it);
        }
        else if((username.equals("admin")) && (password.equals("admin"))) {
            Intent it = new Intent(this, admin_dashboard.class);
            startActivity(it);
        }
        else {
            Toast.makeText(getApplicationContext(),"Enter valid username and passsword",Toast.LENGTH_SHORT).show();
        }
    }
}
