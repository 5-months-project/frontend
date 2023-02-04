package com.example.frontend.Calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.frontend.R;

import java.util.ArrayList;

public class PagerAdapter extends RecyclerView.Adapter<PagerAdapter.ViewHolder> {
    private String[] mlist;

    public PagerAdapter(String[] samp) {
        mlist = samp;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView text;
        TextView status;

        ViewHolder(@NonNull View itemView) {

            super(itemView);
            text = itemView.findViewById(R.id.text_item_viewpager);
            status = itemView.findViewById(R.id.viewpager_status);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
        View view = inflater.inflate(R.layout.item_calendar_viewpager,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PagerAdapter.ViewHolder holder, int position) {
        holder.text.setText(mlist[position]);
        holder.status.setText(position+1+"/"+mlist.length);

    }
    @Override
    public int getItemCount() {
        return mlist.length;
    }
}
