package com.example.dhaval.project.faculty;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dhaval.project.R;

import java.util.ArrayList;

public class adapterleaveapprove extends RecyclerView.Adapter<adapterleaveapprove.vh> {

    private ArrayList<leaveap> leavelist;
    public adapterleaveapprove(ArrayList<leaveap> examplelist){
        leavelist=examplelist;

    }
    @NonNull
    @Override
    public vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.rawleaveapprove,parent,false);
        vh holder = new vh(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull vh holder, int position) {
        leaveap currentitem = leavelist.get(position);
        holder.text12.setText(currentitem.Text1());
    }

    @Override
    public int getItemCount() {
        return leavelist.size();
    }

    public static class vh extends RecyclerView.ViewHolder{

        public TextView text12;

        public vh(View itemView) {
            super(itemView);
            text12=itemView.findViewById(R.id.approve1);
        }

        public void text1(String s) {
        }
    }
}
