package com.example.dhaval.project.principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dhaval.project.R;

import org.w3c.dom.Text;

import java.util.List;

public class p_complaint extends AppCompatActivity {

    String name[] = {"Dhaval","Aakash","Meet","Sachin","Jaydeep"};
    int no[]={3,4,1,5,56};
    String desc[]={"ssdgdfgdfgfdgdfg","gdfgergdfgdsfg","ewrgdfgdsfgs","trhdfgfgdfg","wggfgdfgdfg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_complaint);

        ListView lv =(ListView)findViewById(R.id.complist);
        adp a = new adp(this,R.layout.rawcomplaint,name,no,desc);
        lv.setAdapter(a);
    }

}
