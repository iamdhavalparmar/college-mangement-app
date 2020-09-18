package com.example.dhaval.project.principal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dhaval.project.R;

public class p_atd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_atd);
    }

    public void facatd(View view) {
        Intent it = new Intent(this,P_facatd.class);
        startActivity(it);
    }

    public void ntatd(View view) {
        Intent it = new Intent(this,p_ntatd.class);
        startActivity(it);
    }

}
