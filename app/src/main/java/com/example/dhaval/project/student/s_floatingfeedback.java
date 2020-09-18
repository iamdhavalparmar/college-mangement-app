package com.example.dhaval.project.student;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;

import java.util.HashMap;


public class s_floatingfeedback extends AppCompatActivity {
    Button btn;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_floatingfeedback);
        et = findViewById(R.id.feedtx);
        btn = findViewById(R.id.feedsubmit);

        getSupportActionBar().hide();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .7));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savefeedback(et.getText().toString());
            }
        });
    }



    private void savefeedback(String description) {
            HashMap<String,String> param = new HashMap<>();
            param.put("type","save");
            param.put("table","feedback");
            param.put("description",description);

            NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
                @Override
                public void setResponse(String responseStr) {
                    if(jsn.checkResponseStr(responseStr))
                        Toast.makeText(s_floatingfeedback.this, "saved", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(s_floatingfeedback.this,"not saved",Toast.LENGTH_LONG).show();
                }
            });
        }
        }


