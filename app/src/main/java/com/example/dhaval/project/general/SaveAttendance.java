package com.example.dhaval.project.general;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.dhaval.project.MyParam;
import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;

import java.util.HashMap;

public class SaveAttendance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_attendance);


        TextView k = findViewById(R.id.key);
        k.setVisibility(View.GONE);

        String key = getIntent().getStringExtra("key");
        k.setText(key);

        HashMap<String, String> param = new HashMap<>();
        param.put("type", "updateFacultyAttendance");
        param.put("key", key);
        param.put("id", MyParam.userId);

        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {

                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.cancel(0);

                finish();
            }
        });

    }
}
