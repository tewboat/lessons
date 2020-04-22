package com.example.finalproject.repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.finalproject.domain.Goal;
import com.example.finalproject.domain.Habit;
import com.example.finalproject.domain.Step;
import com.example.finalproject.domain.Todo;

import java.util.ArrayList;

public class DatabaseRepository {
    DatabaseHelper databaseHelper;
    private final String TAG = "DatabaseHelper";

    public DatabaseRepository(Context context){
        initDb(context);
    }

    private void initDb(Context context){
        databaseHelper = new DatabaseHelper(context, "TodoDb", null, 1);
    }

    public void insertTodo(Todo todo){
        Log.d(TAG, "insertTodo: getting WritableDatabase");
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Log.d(TAG, "insertTodo: WritableDatabase got");
        Log.d(TAG, "insertTodo: starting inserting script");
        db.execSQL(SQLScripts.insertObjIntoTodoDatabaseScript(todo));
        Log.d(TAG, "insertTodo: inserting script done");
        db.close();
    }

    public ArrayList<Todo> getTodoList(){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(SQLScripts.getTodoListScript(), null);
        if(cursor.moveToFirst()){
          int idColIndex = cursor.getColumnIndex("id");
          int textColIndex = cursor.getColumnIndex("todoText");
          int reminderTomeColIndex = cursor.getColumnIndex("reminderTime");
          int isDoneColIndex = cursor.getColumnIndex("isComplete");

          ArrayList<Todo> todoArrayList = new ArrayList<>();
          do{
              Todo todo = new Todo(cursor.getString(idColIndex), cursor.getString(textColIndex), cursor.getInt(isDoneColIndex), cursor.getString(reminderTomeColIndex));
              todoArrayList.add(todo);
          }while(cursor.moveToNext());
          cursor.close();
            db.close();
          return todoArrayList;
        }else{
            cursor.close();
            db.close();
            return new ArrayList<>();
        }
    }

    public void insertGoal(Goal goal){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.execSQL(SQLScripts.insertObjIntoGoalsDatabaseScript(goal));
        db.close();
    }

    public void insertHabit(Habit habit){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.execSQL(SQLScripts.insertObjIntoHabitsDatabaseScript(habit));
        db.close();
    }

    public void insertStep(Goal goal, Step step){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.execSQL(SQLScripts.insertObjIntoStepsDatabaseScript(goal, step));
        db.close();
    }

    public void removeTodo(Todo todo){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.execSQL(SQLScripts.removeObjectFromTodoDatabaseScript(todo));
        db.close();
    }

    public void removeHabit(Habit habit){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.execSQL(SQLScripts.removeObjectFromHabitsDatabaseScript(habit));
        db.close();
    }

    public void removeGoal(Goal goal){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.execSQL(SQLScripts.removeObjectFromGoalsDatabaseScript(goal));
        db.close();
    }

    public void updateHabitDb(Habit habit){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.execSQL(SQLScripts.updateHabitsListScript(habit.getId(), habit.getText(), habit.getProgress()));
        db.close();
    }

    public ArrayList<Goal> getGoalsList(){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(SQLScripts.getGoalsListScript(), null);
        if(cursor.moveToFirst()){
            int textColIndex = cursor.getColumnIndex("goalText");
            int idColIndex = cursor.getColumnIndex("id");
            int progressColIndex = cursor.getColumnIndex("progress");

            ArrayList<Goal> goalsArrayList = new ArrayList<>();
            do{
                Goal goal = new Goal( cursor.getString(idColIndex), cursor.getString(textColIndex), cursor.getString(progressColIndex));
                goalsArrayList.add(goal);
            }while(cursor.moveToNext());
            cursor.close();
            db.close();
            return goalsArrayList;
        }else{
            cursor.close();
            db.close();
            return new ArrayList<>();
        }
    }

    public ArrayList<Habit> getHabitsList(){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(SQLScripts.getHabitsListScript(), null);
        if(cursor.moveToFirst()){
            int textColIndex = cursor.getColumnIndex("habitText");
            int idColIndex = cursor.getColumnIndex("id");
            int progressColIndex = cursor.getColumnIndex("progress");

            ArrayList<Habit> habitsArrayList = new ArrayList<>();
            do{
                Habit habit = new Habit( cursor.getString(idColIndex), cursor.getString(textColIndex), cursor.getInt(progressColIndex));
                habitsArrayList.add(habit);
            }while(cursor.moveToNext());
            cursor.close();
            db.close();
            return habitsArrayList;
        }else{
            cursor.close();
            db.close();
            return new ArrayList<>();
        }
    }

    public ArrayList<Step> getStepList(Goal goal){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(SQLScripts.getStepsListScript(goal), null);
        if(cursor.moveToFirst()){
            int textColIndex = cursor.getColumnIndex("text");
            int idColIndex = cursor.getColumnIndex("id");

            ArrayList<Step> stepsArrayList = new ArrayList<>();
            do{
                Step step = new Step(cursor.getString(idColIndex), cursor.getString(textColIndex));
                stepsArrayList.add(step);
            }while(cursor.moveToNext());
            cursor.close();
            db.close();
            return stepsArrayList;
        }else{
            cursor.close();
            db.close();
            return new ArrayList<>();
        }
    }
}
