package com.example.sql_example.interactor;

import android.content.Context;

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

    public void addLinkIntoDb(int firstUserID, int secondUserID){
        repository.addLinkIntoBd(firstUserID, secondUserID);
    }
    public void updateDb(int firstUserID, int secondUserID){
        repository.updateDb(firstUserID, secondUserID);
    }

}
