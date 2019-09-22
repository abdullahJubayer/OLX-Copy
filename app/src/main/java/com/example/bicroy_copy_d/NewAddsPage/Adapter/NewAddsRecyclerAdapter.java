package com.example.bicroy_copy_d.NewAddsPage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bicroy_copy_d.NewAddsPage.Model.CetagoryModel;
import com.example.bicroy_copy_d.R;
import com.example.bicroy_copy_d.RecyclerClickListner.ItemClickListner;

import java.util.List;

public class NewAddsRecyclerAdapter extends RecyclerView.Adapter<NewAddsRecyclerAdapter.NewAddsViewHolder>{

    private Context context;
    ItemClickListner recyclerClickListner;
    private List<CetagoryModel> data;
    public NewAddsRecyclerAdapter(Context context, ItemClickListner recyclerClickListner, List<CetagoryModel> data) {
        this.context=context;
        this.recyclerClickListner=recyclerClickListner;
        this.data=data;
    }

    @NonNull
    @Override
    public NewAddsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.new_add_activity_item_design,parent,false);
        return new NewAddsViewHolder(v,recyclerClickListner);
    }

    @Override
    public void onBindViewHolder(@NonNull NewAddsViewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
        Glide.with(context).load(data.get(position).getIcon()).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class NewAddsViewHolder extends RecyclerView.ViewHolder{
        ImageView icon;
        TextView name;
        ItemClickListner MyrecyclerClickListner;
        public NewAddsViewHolder(@NonNull View itemView, ItemClickListner recyclerClickListner) {
            super(itemView);
            icon=itemView.findViewById(R.id.new_add_activity_Design_icon);
            name=itemView.findViewById(R.id.new_add_activity_Design_txt);
            this.MyrecyclerClickListner= recyclerClickListner;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MyrecyclerClickListner.itemClick(getAdapterPosition());
                }
            });
        }
    }
}
