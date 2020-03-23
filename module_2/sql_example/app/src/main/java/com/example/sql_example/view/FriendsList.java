package com.example.sql_example.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sql_example.R;
import com.example.sql_example.domain.User;
import com.example.sql_example.interactor.UsersInteractor;

public class FriendsList extends AppCompatActivity {

    User user;
    UsersInteractor interactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);
        user = interactor.getUser(getUserName(), getUserPassword());
    }

    private void init(){
        interactor = new UsersInteractor(this);
    }

    private String getUserName(){
       return getIntent().getStringExtra("USER_NAME");
    }

    private String getUserPassword(){
        return getIntent().getStringExtra("USER_PASSWORD");
    }

}
