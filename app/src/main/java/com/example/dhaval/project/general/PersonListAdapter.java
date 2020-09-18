package com.example.dhaval.project.general;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dhaval.project.R;
import com.example.dhaval.project.admin.a_faclist;
import com.example.dhaval.project.model.UserLogin;

import java.util.List;

public class PersonListAdapter extends BaseAdapter {

    Activity activity; int layout; List<UserLogin> list;

    public PersonListAdapter(Activity activity, int layout, List<UserLogin> list) {
        this.activity=activity;
        this.layout=layout;
        this.list=list;
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
    public View getView(int position, View convertView, ViewGroup parent) {

        UserLogin user = list.get(position);

        convertView = LayoutInflater.from(activity).inflate(layout, null);
        ImageView iv = (ImageView) convertView.findViewById(R.id.ivfaclist);
        TextView t1 = (TextView) convertView.findViewById(R.id.facname);
        TextView t2 = (TextView) convertView.findViewById(R.id.facno);
        TextView t3 = (TextView) convertView.findViewById(R.id.facrole);
        TextView t4 = (TextView) convertView.findViewById(R.id.facaddress);
        TextView t5 = (TextView) convertView.findViewById(R.id.facemail);
//         iv.setImageResource(pic[position]);
        t1.setText(user.getUsername());
        t2.setText(user.getContact());
        t3.setText(user.getUser_id());
        t4.setText(user.getAddress());
        t5.setText(user.getEmail());

        return convertView;
    }
}
