package ru.samsung.belenkov.bike.parts;

public class Box {
    public Wheel frontWheel, backWheel;
    public Controller controller;
    public Pedals pedals;

    public Box() {
        frontWheel = new Wheel(15, "переднее");
        backWheel = new Wheel(15, "заднее");
        controller = new Controller();
        pedals = new Pedals(frontWheel, backWheel);
        System.out.println("Велосипед собран");
    }

}
