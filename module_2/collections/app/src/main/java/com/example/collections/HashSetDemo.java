package com.example.collections;

import android.util.Log;

import java.util.HashSet;
import java.util.Objects;

class Human {
    final double weight;
    final double height;

    public Human(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "\nHuman{" +
                "weight=" + weight +
                ", height=" + height +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

//        Human human = (Human) o;
//        return weight == human.weight &&
//                Double.compare(human.height, height) == 0;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, height);
    }
}

public class HashSetDemo {

    HashSetDemo() {
        HashSet<Integer> intSet = new HashSet<>();
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);
        intSet.add(5);
        intSet.add(5);
        intSet.add(1);
        intSet.add(25);
        intSet.add(10);

        Log.d("HASH", "intSet: " + intSet.toString());


        HashSet<String> stringSet = new HashSet<>();
        stringSet.add("blabla");
        stringSet.add("12312312");
        stringSet.add("4555234");
        stringSet.add("lalala");
        stringSet.add("blabla");

        Log.d("HASH", "stringSet: " + stringSet.toString());

        HashSet<Human> humanSet = new HashSet();
        humanSet.add(new Human(80, 1.80));
        humanSet.add(new Human(75, 1.70));
        humanSet.add(new Human(80, 1.80));
        humanSet.add(new Human(1.80, 80));

        Log.d("HASH", "humanSet: " + humanSet.toString());
    }
}
