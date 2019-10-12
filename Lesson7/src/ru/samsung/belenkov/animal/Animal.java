package ru.samsung.belenkov.animal;

public class Animal {
    String name, breed, type;
    int age, weight;

    public Animal() {
    }

    public Animal(String name, String breed, String type, int age, int weight) {
        this.name = name;
        this.breed = breed;
        this.type = type;
        this.age = age;
        this.weight = weight;
    }

    public void sleep() {
        System.out.println("animal sleep");
    }

    public void eat() {
        System.out.println("animal eat");
    }

    public void run() {
        System.out.println("animal run");
    }

}
