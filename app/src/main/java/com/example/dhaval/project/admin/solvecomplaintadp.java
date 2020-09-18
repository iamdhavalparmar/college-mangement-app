package com.example.dhaval.project.admin;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dhaval.project.R;

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
        holder.solveText.setText(currentitem.Text1().toString());

        holder.approveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setStatus("1");
            }
        });

        holder.rejectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setStatus("2");
            }
        });

    }

    private void setStatus(String s) {

    }

    @Override
    public int getItemCount() {
        return leavelist.size();
    }

    public static class vh extends RecyclerView.ViewHolder{

        public TextView solveText;
        public TextView approveText;
        public TextView rejectText;

        public vh(View itemView) {
            super(itemView);
            solveText =itemView.findViewById(R.id.solve);
            approveText =itemView.findViewById(R.id.txt2);
            rejectText =itemView.findViewById(R.id.txt3);
        }


    }
}
