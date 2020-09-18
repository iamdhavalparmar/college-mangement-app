package com.example.dhaval.project.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.dhaval.project.R;

import java.util.List;

public class a_faclist extends AppCompatActivity {


    private  int[] pics={R.drawable.leave,R.drawable.syllabus,R.drawable.attendance};
    private String[] name={"dhaval","Aakash","Meet"};
    private  String[] address={"saraspur","Ahmedabad","bapuagar"};
    private String[] email={"abc@gmail.com","bcd@gmail.com","xyz@gmail.com"};
    private String[] role={"permenent","permenet","temporary"};
    private String[] number={"234234345345","345345435435","34534534543"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_faclist);

        ListView lv = (ListView)findViewById(R.id.faclist);
        facultylistraw adp = new facultylistraw(this,R.layout.a_facultylist,pics,name,address,email,role,number);
        lv.setAdapter(adp);

    }
}
