package com.example.httpexample.interactor.user;


import android.widget.TextView;

import com.example.httpexample.domain.user.User;
import com.example.httpexample.repository.jsonplaceholder.JsonPlaceholderParser;

public class UserInteractor implements UserResponse {

    JsonPlaceholderParser parser = new JsonPlaceholderParser();
    TextView textView;

    public UserInteractor(TextView textView) {
        this.textView = textView;
    }

    public void getUsers() {
        new UserTask(parser, this).execute();
    }

    @Override
    public void reponse(User user) {
        System.out.println("Пользователь в главном потоке" + user);
        textView.setText(textView.getText().toString() + user.name);
    }
}

interface UserResponse {
    void reponse(User user);
}
