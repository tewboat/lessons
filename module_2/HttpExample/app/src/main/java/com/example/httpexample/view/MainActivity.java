package com.example.httpexample.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.httpexample.R;
import com.example.httpexample.interactor.user.UserInteractor;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView userNameTextView = findViewById(R.id.userNameTextView);
        new UserInteractor(userNameTextView).getUsers();
    }

}
