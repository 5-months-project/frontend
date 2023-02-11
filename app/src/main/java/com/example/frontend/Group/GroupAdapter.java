package com.example.frontend.Group;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.frontend.R;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {
    private final String[][] mlist;

    public GroupAdapter(String[][] sample) {
        this.mlist = sample;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView title;
        TextView date;
        TextView detail1;
        TextView detail2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txt_group_list_title);
            date = itemView.findViewById(R.id.txt_group_list_date);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
        View view = inflater.inflate(R.layout.item_group,parent,false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(mlist[position][0]);
        holder.date.setText(mlist[position][1]);
    }

    @Override
    public int getItemCount() {
        return mlist.length;
    }


}
