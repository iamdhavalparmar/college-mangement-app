package com.example.dhaval.project.principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;

import java.util.ArrayList;
import java.util.HashMap;

public class p_leave extends AppCompatActivity {

   String[] leaves={"for merriege","for medical checkup","for some reasons"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_leave);

        getLeaves();
        ListView lv =(ListView)findViewById(R.id.rv);
        adapterleave a = new adapterleave(this,R.layout.rawleave,leaves);
        lv.setAdapter(a);
    }

    private void getLeaves() {
        HashMap<String, String> param=new HashMap<>();
        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {

            }
        });
    }
}
