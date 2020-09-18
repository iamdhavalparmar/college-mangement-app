package com.example.dhaval.project.principal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dhaval.project.R;
import com.example.dhaval.project.principal.p_progresssem;

public class p_progress extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_progress);
    }

    public void pro1(View view) {
        Intent it = new Intent(this,p_progresssem.class);
        it.putExtra("first","first");
        startActivity(it);
        }

    public void prog2(View view) {
        Intent it = new Intent(this,p_progresssem.class);
        it.putExtra("second","second");
        startActivity(it);
    }

    public void prog3(View view) {
        Intent it = new Intent(this, p_progresssem.class);
        it.putExtra("third","third");
        startActivity(it);
    }
}
