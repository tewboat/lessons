package ru.samsung.belenkov.g2;

public class Main {

    public static void main(String[] args) {
//        twoDimensionsArraysDemo();
        new TicTacToe();
    }

    static void twoDimensionsArraysDemo() {
        String[][] users = {{"Ivanov", "Ivan", "Ivanich"},
                {"Petrov", "Petr", "Petrovich"},
                {"Fdsfds", "fdsfdsfsd", "fsdfdsfsd"},
                {"213123", "21312312", "21321312"},};

        for (int row = 0; row < users.length; row++) {
            for (int col = 0; col < users[row].length; col++) {
                System.out.print(users[row][col] + " ");
            }
            System.out.println();
        }
    }
}
