package ru.samsung.belenkov.g2;

import java.util.Scanner;

public class TicTacToe {

    int[][] gameBoard = new int[3][3];

    Scanner scanner = new Scanner(System.in);

    String playerX = "X", playerO = "O", currentPlayer = playerX;

    boolean isWin, isDraw;

    TicTacToe() {
        while (true) {
            initGameBoard();
            initGameLoop();
        }
    }

    void initGameLoop() {
        while (!isWin || !isDraw) {
            int rowTurn = readCoord("строку");
            if (!checkRange(rowTurn)) {
                System.out.println("Выход за границы поля");
                continue;
            }
            int colTurn = readCoord("столбец");
            if (!checkRange(colTurn)) {
                System.out.println("Выход за границы поля");
                continue;
            }
            if (checkSpace(rowTurn, colTurn)) {
                gameBoard[rowTurn][colTurn] = getCurrentPlayer();
            } else {
                System.out.println("Ячейка уже занята!");
                continue;
            }
            changePlayer();
            drawGameBoard();
        }
    }

    int readCoord(String description) {
        System.out.println("Введите " + description);
        return scanner.nextInt();
    }

    boolean checkRange(int coord) {
        return coord >= 0 && coord <= gameBoard.length - 1;
    }

    boolean checkSpace(int coordX, int coordY) {
        return gameBoard[coordX][coordY] == 0;
    }

    int getCurrentPlayer() {
        return currentPlayer.equalsIgnoreCase(playerX) ? 1 : 2;
    }

    void changePlayer() {
        currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
    }

    void initGameBoard() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[row].length; col++) {
                gameBoard[row][col] = 0;
            }
        }
    }

    void drawGameBoard() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[row].length; col++) {
                switch (gameBoard[row][col]) {
                    case 0:
                        System.out.print("  ");
                        break;
                    case 1:
                        System.out.print(" X ");
                        break;
                    case 2:
                        System.out.print(" O ");
                        break;
                }
                if (col != gameBoard[row].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row != gameBoard.length - 1) {
                System.out.println("------------");
            }
        }
        System.out.println();
    }

}
