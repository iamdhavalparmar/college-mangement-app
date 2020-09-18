
package com.example.dhaval.project.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dhaval.project.R;

public class a_shardetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_shardetails);
    }

    public void sharedetail(View view) {
        Intent it = new Intent(this,a_sharefloating.class);
        startActivity(it);
    }
}
