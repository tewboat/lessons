package ru.samsung.belenkov;

import ru.samsung.belenkov.animal.Animal;
import ru.samsung.belenkov.animal.Cat;
import ru.samsung.belenkov.animal.Dog;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Cat cat = new Cat();
        Dog dog = new Dog();

//        animal.sleep();
        cat.sleep();
//        dog.sleep();

//        new Window();

        Scanner scanner = new Scanner(System.in);
        System.out.println("введите сторону квадрата");
        Rectangle rect = new Rectangle(scanner.nextInt());
        System.out.println("Создан квадрат с площадью " + rect.getSquare());
    }
}
