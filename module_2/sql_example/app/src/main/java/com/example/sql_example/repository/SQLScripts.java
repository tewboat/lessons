package com.example.sql_example.repository;

public class SQLScripts {
    public static String initUsersDbScript() {
        return "create table user(" +
                "id integer primary key autoincrement," +
                "name text not null," +
                "password text not null" +
                ");";
    }

    public static String insertUserScript(String name, String password) {
        String _name = "\"" + name + "\"";
        String _password = "\"" + password + "\"";

        return "insert into user" +
                "(name, password)" +
                "values" +
                "(" + _name + "," + _password +
                ");";
    }

    public static String getUserScript(String name, String password) {
        String _name = "\"" + name + "\"";
        String _password = "\"" + password + "\"";

        return "select * from user" +
                " where name = " + _name +
                " and password = " + _password +
                ";";
    }

    public static String getAllUsersScript() {
        return "select * from user;";
    }

    public static String getAllUsersScript(int limit) {
        return "select * from user" +
                " limit " + limit +
                ";";
    }

    public static String initUserLinksDbScript(){
        return "create table userlinks " +
                "id integer primary key autoincrement, " +
                "firstID integer, " +
                "secondID integer, " +
                "isConfirm integer " +
                "foreign key(firstID) references user(id), " +
                "foreign key(secondID) references user(id));";
    }


    public static String getUserListScript(int userID){
        return "select u.id, u.name from user u, userlinks ul " +
                "where (ul.firstID = " + userID +
                " or ul.secondID = " + userID + ") and " +
                "(u.id = ul.firstID or u.id = ul.secondID) and " +
                "u.id != " + userID + " and isConfirm = 1;";
    }

}