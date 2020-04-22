package com.example.finalproject.domain;

import androidx.annotation.Nullable;

import com.example.finalproject.repository.HashCodeGenerator;

public class Habit {

    int progress;
    String text;
    String id;

    public Habit(@Nullable String id, String text, int progress){
        this.text = text;
        if(id == null){
            this.id = new HashCodeGenerator().generateID();
        }else{
            this.id = id;
        }
    }

    public String getText() {
        return text;
    }

    public String getId() {
        return id;
    }

    public int getProgress() {
        return progress;
    }

    public void updateText(String text){this.text = text;}
}
