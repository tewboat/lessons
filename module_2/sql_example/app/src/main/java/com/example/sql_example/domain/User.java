package com.example.sql_example.domain;

/**
 * Модель данных пользователя
 */
public class User {
    public final int id;
    public final String name;
    public final String password;

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
