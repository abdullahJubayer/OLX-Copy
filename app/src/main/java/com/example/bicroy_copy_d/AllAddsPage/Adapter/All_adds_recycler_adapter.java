package com.example.bicroy_copy_d.AllAddsPage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bicroy_copy_d.HomePage.Model.Model;
import com.example.bicroy_copy_d.R;
import com.example.bicroy_copy_d.RecyclerClickListner.ItemClickListner;

import java.util.List;

public class All_adds_recycler_adapter extends RecyclerView.Adapter<All_adds_recycler_adapter.MyaddsViewHolder>{

    private ItemClickListner itemClickListner;
    private Context context;
    private List<Model> data;
    public All_adds_recycler_adapter(Context context, List<Model> data, ItemClickListner itemClickListner) {
        this.context=context;
        this.data=data;
        this.itemClickListner=itemClickListner;
    }

    @NonNull
    @Override
    public MyaddsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.my_adds_item_design,parent,false);
        return new MyaddsViewHolder(v,itemClickListner);
    }

    @Override
    public void onBindViewHolder(@NonNull MyaddsViewHolder holder, int position) {
        Glide.with(context).load(data.get(position).getImage()).into(holder.image);
        holder.name.setText(data.get(position).getName());
        //holder.price.setText(data.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyaddsViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name,price;
        ItemClickListner itemClickListner;
        public MyaddsViewHolder(@NonNull View itemView, final ItemClickListner itemClickListner) {
            super(itemView);
            image=itemView.findViewById(R.id.my_adds_item_image);
            name=itemView.findViewById(R.id.my_adds_item_name);
            price=itemView.findViewById(R.id.my_adds_item_price);
            this.itemClickListner=itemClickListner;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListner.itemClick(getAdapterPosition());
                }
            });
        }
    }
}