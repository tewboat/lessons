package ru.samsung.belenkov.g1;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        twoDimArr();
        double[][] arr = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1},};
//        twoDimmArrOps(arr, '+');
        new TicTacToe();
    }

    private static void twoDimmArrOps(double[][] arr, char ops) {
        double result = 0;
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                switch (ops) {
                    case '+':
                        result += arr[row][col];
                        break;
                    case '-':
                        result -= arr[row][col];
                        break;
                    case '*':
                        result *= arr[row][col];
                        break;
                    case '/':
                        result /= arr[row][col];
                        break;
                }
            }
        }

        System.out.println("result = " + result);
    }

    private static void twoDimArr() {
        int[] oneDimArr = new int[0];
        int[][] twoDimArr = new int[5][5];
        String[][] namesTable = {
                {"Иван", "Иванов", "Иванович"},
                {"Петр", "Петров", "Петрович"},
                {"Анна", "Михайловна", "Ивановна"},
                {"Бававы", "авыавы", "авыавы"},};

        for (int row = 0; row < namesTable.length; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < namesTable[row].length; col++) {
                System.out.print(namesTable[row][col] + " ");
            }
            System.out.println();
        }
    }
}
