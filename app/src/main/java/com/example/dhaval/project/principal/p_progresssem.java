package com.example.dhaval.project.principal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.example.dhaval.project.R;

public class p_progresssem extends AppCompatActivity {

    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_progresssem);
        t1 = (TextView) findViewById(R.id.tv1);
        t2 = (TextView) findViewById(R.id.tv2);
        t3 = (TextView) findViewById(R.id.tv3);
        t4 = (TextView) findViewById(R.id.tv4);

        if(getIntent().getStringExtra("first") != null) {
            t1.setText("ADVANCE C");
            t2.setText("DHTML");
            t3.setText("MATHS");
            t4.setText("DBMS");
        }
        else if(getIntent().getStringExtra("second") != null){
            t1.setText("DBMS2");
            t2.setText("JAVA");
            t3.setText("VB.NET");
            t4.setText("OOAD");
        }
        else if(getIntent().getStringExtra("third") != null) {
            t1.setText("ASP.NET");
            t2.setText("DBA");
            t3.setText("MULTIMEDIA");
            t4.setText("PROJECT");
        }

    }

    public void p1(View view) {
        Intent it = new Intent(this,PieChartActivity.class);
        it.putExtra("first","first");
        it.putExtra("second","second");
        it.putExtra("third","third");
        it.putExtra("subject",t1.getText().toString());
        startActivity(it);
    }

    public void p2(View view) {
        Intent it = new Intent(this,PieChartActivity.class);
        it.putExtra("first","first");
        it.putExtra("second","second");
        it.putExtra("third","third");
        it.putExtra("subject",t2.getText().toString());

        startActivity(it);
    }

    public void p3(View view) {
        Intent it = new Intent(this,PieChartActivity.class);
        it.putExtra("first","first");
        it.putExtra("second","second");
        it.putExtra("third","third");
        it.putExtra("subject",t3.getText().toString());

        startActivity(it);
    }

    public void p4(View view) {
        Intent it = new Intent(this,PieChartActivity.class);
        it.putExtra("first","first");
        it.putExtra("second","second");
        it.putExtra("third","third");
        it.putExtra("subject",t4.getText().toString());
        startActivity(it);
    }
}
