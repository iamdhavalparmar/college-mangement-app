package com.example.dhaval.project.student;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.dhaval.project.R;
import com.github.mikephil.charting.utils.ColorTemplate;

public class s_holiday extends AppCompatActivity {

    String[] date={"11/12/2018","14/12/2018","20/12/2018"};
    String[] reason={"due to some work","Due to some function","due to construncation running in college"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_holiday);

        ListView lv =(ListView)findViewById(R.id.s_hdlv);
        holidayadp adp = new holidayadp(this,R.layout.holidaylistshow,date,reason);
        lv.setAdapter(adp);
    }
}
