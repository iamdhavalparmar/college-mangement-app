package com.example.dhaval.project.faculty;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dhaval.project.MyParam;
import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.Master_Upload;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;
import com.example.dhaval.project.model.Assignment;

import org.json.JSONObject;

import java.util.HashMap;

public class f_addassignemntfloating extends Activity implements AdapterView.OnItemSelectedListener {

    private static final int PDF = 123;
    Spinner spinner;
    Spinner spinner2;
    EditText des1;
    Button btnUpload;

    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_addassignemntfloating);
        des1 = findViewById(R.id.des1);
        btnUpload = findViewById(R.id.btnUpload);
        ImageView im = (ImageView) findViewById(R.id.upload_img);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("application/pdf");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Pdf"), PDF);
            }
        });
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .7));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

        spinner = (Spinner) findViewById(R.id.sem);
        ArrayAdapter<CharSequence> adp = ArrayAdapter.createFromResource(this, R.array.sem, R.layout.support_simple_spinner_dropdown_item);
        adp.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adp);
        spinner.setOnItemSelectedListener(this);
        spinner2 = (Spinner) findViewById(R.id.subject2);

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (uri != null) {
                    async async = new async(uri);
                    async.execute();
                } else {
                    btnUpload.setVisibility(View.GONE);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PDF) {

            if (data.getData() != null) {
                btnUpload.setVisibility(View.VISIBLE);
                uri = data.getData();
            } else {
                btnUpload.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {

            ArrayAdapter<CharSequence> adp2 = ArrayAdapter.createFromResource(f_addassignemntfloating.this, R.array.sem2, R.layout.support_simple_spinner_dropdown_item);
            adp2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner2.setAdapter(adp2);
        } else if (position == 1) {
            ArrayAdapter<CharSequence> adp3 = ArrayAdapter.createFromResource(f_addassignemntfloating.this, R.array.sem4, R.layout.support_simple_spinner_dropdown_item);
            adp3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner2.setAdapter(adp3);
        } else if (position == 2) {
            ArrayAdapter<CharSequence> adp4 = ArrayAdapter.createFromResource(f_addassignemntfloating.this, R.array.sem6, R.layout.support_simple_spinner_dropdown_item);
            adp4.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner2.setAdapter(adp4);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        spinner.setTag("Semester");
        spinner2.setTag("Subject");
    }

    @SuppressLint("StaticFieldLeak")
    public class async extends AsyncTask<Uri, Uri, Uri> {
        ProgressBar progressBar;
        String fileName;
        Uri uri;

        JSONObject jsonObject;

        public async(Uri uri) {
            this.uri = uri;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar = new ProgressBar(f_addassignemntfloating.this);
            progressBar.setVisibility(View.VISIBLE);

            fileName = des1.getText().toString();
        }

        @Override
        protected void onPostExecute(Uri s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.GONE);

            try {
                if (jsonObject.getString("action").equals("1")) {
                    Toast.makeText(f_addassignemntfloating.this, "ImageUploaded", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Toast.makeText(f_addassignemntfloating.this, "Catchimg:" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            saveFile(fileName);

        }

        @Override
        protected Uri doInBackground(Uri... uris) {

            Master_Upload master_upload = new Master_Upload();
            jsonObject = master_upload.callWS(uri, f_addassignemntfloating.this, fileName, ".pdf", NetworkCall.uploadFolder.ASSIGNMENT);


            return null;
        }
    }

    private void saveFile(String fileName) {

        Assignment assignment = new Assignment();
        assignment.setAssi_file(fileName + ".pdf");
        assignment.setSem(spinner.getSelectedItem().toString());
        assignment.setAssi_desc(spinner2.getSelectedItem().toString());
        assignment.setUser_id("f");

        HashMap<String, String> map = jsn.getMapForModel(assignment, "save");
        map.put("table", Assignment.getTableName());

        NetworkCall.call(map).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                Toast.makeText(f_addassignemntfloating.this, "" + responseStr, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
