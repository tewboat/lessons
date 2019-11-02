import java.util.List;
import java.util.Scanner;

class Main {
    //primitives
    byte b; // 0..255 8 bit
    short s; // +- 16.5k 16 bit
    int i; // +- 2.5kk 32 bit
    long l;// +- 9kkk 64 bit

    float f; // 32 bit
    double d; // 64 bit

    boolean bool = true; //1 bit

    char ch = 12321;

    String stroke = "dsadsa";

    List<Integer> numList;

    Scanner scan;

    static int a = 5;

    //if else switch demo
    static void logicalDemo() {
        boolean isAuth = false;
        int age = 16;
        if (isAuth || age == 18) {
            System.out.println("Приветствие!");
        } else {
            System.out.println("Please auth");
        }

        if (age == 18) {
            if (age == 20) {
                System.out.println();
            }
        } else if (age == 19) {
            System.out.println();
        } else {
            System.out.println();
        }

        switch (age) {
            case 15:
            case 16:
            case 17:
                System.out.println("меньше < 18");
                break;
            case 18:
                System.out.println("совершеннолетний!");
                break;
            case 19:
                System.out.println("> 18");
                break;
            default:
                System.out.println("Ни одно не выполнилось");
        }
    }

    static void logicalLoopDemo() {
        //logical loops
        boolean isAuth = false;
        String userPass = "12345";
        String userName = "ivanov";
        Scanner scanner = new Scanner(System.in);

        while (!isAuth) {
            System.out.println("input login");
            String inLogin = scanner.nextLine();
            System.out.println("inpit password");
            String inPass = scanner.nextLine();
            if (inLogin.equals(userName) && inPass.equals(userPass)) {
                System.out.println("Auth complete");
                isAuth = true;
            } else {
                System.out.println("Auth failed, try again");
            }
        }
        System.out.println("next.....");

//        do {
//
//        }while ();
    }

    static void numericLoopDemo() throws Exception {
        for (int i = 100; i > 0; i -= 10) {
            System.out.println(i);
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) {
//        double result = 0;
//        Scanner sc = new Scanner(System.in);
//        double a;
//        double b;
//        String answer = "yes";
//        while (answer.equals("yes")) {
//            System.out.println("введите число 1");
//            a = sc.nextDouble();
//            System.out.println("введите число 2");
//            b = sc.nextDouble();
//            System.out.println("введите действие (+, -, * или /)");
//            String operation = sc.next();
//            switch (operation) {
//                case "+":
//                    result = (a + b);
//                    break;
//                case "-":
//                    result = (a - b);
//                    break;
//                case "*":
//                    (result) = (a * b);
//                    break;
//                case "/":
//                    (result) = (a / b);
//            }
//            System.out.println("ответ: " + result);
//            System.out.println("продолжить?");
//            answer = sc.next();
//        }
//        if (answer.equals("stop")){
//            System.out.println("bye, kid!");
//        }
        byte var1 = 0;
        int var2 = 1000;
//        var2 = var1;
        var1 = (byte) var2;
        System.out.println(var1);
    }

    void calculate() {
        calculate();
        calculate(5, 5);
    }

    int calculate(String[] arr) {
        return arr.length;
    }

    int calculate(String stroke) {
        return stroke.length();
    }

    int calculate(int a, int b) {
        return a + b;
    }
}
