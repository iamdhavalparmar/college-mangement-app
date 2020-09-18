package com.example.dhaval.project.faculty;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;
import com.example.dhaval.project.model.Leave;

import java.util.HashMap;
import java.util.List;

public class f_leaveapproveList extends RecyclerView.Adapter<com.example.dhaval.project.faculty.f_leaveapproveList.vh> {

    Context context;
        private List<Leave> leavelist;
        public f_leaveapproveList(List<Leave> examplelist){
            leavelist=examplelist;

        }
        @NonNull
        @Override
        public com.example.dhaval.project.faculty.f_leaveapproveList.vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            context = parent.getContext();
            View v= LayoutInflater.from(context).inflate(R.layout.rawleaveapprove,parent,false);
            com.example.dhaval.project.faculty.f_leaveapproveList.vh holder = new com.example.dhaval.project.faculty.f_leaveapproveList.vh(v);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull final com.example.dhaval.project.faculty.f_leaveapproveList.vh holder, int position) {
            final Leave currentitem = leavelist.get(position);
            holder.description.setText(currentitem.getDescription());
            holder.status.setText(currentitem.getStatus());
            holder.number.setText(currentitem.getUser_id());

            if (currentitem.getStatus().equals("Pending")){
                holder.approve.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        updateStatus(holder,"Approved",currentitem.getLeave_id());
                    }
                });
                holder.reject.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        updateStatus(holder,"Reject",currentitem.getLeave_id());
                    }
                });
            }else {
                holder.actionLayout.setVisibility(View.GONE);
            }
        }

    private void updateStatus(final vh holder, final String status, String leave_id) {
        HashMap<String, String> param=new HashMap<>();
        param.put("type","updateLeaveStatus");
        param.put("leave_id",leave_id);
        param.put("status",status);
        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                if (jsn.checkResponseStr(responseStr)){
                    Toast.makeText(context, "Updates ... ", Toast.LENGTH_SHORT).show();
                    holder.actionLayout.setVisibility(View.GONE);
                    holder.description.setText(status);
                    int adapterPosition = holder.getAdapterPosition();
                    leavelist.get(adapterPosition).setStatus(status);
                    notifyItemChanged(adapterPosition);
                }else {
                    Toast.makeText(context, "Not updated ... ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
        public int getItemCount() {
            return leavelist.size();
        }

        public static class vh extends RecyclerView.ViewHolder{

            public TextView description;
            public TextView status;
            public TextView approve;
            public TextView reject;
            public TextView number;
            View actionLayout;

            public vh(View itemView) {
                super(itemView);
                description=itemView.findViewById(R.id.description);
                status=itemView.findViewById(R.id.status);
                approve=itemView.findViewById(R.id.approve);
                reject=itemView.findViewById(R.id.reject);
                number=itemView.findViewById(R.id.number);
                actionLayout=itemView.findViewById(R.id.actionLayout);


            }

            public void text1(String s) {
            }
        }
    }

