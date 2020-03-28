package com.example.sql_example.interactor;

import android.content.Context;
import android.util.Log;

import com.example.sql_example.domain.User;
import com.example.sql_example.domain.UserProfiles;
import com.example.sql_example.repository.DatabaseRepository;
import com.example.sql_example.repository.UserListComparator;

import java.util.ArrayList;
import java.util.Collections;

public class UsersInteractor {
    private DatabaseRepository repository;

    public UsersInteractor(Context context) {
        repository = new DatabaseRepository(context);
    }

    public boolean insertUser(String name, String password) {
        return repository.insertUser(name, password);
    }

    public User getUser(String name, String password) {
        return repository.getUser(name, password);
    }

    public ArrayList<User> getUsers(int limit) {
        return repository.getUsers(limit);
    }

    public ArrayList<UserProfiles> getUserList(int userID){
        ArrayList<UserProfiles> userProfilesArrayList = new ArrayList<>();
        UserListComparator comparator = new UserListComparator();
        repository.getFriendsList(userID, userProfilesArrayList);
        repository.getReceivedRequestsList(userID, userProfilesArrayList);
        repository.getSentRequestsList(userID, userProfilesArrayList);
        repository.getUnfriendedUserListScript(userID, userProfilesArrayList);
        Collections.sort(userProfilesArrayList, comparator);
        return userProfilesArrayList;
    }

    public void deleteLinkFromDb(int firstUserID, int secondUserID){
        repository.deleteLinkFromDb(firstUserID, secondUserID);}

    public void addLinkIntoDb(int firstUserID, int secondUserID, int isConfirm){
        repository.addLinkIntoBd(firstUserID, secondUserID, isConfirm);
    }
    public void updateDb(int firstUserID, int secondUserID){
        repository.updateDb(firstUserID, secondUserID);
    }

    public ArrayList<UserProfiles> getAllUserList(int userID){
        return repository.getAllUsersListScript(userID);
    }
    public void deleteAllFromTable(String tableName){
        repository.deleteAllFromTable(tableName);
    }

    public void initTable(){
        repository.initTable();
    }
    public ArrayList<UserProfiles> getUserProfilesList(int userID){
        ArrayList<UserProfiles> userProfiles = new ArrayList<>();
        userProfiles = getUserList(userID);
        Log.d("UserListTAG", userProfiles.toString());
        if (userProfiles.size() == 0) {
            Log.d("UserListTAG", "userProfiles.size() == 0");
            userProfiles = getAllUserList(userID);
            Log.d("UserListTAG", userProfiles.toString());
        }return userProfiles;
    }
}
