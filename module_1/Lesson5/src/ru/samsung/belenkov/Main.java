package ru.samsung.belenkov;

import ru.samsung.belenkov.bike.Bike;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        long interval = 2000;
        System.out.println("Человек решил покатать на велосипеде");
        Thread.sleep(interval);
        Bike bike = new Bike();
        Thread.sleep(interval);
        System.out.println("ПОIХАЛИ}");
        Thread.sleep(interval);
        bike.move();
        Thread.sleep(interval);
        System.out.println("ХОЧУ ПОВЕРНУТЬ");
        Thread.sleep(interval);
        bike.turn("лево");
        Thread.sleep(interval);
        bike.turn("право");
        Thread.sleep(interval);
        System.out.println("НАДОЕЛО КАТАТЬСЯ");
        Thread.sleep(interval);
        bike.stop();
    }
}
