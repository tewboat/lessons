package ru.samsung.belenkov.bike;

import ru.samsung.belenkov.bike.parts.Box;

public class Bike {
    Box box;

    public Bike() {
        box = new Box();
        System.out.println("Велосипед готов к использованию");
    }

    public void move() {
        box.pedals.move();
        System.out.println("Велосипед начал движение");
    }

    public void stop() {
        box.pedals.brake.stop();
        System.out.println("Велосипед остановился");
    }

    public void turn(String turnSize) {
        box.controller.turn(turnSize);
        System.out.println("Велосипед повернул на" + turnSize);
    }
}
