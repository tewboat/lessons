package com.example.sql_example.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sql_example.R;
import com.example.sql_example.domain.User;
import com.example.sql_example.interactor.UsersInteractor;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView inputLogin;
    EditText inputPassword;
    Button buttonLogin;
    Button buttonRegister;

    UsersInteractor usersInteractor;

    ArrayList<User> lastFiveUsersList = new ArrayList<>();
    ArrayList<String> lastFiveNamesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initListeners();
    }

    private void init() {
        inputLogin = findViewById(R.id.input_login);
        inputPassword = findViewById(R.id.input_pass);
        buttonLogin = findViewById(R.id.loginButton);
        buttonRegister = findViewById(R.id.registerButton);

        usersInteractor = new UsersInteractor(this);
        fillInputLogin();
    }

    private void initListeners() {
        inputLogin.setOnItemClickListener((parent, view, position, id) -> {
            inputPassword.setText(lastFiveUsersList.get(position).password);
        });

        buttonLogin.setOnClickListener((v) -> {
            final String login = inputLogin.getText().toString();
            final String password = inputPassword.getText().toString();
            User user = usersInteractor.getUser(login, password);
            if (user != null) {
                Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show();
            }
        });
        buttonRegister.setOnClickListener((v) -> {
            final String login = inputLogin.getText().toString();
            final String password = inputPassword.getText().toString();
            if (usersInteractor.insertUser(login, password)) {
                Toast.makeText(this, "Registered", Toast.LENGTH_SHORT).show();
                fillInputLogin();
            } else {
                Toast.makeText(this, "User is already there", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fillInputLogin() {
        lastFiveUsersList = usersInteractor.getUsers(5);

        if (lastFiveUsersList != null) {
            lastFiveNamesList.clear();
            for (User user : lastFiveUsersList) {
                lastFiveNamesList.add(user.name);
            }
            inputLogin.setAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_dropdown_item_1line,
                    lastFiveNamesList));
        }
    }

}
