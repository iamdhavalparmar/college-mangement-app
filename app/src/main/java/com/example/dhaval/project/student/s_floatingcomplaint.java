package com.example.dhaval.project.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dhaval.project.MyParam;
import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;

import java.util.HashMap;

public class s_floatingcomplaint extends AppCompatActivity {
    EditText editText;
    Button button;
    private String table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_floatingcomplaint);
        button = findViewById(R.id.btn);
        editText = findViewById(R.id.et);
        getSupportActionBar().hide();


        DisplayMetrics dm= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);



        int width=dm.widthPixels;
        int height= dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.7));

        WindowManager.LayoutParams params=getWindow().getAttributes();
        params.gravity= Gravity.CENTER;
        params.x=0;
        params.y=-20;

        getWindow().setAttributes(params);


        table = getIntent().getStringExtra("table");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    savecomplaint(editText.getText().toString());
            }
        });


    }
    private void savecomplaint (String description){
        HashMap<String,String> param = new HashMap<>();
        param.put("type","save");
        param.put("table",table);
        param.put("description",description);
        param.put("user_id", MyParam.userId);
        param.put("user_type", MyParam.usertype );

        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                if(jsn.checkResponseStr(responseStr))
                    Toast.makeText(s_floatingcomplaint.this, "saved", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(s_floatingcomplaint.this,"not saved",Toast.LENGTH_LONG).show();
            }
        });
    }

}
