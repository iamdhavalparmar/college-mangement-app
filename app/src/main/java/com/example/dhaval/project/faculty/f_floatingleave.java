package com.example.dhaval.project.faculty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
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

public class f_floatingleave extends AppCompatActivity {

    Button submit;
    private EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_floatingleave);
        DisplayMetrics dm= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        submit = findViewById(R.id.submit);
        edittext = findViewById(R.id.edittext);

        int width=dm.widthPixels;
        int height= dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.7));

        WindowManager.LayoutParams params=getWindow().getAttributes();
        params.gravity= Gravity.CENTER;
        params.x=0;
        params.y=-20;

        getWindow().setAttributes(params);




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveLeave(edittext.getText().toString());

            }
        });
    }

    private static final String TAG = "f_floatingleave";
    private void saveLeave(String description) {
        HashMap<String, String> param = new HashMap<>();
        param.put("type","save");
        param.put("table","leave");
        param.put("leave_id","null");
        param.put("description",description);
        param.put("user_id", MyParam.userId);
        param.put("user_type", MyParam.usertype);

        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                Log.e(TAG, "setResponse: "+responseStr );
                if (jsn.checkResponseStr(responseStr)){
                    Toast.makeText(f_floatingleave.this, "Saved", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(f_floatingleave.this, "Not Saved", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
