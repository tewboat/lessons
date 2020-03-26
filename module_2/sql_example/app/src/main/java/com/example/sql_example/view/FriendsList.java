package com.example.sql_example.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sql_example.R;
import com.example.sql_example.domain.User;
import com.example.sql_example.interactor.UsersInteractor;
import com.example.sql_example.view.adapter.UsersListAdapter;

public class FriendsList extends AppCompatActivity {

    User user;
    UsersInteractor interactor;
    RecyclerView usersListRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);
        user = interactor.getUser(getUserName(), getUserPassword());
    }

    private void init(){
        interactor = new UsersInteractor(this);
        usersListRecyclerView = findViewById(R.id.users_list_recycler_view);
        UsersListAdapter usersListAdapter = new UsersListAdapter(interactor.getUserList(user.id), user);
        usersListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        usersListRecyclerView.setAdapter(usersListAdapter);
    }

    private String getUserName(){
       return getIntent().getStringExtra("USER_NAME");
    }

    private String getUserPassword(){
        return getIntent().getStringExtra("USER_PASSWORD");
    }

}
