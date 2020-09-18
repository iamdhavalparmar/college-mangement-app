package com.example.dhaval.project.faculty;


import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.dhaval.project.R;
import com.example.dhaval.project.model.AttendenceCheck;
import com.example.dhaval.project.model.UserLogin;

import java.util.ArrayList;
import java.util.List;

public class AttendanceListAdapter extends BaseAdapter {

    Activity activity;
    int layout;
    List<UserLogin> list;
    List<AttendenceCheck> attendenceList=new ArrayList<>();

    public AttendanceListAdapter(Activity activity, int layout, List<UserLogin> list) {
        this.activity = activity;
        this.layout = layout;
        this.list = list;
        hasStableIds();
        setAttendence();
    }

    private void setAttendence() {
        for (UserLogin userLogin : list) {
            AttendenceCheck attendence= new AttendenceCheck();
            attendence.setUserId(userLogin.getUser_id());
            attendence.setChecked(false);
            attendenceList.add(attendence);
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        UserLogin user = list.get(position);

        convertView = LayoutInflater.from(activity).inflate(layout, null);
        final CheckBox checkBox =  convertView.findViewById(R.id.checkbox);

        checkBox.setText(user.getUser_id());
        boolean checked = attendenceList.get(position).isChecked();
        checkBox.setChecked(checked);

        setColor(convertView,checked);


        final View finalConvertView = convertView;
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                attendenceList.get(position).setChecked(isChecked);
                setColor(finalConvertView,isChecked);
            }
        });

        return convertView;
    }

    private void setColor(View view, boolean isChecked) {
        int color;
        if (isChecked){
            color = Color.GREEN;
        }else {
            color = Color.RED;
        }
        view.setBackgroundColor(color);
    }
}

