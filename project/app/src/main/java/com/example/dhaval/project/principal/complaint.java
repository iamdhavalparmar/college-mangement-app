package com.example.dhaval.project.principal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dhaval.project.R;


public class complaint extends BaseAdapter{
    String[] str1;
    int res;
    Context con;
    LayoutInflater ly;
    String stu[];
    public complaint(p_feedback p_feedback, int rawfeedback, String[] str, String[] stuid) {
        this.con=p_feedback;
        this.res = rawfeedback;
        this.str1=str;
        this.stu=stuid;
    }

    @Override
    public int getCount() {
        return str1.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view=ly.from(con).inflate(res,null);
        TextView t1 = (TextView)view.findViewById(R.id.feed);
        TextView t2 = (TextView)view.findViewById(R.id.id);
        t1.setText(str1[i]);
        t2.setText(stu[i]);
        return view;
    }
}
