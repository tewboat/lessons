package com.example.sql_example.domain;

import androidx.annotation.NonNull;

public class UserProfiles {
    public final int id;
    public final String name;
    public int isConfirm;

    public UserProfiles(int id, String name, int isConfirm) {
        this.id = id;
        this.name = name;
        this.isConfirm = isConfirm;
    }

    @NonNull
    @Override
    public String toString() {
        return "id = " + id + "\n" +
                "name = " + name + "\n" +
                "isConfirm = " + isConfirm + "\n";
    }
}
