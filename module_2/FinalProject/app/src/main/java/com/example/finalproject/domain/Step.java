package com.example.finalproject.domain;

import androidx.annotation.Nullable;

import com.example.finalproject.repository.HashCodeGenerator;

public class Step {
    String text;
    String id;
    int isDone;
    public Step(@Nullable String id, String text){
        this.text = text;
        isDone = 0;
        if(id == null){
            this.id = new HashCodeGenerator().generateID();
        }else{
            this.id = id;
        }
    }
    public String getText(){return text;}

    public String getId() {
        return id;
    }

    public int getIsDone(){return isDone;}

    public void changeIsDone(){
        switch(this.isDone){
            case 0:
                this.isDone = 1;
                break;
            case 1:
                this.isDone = 0;
                break;
        }
    }
}
