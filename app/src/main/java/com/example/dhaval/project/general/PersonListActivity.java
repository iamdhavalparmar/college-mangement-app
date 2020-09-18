package com.example.dhaval.project.general;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.dhaval.project.R;
import com.example.dhaval.project.admin.facultylistraw;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;
import com.example.dhaval.project.model.Str;
import com.example.dhaval.project.model.UserLogin;

import java.util.HashMap;
import java.util.List;

public class PersonListActivity extends AppCompatActivity {

    private String user_type;
    private List<UserLogin> list;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);

        listView = findViewById(R.id.listView);

        user_type = getIntent().getStringExtra(Str.user_type);

        setTitle(user_type);

        getUserList(user_type);
    }

    private static final String TAG = "PersonListActivity";
    private void getUserList(String user_type) {
        HashMap<String, String> param=new HashMap<>();
        param.put("type","select");
        param.put("table","user_login");
        param.put("where", getWhereCondition(user_type));
        Log.e(TAG, "getUserList: " + param.toString());
        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                Log.e(TAG, "setResponse: " + responseStr);
                if (jsn.checkResponseStr(responseStr)){
                    list = jsn.getAllClassFromString(responseStr, UserLogin.class);
                    setAdapter(list);
                }
            }
        });
    }

    private String getWhereCondition(String user_type) {
        String condition="user_type=\'"+user_type+"\'";;
        if (user_type.equals(Str.student)){
            String semester = getIntent().getStringExtra(Str.semester);
            condition = condition + " and semester="+semester;
        }
        return condition;
    }

    private void setAdapter(List<UserLogin> list) {
        PersonListAdapter adp = new PersonListAdapter(this,R.layout.a_facultylist,list);
        listView.setAdapter(adp);
    }
}
