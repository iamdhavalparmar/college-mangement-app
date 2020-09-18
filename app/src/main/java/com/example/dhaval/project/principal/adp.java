package com.example.dhaval.project.principal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dhaval.project.R;

import org.w3c.dom.Text;

public class adp extends BaseAdapter {
    String[] str1;
    int[] str2;
    String[] str3;
    int res;
    Context con;
    LayoutInflater ly;

    public adp(p_complaint p_complaint, int rawcomplaint, String[] name, int[] no, String[] desc) {
        this.con=p_complaint;
        this.res = rawcomplaint;
        this.str1=name;
        this.str2=no;
        this.str3=desc;
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
        TextView t1 = (TextView)view.findViewById(R.id.name);
        TextView t2 = (TextView)view.findViewById(R.id.no);
        TextView t3 = (TextView)view.findViewById(R.id.desc);
        t1.setText(str1[i]);
        //t2.setText(str2[i]);
        t3.setText(str3[i]);
        return view;
    }
}
