package com.example.dhaval.project.faculty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dhaval.project.MyParam;
import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;
import com.example.dhaval.project.model.Progress;
import com.example.dhaval.project.model.UserLogin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class f_progress extends AppCompatActivity {

    EditText progress;
    Button saveButton;
    Spinner spinner;
    private List<Progress> list;
    private Progress progressModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_progress);

        progress = findViewById(R.id.progress);
        saveButton = findViewById(R.id.saveButton);
        spinner = findViewById(R.id.spinner);

        getAndSetSpinner();

        setOnClick();
    }

    private void setOnClick() {
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidProgressPercentage()){
                    saveProgress();
                }else {
                    Toast.makeText(f_progress.this, "Enter valid progress to save", Toast.LENGTH_SHORT).show();
                }
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                progressModel = list.get(position);
                progress.setText(progressModel.getProgress());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void getAndSetSpinner() {
        HashMap<String, String> param=new HashMap<>();
        param.put("type","select");
        param.put("table","progress");
        param.put("where",getWhere());

        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                if (jsn.checkResponseStr(responseStr)){
                    list = jsn.getAllClassFromString(responseStr, Progress.class);
                    setSpinner(list);
                }
            }
        });
    }

    private void setSpinner(List<Progress> list) {
        List<String> spinnerList = new ArrayList<>();
        for (Progress progress1 : list) {
            spinnerList.add(progress1.getSubject());
        }
        spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,spinnerList));
    }

    private void getAndSetProgress() {
        HashMap<String, String> param=new HashMap<>();
        param.put("type","select");
        param.put("table","user_login");
        param.put("where",getWhere());
        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                if (jsn.checkResponseStr(responseStr)){
                    UserLogin user = (UserLogin) jsn.getSingleObjectFromString(responseStr, UserLogin.class);
                    progress.setText(user.getProgress());
                }
            }
        });
    }

    private String getWhere() {
        return "user_id="+MyParam.userId;
    }

    private static final String TAG = "f_progress";

    private void saveProgress() {
        HashMap<String, String> param=new HashMap<>();
        param.put("type","save");
        param.put("table","progress");
        param.put("id", progressModel.getId());
        param.put("subject", progressModel.getSubject());
        param.put("user_id", progressModel.getUser_id());
        param.put("progress", progress.getText().toString().trim());

        Log.e(TAG, "saveProgress: " + param.toString());
        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                Log.e(TAG, "setResponse: " + responseStr);
                if (jsn.checkResponseStr(responseStr)){
                    Toast.makeText(f_progress.this, "Progress saved ... ", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(f_progress.this, "Please enter updated progress ... ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidProgressPercentage() {
        String prog = progress.getText().toString();
        double progDouble = Double.parseDouble(prog);
        return progDouble<=100;
    }
}
