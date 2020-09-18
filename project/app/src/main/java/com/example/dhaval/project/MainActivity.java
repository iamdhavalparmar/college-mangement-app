package com.example.dhaval.project;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Dialog mydialog;
    ViewPager avp;
    LinearLayout all;
    slideradapter asa;
    TextView[] ndots;
    Button nprevbtn;
    Button nnextbtn;
    int currentpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        avp = (ViewPager) findViewById(R.id.vp);
        all = (LinearLayout) findViewById(R.id.ll);

        mydialog = new Dialog(this);

        nprevbtn = (Button) findViewById(R.id.prevbtn);
        nnextbtn = (Button) findViewById(R.id.nextbtn);

        asa = new slideradapter(this);
        avp.setAdapter(asa);

        adddotsIndicator(0);
        avp.addOnPageChangeListener(vp);

        nnextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avp.setCurrentItem(currentpage + 1);
                if(nnextbtn.getText().equals("FINISH")){
                    Intent it = new Intent(MainActivity.this,login.class);
                    startActivity(it);
                }
            }
        });
        nprevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avp.setCurrentItem(currentpage - 1);
            }
        });

    }

    private void adddotsIndicator(int position) {
        ndots = new TextView[4];
        all.removeAllViews();
        for (int i = 0; i < ndots.length; i++) {
            ndots[i] = new TextView(this);
            ndots[i].setText(Html.fromHtml("&#8226;"));
            ndots[i].setTextSize(35);

            all.addView(ndots[i]);

        }
        if(ndots.length > 0 ){
            ndots[position].setTextColor(getResources().getColor(R.color.White));
        }

    }
    ViewPager.OnPageChangeListener vp = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            adddotsIndicator(i);
            currentpage= i;
            if(i == 0){
                nnextbtn.setEnabled(true);
                nprevbtn.setEnabled(false);
                nprevbtn.setVisibility(View.INVISIBLE);

                nnextbtn.setText("NEXT");
                nprevbtn.setText("");

            }
            else if (i == ndots.length){
                nnextbtn.setEnabled(true);
                nprevbtn.setEnabled(true);
                nprevbtn.setVisibility(View.VISIBLE);

                nnextbtn.setText("NEXT");
                nprevbtn.setText("BACK");
            }
            else if (i == ndots.length -1 ){
                nnextbtn.setEnabled(true);
                nprevbtn.setEnabled(true);
                nprevbtn.setVisibility(View.VISIBLE);

                nnextbtn.setText("FINISH");
                nprevbtn.setText("BACK");
            }

                 else {
                    nnextbtn.setEnabled(true);
                    nprevbtn.setEnabled(true);
                    nprevbtn.setVisibility(View.VISIBLE);

                    nnextbtn.setText("NEXT");
                    nprevbtn.setText("BACK");
                }
            }

        @Override
        public void onPageScrollStateChanged(int i) {

        }


    };



}


