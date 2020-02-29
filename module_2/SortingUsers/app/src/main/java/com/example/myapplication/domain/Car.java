package com.example.myapplication.domain;

public class Car {

    public final String name;
    public final String model;
    public final int power;
    public final double volume;
    public final int mileage;

    public Car(String name, String model, int power, double volume, int mileage) {
        this.name = name;
        this.model = model;
        this.power = power;
        this.volume = volume;
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", power=" + power +
                ", volume=" + volume +
                ", mileage=" + mileage +
                '}';
    }
}
