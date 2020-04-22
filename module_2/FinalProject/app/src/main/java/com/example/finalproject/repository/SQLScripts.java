package com.example.finalproject.repository;

import com.example.finalproject.domain.Goal;
import com.example.finalproject.domain.Habit;
import com.example.finalproject.domain.Step;
import com.example.finalproject.domain.Todo;

public class SQLScripts {

    public static String initTodoDatabaseSqcript() {
        return "create table todoDatabase(" +
                "id text not null primary key, " +
                "todoText text not null, " +
                "reminderTime text null, " +
                "isComplete integer not null);";
    }

    public static String initHabitsDatabaseScript(){
        return "create table habitsDatabase(" +
                "id text not null primary key, " +
                "habitText text not null, " +
                "progress integer not null);";
    }

    public static String initGoalsDatabaseScript() {
        return "create table goalsDatabase(" +
                "id text not null primary key, " +
                "goalText text not null, " +
                "progress integer not null);";
    }

    public static String initStepsDatabaseScript(){
        return "create table stepsDatabase(" +
                "id text not null primary key, " +
                "parentID text not null, " +
                "text text not null);";
    }

    public static String removeObjectFromTodoDatabaseScript(Todo todo){
        String id = "\"" + todo.getId() + "\"";
        return "delete from todoDatabase " +
                "where id = " + id + ";";
    }

    public static String removeObjectFromHabitsDatabaseScript(Habit habit){
        String id = "\"" + habit.getId() + "\"";
        return "delete from todoDatabase " +
                "where id = " + id + ";";
    }

    public static String removeObjectFromGoalsDatabaseScript(Goal goal){
        String id = "\"" + goal.getID() + "\"";
        return "delete from todoDatabase " +
                "where id = " + id + ";";
    }



    public static String insertObjIntoHabitsDatabaseScript(Habit habit){
        String id = "\"" + habit.getId() + "\"";
        String text = "\"" + habit.getText() + "\"";
        int progress = habit.getProgress();
        return "INSERT INTO habitsDatabase(id, habitText, progress)" +
                "VALUES(" + id + ", " +
                text + ", " +
                progress + ");";
    }

    public static String insertObjIntoTodoDatabaseScript(Todo todo) {
        String id = "\"" + todo.getId() + "\"";
        String text = "\"" + todo.getText() + "\"";
        String reminderTime = null;
        if (todo.getReminderTime() != null) {
            reminderTime = "\"" + todo.getReminderTime() + "\"";
        }
        return "INSERT INTO todoDatabase(id, todoText, reminderTime, isComplete)" +
                "values(" + id + ", " +
                text + ", " +
                reminderTime + ", " +
                todo.getIsComplete() + ");";
    }

    public static String insertObjIntoGoalsDatabaseScript(Goal goal) {
        String id = "\"" + goal.getID() + "\"";
        String text = "\"" + goal.getText() + "\"";
        String progress = "\"" + goal.getProgress() + "\"";
        return "insert into goalsDatabase(id, goalText, progress)" +
                "values(" + id + ", " +
                text + ", " +
                progress + ");";
    }

    public static String insertObjIntoStepsDatabaseScript(Goal goal, Step step){
        String id = "\"" + step.getId() + "\"";
        String parentId = "\"" + goal.getID() + "\"";
        String text = "\"" + step.getText() + "\"";
        return "INSERT INTO stepsDatabase(id, parentID, text)" +
                "VALUES(" + id + ", " +
                parentId + ", " +
                text + ");";
    }

    public static  String updateHabitsListScript(String id, String text, int progress){
        String habitId = "\"" + id + "\"";
        String habitText = "\"" + text + "\"";
        return  "UPDATE habitsDatabase " +
                "SET habitText = " + habitText + ", " +
                "progress = " + progress + " " +
                "WHERE id = " + habitId + ";";
    }

    public static String getGoalsListScript() {
        return "select * from goalsDatabase;";
    }

    public static String getTodoListScript() {
        return "select * from todoDatabase;";
    }

    public static String getHabitsListScript(){return "select * from habitsDatabase;";}

    public static String getStepsListScript(Goal goal){
        String goalID = "\"" + goal.getID() + "\"";
        return "SELECT * FROM stepsDatabase " +
                "WHERE parentID = " + goalID + ";";
    }
}
