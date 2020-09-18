package com.example.dhaval.project;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.dhaval.project.admin.admin_dashboard;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;
import com.example.dhaval.project.faculty.faculty_dashboard;
import com.example.dhaval.project.principal.principal_dashboard;
import com.example.dhaval.project.student.student_dashboard;

import org.json.JSONObject;

import java.util.HashMap;

public class login extends AppCompatActivity {
    RelativeLayout relly1, relly2;
    TextView t1;
    EditText e1, e2;
    Button b;
    String stremail;
    String strpwd;

//    Handler handler = new Handler();
//    Runnable runnable = new Runnable() {
//        @Override
//        public void run() {
//            relly1.setVisibility(View.VISIBLE);
//            relly2.setVisibility(View.VISIBLE);
//            t1.setVisibility(View.GONE);
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        relly1 = (RelativeLayout) findViewById(R.id.rellay1);
        relly2 = (RelativeLayout) findViewById(R.id.relly2);
        t1 = (TextView) findViewById(R.id.slogan);



            new Handler().postDelayed(new Runnable() {

                /*
                 * Showing splash screen with a timer. This will be useful when you
                 * want to show case your app logo / company
                 */

                @Override
                public void run() {
                    // This method will be executed once the timer is over
                    // Start your app main activity

                    relly1.setVisibility(View.VISIBLE);
                    relly2.setVisibility(View.VISIBLE);
                    t1.setVisibility(View.GONE);

                }
            }, 3000);




        e1 = (EditText) findViewById(R.id.username);
        e2 = (EditText) findViewById(R.id.pass);
        b = (Button) findViewById(R.id.loginbt);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    userLogin();
            }
        });


    }

    private static final String TAG = "login";

    private void userLogin() {

        String userName = e1.getText().toString();
        String password = e2.getText().toString();
        HashMap<String, String> param=new HashMap<>();
        param.put("user_name",userName);
        param.put("password",password);
        param.put("type","signIn");

        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                Log.e(TAG, "setResponse: " + responseStr);
                if (jsn.checkResponseStr(responseStr)){
                    JSONObject object = jsn.getJSONObjectAt0(responseStr);
                    String user_id = jsn.getJSONString(object, "user_id");
                    MyParam.userId = user_id;
                    Toast.makeText(login.this, MyParam.userId, Toast.LENGTH_SHORT).show();
                    validate(e1.getText().toString(), e2.getText().toString());
                }else {
                    Toast.makeText(login.this, "Please enter valid username and password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validate(String username, String password) {

        boolean isValid = true;
        if ((username.contains("principal")) && (password.contains("principal"))) {
            MyParam.usertype="principal";
            Intent it = new Intent(this, principal_dashboard.class);
            startActivity(it);
        } else if ((username.contains("student")) && (password.contains("student"))) {
            MyParam.usertype="student";
            Intent it = new Intent(this, student_dashboard.class);
            startActivity(it);
        } else if ((username.contains("faculty")) && (password.contains("faculty"))) {
            MyParam.usertype="faculty";
            Intent it = new Intent(this, faculty_dashboard.class);
            startActivity(it);
        } else if ((username.contains("admin")) && (password.contains("admin"))) {
            MyParam.usertype="admin";
            Intent it = new Intent(this, admin_dashboard.class);
            startActivity(it);
        } else {
            isValid = false;
            Toast.makeText(getApplicationContext(), "Enter valid username and passsword", Toast.LENGTH_SHORT).show();
        }

        return isValid;
    }

    /*private void login() {
        String[] keys = new String[]{"action", "email_id", "password"};
        String[] values = new String[]{"login", stremail, strpwd};
        String jsonRequest = Utils.createJsonRequest(keys, values);
        String URL = "http://192.168.43.183/cronic/";

        new WebserviceCall(login.this, URL, jsonRequest, "Logging in", true, new AsyncResponse() {
            @Override
            public void onCallback(String response) {
                Log.d("myapp", response);
                LoginModel model = new Gson().fromJson(response, LoginModel.class);
                Toast.makeText(login.this, model.getMessage(), Toast.LENGTH_SHORT).show();

                JSONObject obj = null;
                try {
                    obj = new JSONObject(response);
                    JSONObject userJson = obj.getJSONObject("data");
                    LoginModel.UserDetailBean user = new LoginModel.UserDetailBean(
                            userJson.getInt("id"),
                            userJson.getString("uname"),
                            userJson.getString("email_id"));
                    SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);

                    //starting the profile activity
                    finish();
                    startActivity(new Intent(getApplicationContext(), Home_Page.class));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        });
    }*/
}

