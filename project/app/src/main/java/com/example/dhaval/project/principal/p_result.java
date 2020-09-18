package com.example.dhaval.project.principal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dhaval.project.R;

public class p_result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_result);
    }

    public void res1(View view) {
        Intent it = new Intent(this,p_res1.class);
        startActivity(it);
    }

    public void res2(View view) {
        Intent it = new Intent(this,p_res2.class);
        startActivity(it);
    }

    public void res3(View view) {
        Intent it = new Intent(this,p_res3.class);
        startActivity(it);
    }
}
