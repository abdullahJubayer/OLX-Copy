package com.example.bicroy_copy_d.ChatListPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bicroy_copy_d.ChatListPage.Fragment.BuyerList_fragment;
import com.example.bicroy_copy_d.ChatListPage.Fragment.SellerList_fragment;
import com.example.bicroy_copy_d.ChatListPage.ViewModel.ChatListViewModel;
import com.example.bicroy_copy_d.R;


public class ChatListActivity extends AppCompatActivity{

    private RelativeLayout fragmentContainer;
    private TextView buyerList,sellerList;
    private ChatListViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        Toolbar myToolbar=findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        fragmentContainer=findViewById(R.id.chatList_fragment_container);
        buyerList=findViewById(R.id.chat_list_buyer_id);
        sellerList=findViewById(R.id.chat_list_seller_id);
        viewModel= ViewModelProviders.of(this).get(ChatListViewModel.class);


        buyerList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new BuyerList_fragment());
            }
        });

        sellerList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new SellerList_fragment());
            }
        });

    }
    private void loadFragment(Fragment fragment){
             FragmentManager manager=getSupportFragmentManager();
             FragmentTransaction transaction=manager.beginTransaction();
             transaction.addToBackStack(null);
             transaction.replace(R.id.chatList_fragment_container,fragment);
             transaction.commit();
    }

}
