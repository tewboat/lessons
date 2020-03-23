package com.example.sql_example.repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sql_example.domain.User;
import com.example.sql_example.domain.UserProfiles;

import java.util.ArrayList;

public class DatabaseRepository {
    private final String TAG = "DatabaseRepository";
    private DatabaseHelper databaseHelper;

    public DatabaseRepository(Context context) {
        initDb(context);
    }

    private void initDb(Context context) {
        databaseHelper = new DatabaseHelper(context, "UserDb", null, 1);
    }

    public boolean insertUser(String name, String password) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        if (getUser(name, password) != null) {
            return false;
        } else {
            db.execSQL(SQLScripts.insertUserScript(name, password));
            return true;
        }
    }

    public User getUser(String name, String password) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor userCursor = db.rawQuery(SQLScripts.getUserScript(name, password), null);
        // Cтавим позицию курсора на первую строку выборки
        // Eсли в выборке нет строк, вернется false
        if (userCursor.moveToFirst()) {
            // определяем номера столбцов по имени в выборке
            int idColIndex = userCursor.getColumnIndex("id");
            int nameColIndex = userCursor.getColumnIndex("name");
            int passwordColIndex = userCursor.getColumnIndex("password");

            do {
                // получаем значения по номерам столбцов
                User user = new User(userCursor.getString(idColIndex),
                        userCursor.getString(nameColIndex),
                        userCursor.getString(passwordColIndex));
                userCursor.close();
                return user;
                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (userCursor.moveToNext());
        } else {
            userCursor.close();
            return null;
        }
    }

    public ArrayList<User> getUsers(int limit) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor userCursor = db.rawQuery(SQLScripts.getAllUsersScript(limit), null);
        // Cтавим позицию курсора на первую строку выборки
        // Eсли в выборке нет строк, вернется false
        if (userCursor.moveToFirst()) {
            // определяем номера столбцов по имени в выборке
            int idColIndex = userCursor.getColumnIndex("id");
            int nameColIndex = userCursor.getColumnIndex("name");
            int passwordColIndex = userCursor.getColumnIndex("password");

            ArrayList<User> userList = new ArrayList<User>();
            do {
                // получаем значения по номерам столбцов
                User user = new User(userCursor.getString(idColIndex),
                        userCursor.getString(nameColIndex),
                        userCursor.getString(passwordColIndex));
                userList.add(user);
                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (userCursor.moveToNext());
            userCursor.close();
            return userList;
        } else {
            userCursor.close();
            return null;
        }
    }

    public ArrayList<UserProfiles> getFriendsList(int userID){
        SQLiteDatabase db;
        Cursor userCursor;
        db = databaseHelper.getWritableDatabase();
        userCursor = db.rawQuery(SQLScripts.getFriendListScript(userID), null);

        if(userCursor.moveToFirst()){
            int idColIndex = userCursor.getColumnIndex("id");
            int nameColIndex = userCursor.getColumnIndex("name");

            ArrayList<UserProfiles> friendList = new ArrayList<UserProfiles>();

            do {
                UserProfiles friend = new UserProfiles(userCursor.getString(idColIndex), userCursor.getString(nameColIndex));
                friendList.add(friend);

            } while (userCursor.moveToNext());
            userCursor.close();
            return friendList;
        } else {
            userCursor.close();
            return null;
        }
    }
}
