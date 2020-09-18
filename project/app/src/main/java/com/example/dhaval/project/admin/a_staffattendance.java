package com.example.dhaval.project.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dhaval.project.R;

import java.util.ArrayList;

public class a_staffattendance extends AppCompatActivity {


    ArrayList<String> selectedit = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_staffattendance);

        ListView list=(ListView)findViewById(R.id.staffatd);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] items={"English","maths","science"};
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,R.layout.raw_attendance,R.id.check,items);
        list.setAdapter(adp);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = ((TextView)view).getText().toString();
                if(selectedit.contains(selected)){
                    selectedit.remove(selected);
                }
                else
                    selectedit.add(selected);
            }
        });

    }
}
