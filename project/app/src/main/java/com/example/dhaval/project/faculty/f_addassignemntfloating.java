package com.example.dhaval.project.faculty;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.dhaval.project.R;

public class f_addassignemntfloating extends Activity implements AdapterView.OnItemSelectedListener {

    private static final int PDF = 123;
    Spinner spinner;
    Spinner spinner2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_addassignemntfloating);
        ImageView im =(ImageView) findViewById(R.id.upload_img) ;
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("application/pdf");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Pdf"), PDF);
            }
        });
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

        spinner=(Spinner)findViewById(R.id.sem);
        ArrayAdapter<CharSequence> adp = ArrayAdapter.createFromResource(this,R.array.sem,R.layout.support_simple_spinner_dropdown_item);
        adp.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adp);
        spinner.setOnItemSelectedListener(this);
        spinner2=(Spinner)findViewById(R.id.subject2);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position==0){

            ArrayAdapter<CharSequence> adp2 = ArrayAdapter.createFromResource(f_addassignemntfloating.this,R.array.sem2,R.layout.support_simple_spinner_dropdown_item);
            adp2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner2.setAdapter(adp2);
        }
        else if(position==1){
            ArrayAdapter<CharSequence> adp3 = ArrayAdapter.createFromResource(f_addassignemntfloating.this,R.array.sem4,R.layout.support_simple_spinner_dropdown_item);
            adp3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner2.setAdapter(adp3);
        }
        else if(position==2){
            ArrayAdapter<CharSequence> adp4 = ArrayAdapter.createFromResource(f_addassignemntfloating.this,R.array.sem6,R.layout.support_simple_spinner_dropdown_item);
            adp4.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner2.setAdapter(adp4);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        spinner.setTag("Semester");
        spinner2.setTag("Subject");
    }
}
