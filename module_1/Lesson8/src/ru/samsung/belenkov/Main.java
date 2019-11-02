package ru.samsung.belenkov;

public class Main {

    public static void main(String[] args) {
        Car car = new Car();
        car.move();
        car.paint("red", "балончик");
        car.paint("авыаыв", "балончик");
        car.paint("red", "авыавыаыв");

    }
}
