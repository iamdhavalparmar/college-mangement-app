package com.example.dhaval.project.admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dhaval.project.R;

public class facultylistraw extends BaseAdapter {
    Context c;
    LayoutInflater ly;
    String[] n;
    String[] add;
    String[] mail;
    String[] r;
    int[] pic;
    int res;
    String[] no;

    public facultylistraw(a_faclist a_faclist, int a_facultylist, int[] pics, String[] number, String[] name, String[] address, String[] email, String[] role) {
        this.c=a_faclist;
        this.res=a_facultylist;
        this.n=name;
        this.add=address;
        this.mail=email;
        this.pic=pics;
        this.r=role;
        no=number;

    }

    @Override
    public int getCount() {
        return n.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=ly.from(c).inflate(res,null);
        ImageView iv =(ImageView)convertView.findViewById(R.id.ivfaclist);
        TextView t1=(TextView)convertView.findViewById(R.id.facname);
        TextView t2=(TextView)convertView.findViewById(R.id.facno);
        TextView t3=(TextView)convertView.findViewById(R.id.facrole);
        TextView t4=(TextView)convertView.findViewById(R.id.facaddress);
        TextView t5=(TextView)convertView.findViewById(R.id.facemail);
         iv.setImageResource(pic[position]);
         t1.setText(n[position]);
         t2.setText(add[position]);
         t3.setText(no[position]);
         t4.setText(mail[position]);
         t5.setText(r[position]);

        return convertView;
    }
}
