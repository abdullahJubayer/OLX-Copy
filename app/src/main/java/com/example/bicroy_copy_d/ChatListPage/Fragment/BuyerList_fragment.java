package com.example.bicroy_copy_d.ChatListPage.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bicroy_copy_d.Activity.ChatActivity;
import com.example.bicroy_copy_d.ChatListPage.Adapter.ChatListRecyclerAdapter;
import com.example.bicroy_copy_d.R;
import com.example.bicroy_copy_d.RecyclerClickListner.ItemClickListner;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuyerList_fragment extends Fragment implements ItemClickListner {

    RecyclerView recyclerView;
    ChatListRecyclerAdapter chatListRecyclerAdapter;
    Context context;
    public BuyerList_fragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buyer_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.buyer_list_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        chatListRecyclerAdapter=new ChatListRecyclerAdapter(context,this);
        recyclerView.setAdapter(chatListRecyclerAdapter);

    }


    @Override
    public void itemClick(int position) {
        startActivity(new Intent(context, ChatActivity.class));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }
}
