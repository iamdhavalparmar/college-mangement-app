package com.example.dhaval.project.principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.example.dhaval.project.R;

import java.util.ArrayList;

public class p_leave extends AppCompatActivity {

   String[] leaves={"for merriege","for medical checkup","for some reasons"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_leave);

        ListView lv =(ListView)findViewById(R.id.rv);
        adapterleave a = new adapterleave(this,R.layout.rawleave,leaves);
        lv.setAdapter(a);
    }
}
