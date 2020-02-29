package com.example.collections;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListDemo {
    ArrayList<Integer> arrayList = new ArrayList();

    @RequiresApi(api = Build.VERSION_CODES.N)
    ArrayListDemo() {
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(0);
        arrayList.add(20324);

        System.out.println("Коллекция " + arrayList.toString());
        arrayList.add(2);
        arrayList.add(50);
        arrayList.add(-20);
        arrayList.add(30);
        arrayList.add(265);

        System.out.println("Коллекция " + arrayList.toString());

        arrayList.remove(5);

        System.out.println("Коллекция " + arrayList.toString());

        arrayList.remove(5);
        System.out.println("Коллекция " + arrayList.toString());

        ArrayList<Integer> arrayList2 = new ArrayList();
        arrayList2.add(10);
        arrayList2.add(10);
        arrayList2.add(10);
        arrayList2.add(10);

        arrayList.addAll(5, arrayList2);

        System.out.println("Коллекция " + arrayList.toString());

        System.out.println("Коллекция до сортировки" + arrayList.toString());
        Collections.sort(arrayList);

        System.out.println("Коллекция после сортировки" + arrayList.toString());

        ArrayList<User> userList = new ArrayList();
        userList.add(new User("1", "Ivan", "Petrov", 25));
        userList.add(new User("10", "Maria", "Petrova", 20));
        userList.add(new User("5", "Petr", "Ivanov", 12));

        System.out.println("Пользователи до сортировки" + userList.toString());
//        Collections.sort(userList);
        Collections.sort(userList, new UserComparatorToLow());
        System.out.println("Пользователи после сортировки" + userList.toString());


    }

}

class UserComparatorToHight implements Comparator<User> {

    @Override
    public int compare(User currentUser, User nextUser) {
        if (currentUser.age > nextUser.age)
            return 1;
        else if (currentUser.age < nextUser.age)
            return -1;
        else
            return 0;
    }
}

class UserComparatorToLow implements Comparator<User> {

    @Override
    public int compare(User currentUser, User nextUser) {
        if (currentUser.age > nextUser.age)
            return -1;
        else if (currentUser.age < nextUser.age)
            return 1;
        else
            return 0;
    }
}

class User implements Comparable<User> {
    public String id;
    public String name;
    public String surname;
    public int age;

    public User(String id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(User o) {
        if (age > o.age)
            return 1;
        else if (age < o.age)
            return -1;
        else
            return 0;
    }
}
