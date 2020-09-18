package com.example.dhaval.project.admin;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dhaval.project.R;
import com.example.dhaval.project.faculty.leaveap;

import java.util.ArrayList;

public class solvecomplaintadp extends RecyclerView.Adapter<solvecomplaintadp.vh> {

    private ArrayList<compap> leavelist;
    public solvecomplaintadp(ArrayList<compap> examplelist){
        leavelist=examplelist;

    }
    @NonNull
    @Override
    public vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.solvecomplaintraw,parent,false);
        vh holder = new vh(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull vh holder, int position) {
        compap currentitem = leavelist.get(position);
        holder.text122.setText(currentitem.Text1().toString());
    }

    @Override
    public int getItemCount() {
        return leavelist.size();
    }

    public static class vh extends RecyclerView.ViewHolder{

        public TextView text122;

        public vh(View itemView) {
            super(itemView);
            text122=itemView.findViewById(R.id.solve);
        }


    }
}
