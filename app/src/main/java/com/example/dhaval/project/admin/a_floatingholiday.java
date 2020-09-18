package com.example.dhaval.project.admin;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dhaval.project.MyParam;
import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class a_floatingholiday extends AppCompatActivity {
    private DatePicker datePicker;
    EditText et;
    Button btn;
    String date;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_floatingholiday);

        datePicker = (DatePicker) findViewById(R.id.holidaydate);
        et=(EditText)findViewById(R.id.ETholi);
        btn=(Button)findViewById(R.id.saveholi);

        final int day = datePicker.getDayOfMonth();
        final int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();


        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM-dd-yyyy");
        Date d = new Date(year, month, day);
        String strDate = dateFormatter.format(d);



        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                date = dayOfMonth+"/"  +month + "/" + year ;

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveHoliday(date,et.getText().toString());
            }
        });

    }
        private static final String TAG="a_floatingholiday";
    private void saveHoliday(String date,String description){
        HashMap<String,String> param = new HashMap<>();
        param.put("type","save");
        param.put("table","holiday_list");
        param.put("user_id", MyParam.userId);
        param.put("date",date);
        param.put("description",description);

        Log.e(TAG, "saveHoliday: " + param.toString());

        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                Log.e(TAG,"setReasponse:"+responseStr);
                if(jsn.checkResponseStr(responseStr)){
                    Toast.makeText(a_floatingholiday.this,"Saved",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(a_floatingholiday.this, "Not Saved", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
