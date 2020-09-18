package com.example.dhaval.project.student;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dhaval.project.R;

public class raw extends BaseAdapter {
    int res;
    Context con;
    LayoutInflater ly;
    String[] str1;
    String[] str2;
    String[] str3;
    int[] img;

    public raw(Context context, int activity_raw, int[] img, String[] time, String[] sname, String[] fname) {
        this.con = context;
        this.res = activity_raw;
        this.str1 = time;
        this.str2 = sname;
        this.str3 = fname;
        this.img = img;

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

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        convertView = ly.from(con).inflate(res, null);
        ImageView iv = (ImageView) convertView.findViewById(R.id.iv);
        TextView tv = (TextView) convertView.findViewById(R.id.tv);
        TextView tv2 = (TextView) convertView.findViewById(R.id.tv2);
        TextView tv3 = (TextView) convertView.findViewById(R.id.tv3);

       iv.setImageResource(img[i]);
        tv.setText(str1[i]);
        tv2.setText(str2[i]);
        tv3.setText(str3[i]);
        return convertView;
    }
}
