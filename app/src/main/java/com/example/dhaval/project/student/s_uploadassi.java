package com.example.dhaval.project.student;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.dhaval.project.MyParam;
import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.RecyclerAdapter;
import com.example.dhaval.project.database_call.jsn;
import com.example.dhaval.project.model.Assignment;

import java.util.HashMap;
import java.util.List;

public class s_uploadassi extends AppCompatActivity {

    RecyclerView uploadlist;
    List<Object> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_uploadassi);

        uploadlist = findViewById(R.id.uploadlist);

        jsn.RequestMultiplePermission(this, jsn.RequestPermissionCode, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE);

        setList();
    }

    private void setList() {

        HashMap<String, String> param = new HashMap<>();
        param.put("type", "select");
        param.put("table", Assignment.getTableName());
        param.put("where", Assignment.s.user_id + "='" + MyParam.userId + "'");

        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                if (jsn.checkResponseStr(responseStr)) {
                    list = jsn.getAllObjectFromString(responseStr, Assignment.class);
                    setAdapterView();
                }
            }
        });
    }

    private void setAdapterView() {

        RecyclerAdapter adapter = new RecyclerAdapter(this, list, R.layout.view_assignment_design);
        uploadlist.setAdapter(adapter);
        adapter.setOnBind(new RecyclerAdapter.OnBind() {
            @Override
            public void onBindViewHolder(View view, int position) {

                TextView name = view.findViewById(R.id.name);
                TextView sem = view.findViewById(R.id.sem);
                TextView subject = view.findViewById(R.id.subject);
                View container = view.findViewById(R.id.container);

                final Assignment assignment = (Assignment) list.get(position);

                name.setText(assignment.getAssi_file());
                sem.setText(assignment.getSem());
                subject.setText(assignment.getAssi_desc());

                container.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW
                                , Uri.parse(NetworkCall.SERVER_URL_ASSIGNMENT + assignment.getAssi_file()));
                        startActivity(browserIntent);
                    }
                });

                RadioGroup status = view.findViewById(R.id.status);
                status.setVisibility(View.VISIBLE);
                status.setClickable(false);
                status.setFocusable(false);
                RadioButton p = view.findViewById(R.id.pending);
                RadioButton a = view.findViewById(R.id.approve);
                RadioButton r = view.findViewById(R.id.reject);

                p.setClickable(false);
                a.setClickable(false);
                r.setClickable(false);

                switch (assignment.getStatus()) {
                    case "p":
                        p.setChecked(true);
                        break;
                    case "a":
                        a.setChecked(true);
                        break;
                    case "r":
                        r.setChecked(true);
                        break;
                }


            }
        });

    }

    public void newassignments(View view) {
        Intent it = new Intent(this, s_addassignemntfloating.class);
        startActivity(it);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
