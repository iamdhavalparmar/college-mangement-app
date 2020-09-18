package com.example.dhaval.project.student;


import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.dhaval.project.R;
import com.example.dhaval.project.model.Attendance;
import com.example.dhaval.project.model.AttendenceCheck;
import com.example.dhaval.project.model.UserLogin;

import java.util.ArrayList;
import java.util.List;

public class studentAttendanceAdapter extends BaseAdapter {

    Activity activity;
    int layout;
    List<Attendance> list;

    public studentAttendanceAdapter(Activity activity, int layout, List<Attendance> list) {
        this.activity = activity;
        this.layout = layout;
        this.list = list;
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

        Attendance attendance = list.get(position);

        convertView = LayoutInflater.from(activity).inflate(layout, null);
        TextView title = convertView.findViewById(R.id.title);
        TextView data = convertView.findViewById(R.id.data);

        title.setText(attendance.getLacture());
        data.setText(getPresent(attendance.getPresent()));

        return convertView;
    }

    private String getPresent(String present) {
        if (present.equals("0")){
            return "Absent";
        }else {
            return "Present";
        }
    }


}

