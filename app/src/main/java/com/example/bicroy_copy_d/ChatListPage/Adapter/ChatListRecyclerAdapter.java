package com.example.bicroy_copy_d.ChatListPage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bicroy_copy_d.R;
import com.example.bicroy_copy_d.RecyclerClickListner.ItemClickListner;

public class ChatListRecyclerAdapter extends RecyclerView.Adapter<ChatListRecyclerAdapter.ChatListViewHolder> {

    private Context context;
    private ItemClickListner recyclerClickListner;
    public ChatListRecyclerAdapter(Context context,ItemClickListner recyclerClickListner) {
        this.context=context;
        this.recyclerClickListner=recyclerClickListner;
    }

    @NonNull
    @Override
    public ChatListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.chat_list_design,parent,false);
        return new ChatListViewHolder(v,recyclerClickListner);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatListViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 5;
    }


    class ChatListViewHolder extends RecyclerView.ViewHolder{
        ImageView image,active;
        TextView name;
        ItemClickListner MyrecyclerClickListner;
        public ChatListViewHolder(@NonNull View itemView, ItemClickListner recyclerClickListner) {
            super(itemView);
            image=itemView.findViewById(R.id.chat_list_userImage);
            active=itemView.findViewById(R.id.chat_list_userActiveImage);
            name=itemView.findViewById(R.id.chat_list_userName);
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