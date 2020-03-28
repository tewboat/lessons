package com.example.sql_example.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.sql_example.R;
import com.example.sql_example.domain.User;
import com.example.sql_example.domain.UserProfiles;
import com.example.sql_example.interactor.UsersInteractor;
import com.example.sql_example.view.adapter.UsersListAdapter;

import java.util.ArrayList;


public class FriendsList extends AppCompatActivity {
    ImageButton logout;
    Button deleteButton;
    User user;
    UsersInteractor interactor;
    RecyclerView usersListRecyclerView;
    ArrayList<UserProfiles> userProfiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);
        init();
        interactor = new UsersInteractor(this);
        user = interactor.getUser(getUserName(), getUserPassword());
        Log.d("USER", user.toString());
        userProfiles = interactor.getUserProfilesList(user.id);
        UsersListAdapter usersListAdapter = new UsersListAdapter(userProfiles, user);
        usersListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        usersListRecyclerView.setAdapter(usersListAdapter);


    }

    private void init() {
        usersListRecyclerView = findViewById(R.id.users_list_recycler_view);
        logout = findViewById(R.id.logout);
        deleteButton = findViewById(R.id.delete_button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interactor.deleteAllFromTable("userlinks");

            }
        });
    }

    private String getUserName() {
        Log.d("INTENT", "starting USER_NAME receiving");
        String name = getIntent().getStringExtra("USER_NAME");
        Log.d("INTENT", "USER_NAME received");
        return name;
    }

    private String getUserPassword() {
        Log.d("INTENT", "starting USER_PASSWORD receiving");
        String password = getIntent().getStringExtra("USER_PASSWORD");
        Log.d("INTENT", "USER_PASSWORD received");
        return password;
    }

    private void logout() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
