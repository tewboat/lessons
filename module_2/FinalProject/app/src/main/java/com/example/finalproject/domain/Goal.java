package com.example.finalproject.domain;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.finalproject.repository.HashCodeGenerator;

public class Goal {
    HashCodeGenerator hashCodeGenerator = new HashCodeGenerator();
    int stepsDone;
    String text;
    String progress;
    String id;
    public Goal(@Nullable String id, @NonNull String text, String progress){
        this.text = text;
        this.progress = progress;
        this.stepsDone = 0;
        if(id == null){
            this.id = hashCodeGenerator.generateID();
        }else{
            this.id = id;
        }

    }

    public void updateProgress(){
        //TODO
    }

    public String getText() {
        return text;
    }

    public String getProgress() {
        return progress;
    }

    public String getID() {
        return id;
    }
}
