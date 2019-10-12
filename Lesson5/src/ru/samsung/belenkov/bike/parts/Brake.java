package ru.samsung.belenkov.bike.parts;

public class Brake {
    public Wheel backWheel, fromWheel;

    public Brake(Wheel backWheel, Wheel frontWheel) {
        this.backWheel = backWheel;
        this.fromWheel = frontWheel;
    }

    public void stop() {
        System.out.println("Нажали тормоз...");
        backWheel.stopRotate();
        fromWheel.stopRotate();
    }
}
