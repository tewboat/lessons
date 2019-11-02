package ru.samsung.belenkov;

public class Rectangle extends Figure {
    int a;

    public Rectangle(int a) {
        this.a = a;
    }

    @Override
    public int getSquare() {
        return a * a;
    }
}
