package com.example.finalproject.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private final String TAG = "DatabaseHelper";
    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate: start initializing TodoDatabase");
        db.execSQL(SQLScripts.initTodoDatabaseSqcript());
        Log.d(TAG, "onCreate: db initialized");
        Log.d(TAG, "onCreate: start initializing GoalsDatabase");
        db.execSQL(SQLScripts.initGoalsDatabaseScript());
        Log.d(TAG, "onCreate: db initialized");
        Log.d(TAG, "onCreate: start initializing HabitsDatabase");
        db.execSQL(SQLScripts.initHabitsDatabaseScript());
        Log.d(TAG, "onCreate: db initialized");
        Log.d(TAG, "onCreate: start initializing StepsDatabase");
        db.execSQL(SQLScripts.initStepsDatabaseScript());
        Log.d(TAG, "onCreate: db initialized");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
