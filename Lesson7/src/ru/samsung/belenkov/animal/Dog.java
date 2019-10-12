package ru.samsung.belenkov.animal;

public class Dog extends Animal {

    @Override
    public void sleep() {
//        super.sleep();
        System.out.println("собака спит в будке");
    }

    @Override
    public void eat() {
//        super.eat();
        System.out.println("собака ест кость");
    }

    @Override
    public void run() {
//        super.run();
        System.out.println("собака бегает за почтальоном");
    }
}
