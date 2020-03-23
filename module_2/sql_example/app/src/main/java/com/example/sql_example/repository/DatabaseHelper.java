package com.example.sql_example.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private final String TAG = "DatabaseHelper";

    public DatabaseHelper(Context context,
                          String name,
                          SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "Инициализация базы пользователей");
        db.execSQL(SQLScripts.initUsersDbScript());
        Log.d(TAG, "База пользователей инициализирована");
        Log.d(TAG, "Инициализация базы связей пользователей");
        db.execSQL(SQLScripts.initUserLinksDbScript());
        Log.d(TAG, "База связей пользователей инициализирована");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
