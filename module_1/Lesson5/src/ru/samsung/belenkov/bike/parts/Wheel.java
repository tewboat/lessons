package ru.samsung.belenkov.bike.parts;

public class Wheel {
    int wheelSize;
    String wheelName;

   public Wheel(int wheelSize, String wheelName) {
        this.wheelName = wheelName;
        this.wheelSize = wheelSize;
    }

    public void rotate() {
        System.out.println(wheelName + " колесо начало вращение");
    }

   public  void stopRotate() {
        System.out.println(wheelName + " колесо прекратило вращение");
    }
}
