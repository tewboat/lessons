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

    public static String getFriendListScript(int userID){
        return "select u.id, u.name from user u, userlinks ul " +
                "where (ul.firstID = " + userID +
                " or ul.secondID = " + userID + ") and " +
                "(u.id = ul.firstID or u.id = ul.secondID) and " +
                "u.id != " + userID + " and isConfirm = 1;";
    }

    public static String getReceivedRequestsListScript(int userID){
        return "select u.id, u.name from user u, userlinks ul " +
                "where ul.secondID = " + userID + " and " +
                "isConfirm = -1 and u.id = ul.firstID;";
    }

    public static String getSentRequestsListScript(int userID){
        return "select u.id, u.name from user u, userlinks ul " +
                "where ul.firstID = " + userID + " and " +
                "isConfirm = -1 and u.id = ul.secondID;";
    }

    public static String getUnfriendedUserListScript(int userID){
        return "select u.id, u.name from user u, userlinks ul " +
                "where u.id != ul.firstID and u.id != ul.secondID" +
                "and u.id != " + userID + ";";
    }

    public static String getDeletingLinkScript(int firstUserID, int secondUserID){
        return "delete from userlinks " +
                "where (firstID = " + firstUserID + " or secondID = " + firstUserID +") and " +
                "(firstID = " + secondUserID + " or secondID = " + secondUserID + ");";
    }

    public static String getAddingLinkScript(int firstUserID, int secondUserID){
        return "insert into userlinks(firstID, secondID, isConfirm)" +
                "values(" + firstUserID + ", " + secondUserID + ", -1);";
    }

    public static String getUpdateScript(int firstUserID, int secondUserID){
        return "uptade userlinks set isConfirm = 1 " +
                "where (firstID = " + firstUserID + " or firstID = " + secondUserID + ")" +
                "and (secondID = " + firstUserID + " or secondID = " + secondUserID + ");";
    }
}