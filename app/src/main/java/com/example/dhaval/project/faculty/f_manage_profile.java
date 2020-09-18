package com.example.dhaval.project.faculty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;


import com.example.dhaval.project.R;
import com.google.common.collect.Range;

public class f_manage_profile extends AppCompatActivity implements View.OnClickListener {
    EditText et1,et2,et3,et4,et5,et6,et7;
    Button btn;
    private AwesomeValidation awesomeValidation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_manage_profile);


        et1 = findViewById(R.id.name);
        et2 = findViewById(R.id.num);
        et3 = findViewById(R.id.email);
        et4 = findViewById(R.id.gender);
        et5 = findViewById(R.id.dob);
        et6 = findViewById(R.id.address);
        et7 = findViewById(R.id.course);

        btn = findViewById(R.id.submit);

//        awesomeValidation.addValidation(this, R.id.name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
//        awesomeValidation.addValidation(this, R.id.email, Patterns.EMAIL_ADDRESS, R.string.nameerror);
//        awesomeValidation.addValidation(this, R.id.num, "^[2-9]{2}[0-9]{8}$", R.string.nameerror);
//        awesomeValidation.addValidation(this, R.id.dob, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", R.string.nameerror);

//        btn.setOnClickListener(this);

    }
    private void submitForm() {
        if (awesomeValidation.validate()) {
            Toast.makeText(this, "Validation Successful", Toast.LENGTH_LONG).show();

        }

    }
    @Override
    public void onClick(View view) {
        if (view == btn) {
            submitForm();
        }
    }
}