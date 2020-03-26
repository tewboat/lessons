package com.example.sql_example.domain;

public class UserProfiles {
    public final int id;
    public final String name;
    public int isConfirm;

    public UserProfiles(int id, String name, int isConfirm) {
        this.id = id;
        this.name = name;
        this.isConfirm = isConfirm;
    }
}
