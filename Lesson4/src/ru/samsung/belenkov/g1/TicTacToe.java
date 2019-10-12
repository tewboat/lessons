package ru.samsung.belenkov.g1;

import java.util.Scanner;

public class TicTacToe {

    int[][] gameBoard = new int[3][3];

    Scanner scanner = new Scanner(System.in);

    String playerX = "X", playerO = "O", currentPlayer = playerX;

    boolean isWin = false;

    boolean isDraw = false;

    int turnX, turnY;

    TicTacToe() {
        initGameBoard();
        while (!isWin || !isDraw) {
            drawGameBoard();
            System.out.println("Ходит " + currentPlayer);
            System.out.print("Выберите строку: ");
            turnX = scanner.nextInt();
            if (!checkTurn(turnX)) {
                System.out.println("Выход за границы поля!");
                continue;
            }
            System.out.print("Выберите столбец: ");
            turnY = scanner.nextInt();
            if (!checkTurn(turnY)) {
                System.out.println("Выход за границы поля!");
                continue;
            }

            if (makeTurn(turnX, turnY)) {
                gameBoard[turnX][turnY] = currentPlayer.equalsIgnoreCase(playerX) ? 1 : 2;
            } else {
                System.out.println("По координатам : " + turnX + ", " + turnY + " ходить нельзя");
                continue;
            }

            currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
        }
    }

    boolean makeTurn(int x, int y) {
        return gameBoard[x][y] == 0;
    }

    boolean checkTurn(int coord) {
        return coord < 3;
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
                if (col != gameBoard[row].length - 1)
                    System.out.print("|");
            }
            System.out.println();
            if (row != gameBoard.length - 1)
                System.out.println("-----------");
        }
    }
}
