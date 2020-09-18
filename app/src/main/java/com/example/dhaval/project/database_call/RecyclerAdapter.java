package com.example.dhaval.project.database_call;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private List<Object> list;
    private int layout;
    private LayoutInflater layoutInflater;
    private View view;

    public RecyclerAdapter(Context context, List<Object> list, int layout) {
        this.layout = layout;
        this.mContext = context;
        this.list = list;

        setHasStableIds(true);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        view = layoutInflater.inflate(layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        if (onBind != null) {
            onBind.onBindViewHolder(view, position);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View view) {
            super(view);
        }
    }

    public interface OnBind {
        void onBindViewHolder(View view, int position);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private OnBind onBind;

    public void setOnBind(OnBind onBind) {
        this.onBind = onBind;
    }

    private static final String TAG = "RecyclerAdapter";
}
