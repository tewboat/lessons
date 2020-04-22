package com.example.finalproject.domain;

import androidx.annotation.NonNull;

import com.example.finalproject.repository.HashCodeGenerator;

public class Todo {
    String text;
    int isComplete;
    String reminderTime;
    String id;
    HashCodeGenerator hashCodeGenerator = new HashCodeGenerator();
    public Todo(String id, String text, int isComplete ,String reminderTime){
        this.text = text;
        this.isComplete = isComplete;
        this.reminderTime = reminderTime;
        if(id == null){
            this.id = hashCodeGenerator.generateID();
        }else{
            this.id = id;
        }
    }

    public String getText(){return text;}

    public int getIsComplete(){return isComplete;}

    public void setText(String text){this.text = text;}

    public void setIsComplete(){
        if(isComplete == 1){
            isComplete = 0;
        }
        else{
            isComplete = 1;
        }
    }

    public String getReminderTime() {
        return reminderTime;
    }

    @NonNull
    @Override
    public String toString() {
        return text;
    }

    public String getId() {
        return id;
    }

}
