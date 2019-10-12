package ru.samsung.belenkov.animal;

public class Cat extends Animal {
    public void hunt() {
        System.out.println("cat is hunting");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("кошка ест мышку");
    }

    @Override
    public void sleep() {
        super.sleep();
        System.out.println("кошка спит в лукошке");
    }

    @Override
    public void run() {
//        super.run();
        System.out.println("кошка бегает");
    }
}
