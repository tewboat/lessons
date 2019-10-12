package ru.samsung.belenkov;

import java.util.Arrays;
import java.util.Random;

public class Main {

    void doSomething(){
        int авфыавфы = 123;
    }

    public static void main(String[] args) {
        syntaxDemo();
        randStrokeDemo();

        System.out.println(getAverage(1,2,3,4,5,123,123,123,123,123));
    }

    static void syntaxDemo() {
        int[] arrOfNums = {1, 2, 3, 4, 5};

        int[] arrOfNums2 = new int[10];

        int[] arr3 = new int[arrOfNums.length + arrOfNums2.length];

        for (int i = 0; i < arrOfNums.length; i++) {
            arr3[i] = arrOfNums[i];
        }
        for (int i = 0; i < arrOfNums2.length; i++) {
            arr3[arrOfNums.length + i] = arrOfNums2[i];
        }

        for (int i = 0; i < arrOfNums2.length; i++) {
            Random rand = new Random();
            arrOfNums2[i] = rand.nextInt();
        }

        for (int i : arr3) {
            System.out.print(i + ", ");
        }
    }

    static void randStrokeDemo() {
        for (int i = 0; i < 100; i++) {
            System.out.println(generateRandStroke("qwertyuiop[]asdfghjkl;'zxcvbnm,.1234566590", i));
        }
    }

    static String generateRandStroke(String reference, int size) {
        Random random = new Random();
        String randStroke = "";
        for (int i = 0; i < size; i++) {
            char randChar = reference.charAt(random.nextInt(reference.length()));
            randStroke += randChar;
        }

        return randStroke;
    }

    static double getAverage(double... doubles) {
        double sumAllItems = 0;
        for (double i : doubles) sumAllItems += i;

        return sumAllItems / doubles.length;
    }
}
