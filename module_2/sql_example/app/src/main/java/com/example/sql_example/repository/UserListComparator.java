package com.example.sql_example.repository;

import com.example.sql_example.domain.UserProfiles;

import java.util.Comparator;

public class UserListComparator implements Comparator<UserProfiles> {
    @Override
    public int compare(UserProfiles o1, UserProfiles o2) {
        return o1.name.compareTo(o2.name);
    }
}
