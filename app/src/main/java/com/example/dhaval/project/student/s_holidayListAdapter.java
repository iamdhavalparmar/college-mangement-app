
package com.example.dhaval.project.student;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dhaval.project.R;
import com.example.dhaval.project.model.HolidayList;

import java.util.List;

public class s_holidayListAdapter extends RecyclerView.Adapter<s_holidayListAdapter.vh> {

    private List<HolidayList> holidayLists;
    private static final String TAG = "s_holidayListAdapter";

    public s_holidayListAdapter(List<HolidayList> examplelist) {
        holidayLists = examplelist;

    }

    @NonNull
    @Override
    public vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.holidaylistshow, parent, false);
        vh holder = new vh(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull vh holder, int position) {
        HolidayList holidayList = holidayLists.get(position);
        holder.tvdate.setText(holidayList.getDate());
        holder.tvreason.setText(holidayList.getDescription());
        Log.e(TAG, "onBindViewHolder: "+holidayList.getDescription() );



    }

    @Override
    public int getItemCount() {
        return holidayLists.size();
    }

    public static class vh extends RecyclerView.ViewHolder {

        public TextView tvreason,tvdate;

        public vh(View itemView) {
            super(itemView);
            tvreason = itemView.findViewById(R.id.tvreason);
            tvdate = itemView.findViewById(R.id.tvdate);
        }


    }
}
