package com.example.threads;

public class ThrowsDemo {


    ThrowsDemo() {
        try {
            method1();
            method2();
            method3();
            method4();
        } catch (ArithmeticException e) {

        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }

    private void method4() {
    }

    private void method3() {

    }

    private void method2() throws ArrayIndexOutOfBoundsException {
        String[] a = {"a", "b", "c"};
    }

    private void method1() throws ArithmeticException {
        System.out.println(1 / 0);
    }
}
