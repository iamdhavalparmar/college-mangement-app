package com.example.dhaval.project.student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dhaval.project.R;

public class complaintadp extends BaseAdapter{
    String[] str1;
    int[] no;
    int res;
    Context con;
    LayoutInflater ly;


    public complaintadp(s_complaint s_complaint, int sturawcomplaint, String[] com, int[] no) {
        this.con=s_complaint;
        this.res = sturawcomplaint;
        this.str1=com;
        this.no=no;
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
        TextView t1=(TextView)view.findViewById(R.id.subjectcomlaint);
        TextView t2=(TextView)view.findViewById(R.id.desccomplaint);
        t1.setText(str1[i]);
        t2.setText(no[i]);
        return view;
    }
}
