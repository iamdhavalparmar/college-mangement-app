package com.example.dhaval.project.general;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dhaval.project.R;

import java.util.List;

public class MyListAdapter extends BaseAdapter {

    private List<String> listId = null;
    private  int layout;
    private  List<String> listStatus = null;
    private  List<String> listDescription = null;
    Activity activity;
    LayoutInflater layoutInflater;


    public MyListAdapter(Activity activity, int layout, List<String> list) {
        this.activity=activity;
        this.layout = layout;
        this.listDescription = list;
        this.listStatus =null;
    }

    public MyListAdapter(Activity activity, int layout, List<String> listDescription, List<String> listId) {
        this.activity = activity;
        this.layout = layout;
        this.listDescription = listDescription;
        this.listId = listId;
    }


    public MyListAdapter(Activity activity, int layout, List<String> listDescription, List<String> listStatus, List<String> listId) {
        this.activity = activity;
        this.layout = layout;
        this.listDescription = listDescription;
        this.listStatus = listStatus;
        this.listId = listId;
    }

    @Override
    public int getCount() {
        return listDescription.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view = layoutInflater.from(activity).inflate(layout, null);
        TextView detail = (TextView) view.findViewById(R.id.detail);
        TextView status = (TextView) view.findViewById(R.id.status);
        TextView number = (TextView) view.findViewById(R.id.number);
        detail.setText(listDescription.get(i));

        if (listStatus!=null){
            status.setText(listStatus.get(i));
        }else status.setVisibility(View.GONE);

        if (listId!=null){
            number.setText(listId.get(i));
        }else number.setVisibility(View.GONE);

        return view;
    }
}
