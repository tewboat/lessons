package ru.samsung.belenkov;

public class Car {
    private String color = "red", mark;
    private double speed, velocity;

    public Car() {
    }

    public void move() {
        workEngine();
    }

    public void stop() {

    }


    private void workEngine(){
        speed++;
    }

    void paint(String color, String tool) {
        if (tool.equalsIgnoreCase("балончик")) {
            switch (color) {
                case "red":
                case "greem":
                case "blue":
                    this.color = color;
                    System.out.println("Машина перекрашена в " + this.color + " цвет");
                    break;
                default:
                    System.out.println("В такой покрасить нельзя");
            }
        } else {
            System.out.println("С помощью инструмента " + tool + " машину не покрасишь∆");
        }
    }
}
