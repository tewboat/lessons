package ru.samsung.belenkov.bike.parts;

public class Pedals {
    Wheel backWheel, fromWheel;

    public Brake brake;

    public Pedals(Wheel backWheel, Wheel frontWheel) {
        this.backWheel = backWheel;
        this.fromWheel = frontWheel;

        brake = new Brake(this.backWheel, this.fromWheel);
    }

    public void move() {
        System.out.println("Педали начали движение");
        backWheel.rotate();
        fromWheel.rotate();
    }
}
