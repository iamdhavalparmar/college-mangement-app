package com.example.dhaval.project.principal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.dhaval.project.R;


public class adapterleave extends BaseAdapter {

    String[] str1;
    int res;
    Context con;
    LayoutInflater ly;
    public adapterleave(p_leave p_leave, int rawleave, String[] leaves) {
        this.con=p_leave;
        this.res = rawleave;
        this.str1=leaves;
    }

    @Override
    public int getCount() {
        return str1.length;
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
    public View getView(int i, View view, ViewGroup parent) {
        view=ly.from(con).inflate(res,null);
        TextView t1 = (TextView)view.findViewById(R.id.txt1);
        t1.setText(str1[i]);
        return view;
    }
}
