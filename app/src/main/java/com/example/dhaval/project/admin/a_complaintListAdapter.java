
package com.example.dhaval.project.admin;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dhaval.project.MyParam;
import com.example.dhaval.project.R;
import com.example.dhaval.project.database_call.NetworkCall;
import com.example.dhaval.project.database_call.jsn;
import com.example.dhaval.project.model.Complaint;

import java.util.HashMap;
import java.util.List;

public class a_complaintListAdapter extends RecyclerView.Adapter<a_complaintListAdapter.vh> {

    private List<Complaint> leavelist;

    public a_complaintListAdapter(List<Complaint> examplelist) {
        leavelist = examplelist;

    }

    @NonNull
    @Override
    public vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.solvecomplaintraw, parent, false);
        vh holder = new vh(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull vh holder, int position) {
        final Complaint complaint = leavelist.get(position);
        String description = complaint.getDescription();

        if (complaint.getStatus().equals("0")){
            holder.statusLayout.setVisibility(View.GONE);
        }else {
            description = description + " Status : "+getComplaintStatus(complaint.getStatus());
        }
        holder.complaint.setText(description);



        holder.approveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setStatus(complaint,"1");
            }
        });

        holder.rejectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setStatus(complaint,"2");
            }
        });


    }

    private String getComplaintStatus(String status) {
        if (status.equals("1")){
            return "Approved";
        }else {
            return "Rejected";
        }
    }

    private void setStatus(Complaint complaint, String s) {
        HashMap<String, String> param=new HashMap<>();
        param.put("type","save");
        param.put("table","complaint");
        param.put("complaint_id",complaint.getComplaint_id());
        param.put("description",complaint.getDescription());
        param.put("user_id", complaint.getUser_id());
        param.put("status",s);

        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
            @Override
            public void setResponse(String responseStr) {
                if (jsn.checkResponseStr(responseStr)){
                    notifyDataSetChanged();
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return leavelist.size();
    }

    public static class vh extends RecyclerView.ViewHolder {

        public TextView complaint;
        public TextView approveText;
        public TextView rejectText;
        public View statusLayout;

        public vh(View itemView) {
            super(itemView);
            statusLayout = itemView.findViewById(R.id.statusLayout);
            complaint = itemView.findViewById(R.id.solve);
            approveText =itemView.findViewById(R.id.txt2);
            rejectText =itemView.findViewById(R.id.txt3);
        }


    }
}
