package com.example.bicroy_copy_d.HomePage.Adapter;

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
import com.example.bicroy_copy_d.RecyclerClickListner.ItemClickListner;
import com.example.bicroy_copy_d.R;
import java.util.List;


public class HomePageProductAdapter extends RecyclerView.Adapter<HomePageProductAdapter.PopulerViewHolder>{

    private ItemClickListner itemClickListner;
    private Context context;
    private List<Model> data ;
    public HomePageProductAdapter(Context context, List<Model> data, ItemClickListner itemClickListner) {
        this.context=context;
        this.data=data;
        this.itemClickListner=itemClickListner;
    }

    @NonNull
    @Override
    public PopulerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.home_recycler_item,parent,false);
        return new PopulerViewHolder(v,itemClickListner);
    }

    @Override
    public void onBindViewHolder(@NonNull PopulerViewHolder holder, int position) {
        Glide.with(context).load(data.get(position).getImage()).into(holder.image);
        holder.name.setText(data.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PopulerViewHolder extends RecyclerView.ViewHolder{
        ImageView image,love_img;
        TextView name,price;
        ItemClickListner itemClickListner;
        public PopulerViewHolder(@NonNull View itemView, final ItemClickListner itemClickListner) {
            super(itemView);
            image=itemView.findViewById(R.id.popular_adapter_image);
            love_img=itemView.findViewById(R.id.popular_adapter_love_icon);
            name=itemView.findViewById(R.id.popular_adapter_itemName);
            price=itemView.findViewById(R.id.popular_adapter_priceTV);
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
