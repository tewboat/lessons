package com.example.sql_example.repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sql_example.domain.User;
import com.example.sql_example.domain.UserProfiles;

import java.util.ArrayList;
import java.util.Comparator;

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
                User user = new User(userCursor.getInt(idColIndex),
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

            ArrayList<User> userList = new ArrayList<>();
            do {
                // получаем значения по номерам столбцов
                User user = new User(userCursor.getInt(idColIndex),
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

    public void getFriendsList(int userID, ArrayList<UserProfiles> userProfilesArrayList){
        SQLiteDatabase db;
        Cursor userCursor;
        db = databaseHelper.getWritableDatabase();
        userCursor = db.rawQuery(SQLScripts.getFriendListScript(userID), null);

        if(userCursor.moveToFirst()){
            int idColIndex = userCursor.getColumnIndex("id");
            int nameColIndex = userCursor.getColumnIndex("name");

            do {
                UserProfiles friend = new UserProfiles(userCursor.getInt(idColIndex), userCursor.getString(nameColIndex), 1);
                userProfilesArrayList.add(friend);

            } while (userCursor.moveToNext());
            userCursor.close();
        } else {
            userCursor.close();
        }
    }
    public void getReceivedRequestsList(int userID, ArrayList<UserProfiles> userProfilesArrayList){
        SQLiteDatabase db;
        Cursor userCursor;
        db = databaseHelper.getWritableDatabase();
        userCursor = db.rawQuery(SQLScripts.getReceivedRequestsListScript(userID), null);

        if(userCursor.moveToFirst()){
            int idColIndex = userCursor.getColumnIndex("id");
            int nameColIndex = userCursor.getColumnIndex("name");

            do {
                UserProfiles friend = new UserProfiles(userCursor.getInt(idColIndex), userCursor.getString(nameColIndex), -1);
                userProfilesArrayList.add(friend);

            } while (userCursor.moveToNext());
            userCursor.close();
        } else {
            userCursor.close();
        }
    }

    public void getSentRequestsList(int userID, ArrayList<UserProfiles> userProfilesArrayList){
        SQLiteDatabase db;
        Cursor userCursor;
        db = databaseHelper.getWritableDatabase();
        userCursor = db.rawQuery(SQLScripts.getSentRequestsListScript(userID), null);

        if(userCursor.moveToFirst()){
            int idColIndex = userCursor.getColumnIndex("id");
            int nameColIndex = userCursor.getColumnIndex("name");


            do {
                UserProfiles friend = new UserProfiles(userCursor.getInt(idColIndex), userCursor.getString(nameColIndex), -2);
                userProfilesArrayList.add(friend);

            } while (userCursor.moveToNext());
            userCursor.close();
        } else {
            userCursor.close();
        }
    }

    public void getUnfriendedUserListScript(int userID, ArrayList<UserProfiles> userProfilesArrayList){
        SQLiteDatabase db;
        Cursor userCursor;
        db = databaseHelper.getWritableDatabase();
        userCursor = db.rawQuery(SQLScripts.getUnfriendedUserListScript(userID), null);

        if(userCursor.moveToFirst()){
            int idColIndex = userCursor.getColumnIndex("id");
            int nameColIndex = userCursor.getColumnIndex("name");


            do {
                UserProfiles friend = new UserProfiles(userCursor.getInt(idColIndex), userCursor.getString(nameColIndex), 0);
                userProfilesArrayList.add(friend);

            } while (userCursor.moveToNext());
            userCursor.close();

        } else {
            userCursor.close();
        }
    }

    public void deleteLinkFromDb(int firstUserID, int secondUserID){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.execSQL(SQLScripts.getDeletingLinkScript(firstUserID, secondUserID));
    }

    public void addLinkIntoBd(int firstUserID, int secondUserID, int isConfirm){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.execSQL(SQLScripts.getAddingLinkScript(firstUserID, secondUserID, isConfirm));
        //firstUser - отправитель
        //secondUser - получатель
        // 1 - true | -1 - false
    }

    public void updateDb(int firstUserID, int secondUserID){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.execSQL(SQLScripts.getUpdateScript(firstUserID, secondUserID));
    }
    public ArrayList<UserProfiles> getAllUsersListScript(int userID){
        SQLiteDatabase db;
        Cursor userCursor;
        db = databaseHelper.getWritableDatabase();
        userCursor = db.rawQuery(SQLScripts.getAllUsersScript(userID, true), null);
        ArrayList<UserProfiles> userProfilesArrayList = new ArrayList<>();
        if(userCursor.moveToFirst()){
            int idColIndex = userCursor.getColumnIndex("id");
            int nameColIndex = userCursor.getColumnIndex("name");


            do {
                UserProfiles friend = new UserProfiles(userCursor.getInt(idColIndex), userCursor.getString(nameColIndex), 0);
                userProfilesArrayList.add(friend);

            } while (userCursor.moveToNext());
            userCursor.close();
            return userProfilesArrayList;

        } else {
            userCursor.close();
            return null;
        }
    }

    public void deleteAllFromTable(String tableName){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.execSQL(SQLScripts.deleteAllFromTable(tableName));
    }

    public void initTable(){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.execSQL(SQLScripts.initUsersDbScript());
        db.execSQL(SQLScripts.initUserLinksDbScript());
    }
}

