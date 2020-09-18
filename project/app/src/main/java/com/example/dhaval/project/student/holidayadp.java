package com.example.dhaval.project.student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dhaval.project.R;

public class holidayadp extends BaseAdapter {
    String[] str1;
    String[] str2;
    int res;
    Context con;
    LayoutInflater ly;

    public holidayadp(s_holiday s_holiday, int holidaylistshow, String[] date, String[] reason) {
        this.con=s_holiday;
        this.res = holidaylistshow;
        this.str1=date;
        this.str2=reason;
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
        TextView t1=(TextView)view.findViewById(R.id.tvdate);
        TextView t2 =(TextView)view.findViewById(R.id.tvreason);
        t1.setText(str1[i]);
        t2.setText(str2[i]);
        return view;
    }
}
