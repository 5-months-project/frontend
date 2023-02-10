package com.example.frontend.Calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.frontend.R;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {
    private final String[][] mlist;

    public CalendarAdapter(String[][] sample) {
        mlist = sample;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView detail;

        ViewHolder(@NonNull View itemView) {

            super(itemView);
            title = itemView.findViewById(R.id.schedule_title);
            detail = itemView.findViewById(R.id.schedule_detail);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
        View view = inflater.inflate(R.layout.item_schedule,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.title.setText(mlist[position][0]);
        holder.detail.setText(mlist[position][1]);

    }


    @Override
    public int getItemCount() {
        return mlist.length;
    }


}
