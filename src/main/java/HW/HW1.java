package HW;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), а так же n! (произведение чисел от 1 до n)
    Ввод:5
    Треугольное число 1 + 2 + 3 + 4 + 5 = 15
    n! 1 * 2 * 3 * 4 * 5 = 120

 2. Вывести все простые числа от 1 до 1000

 3. Реализовать простой калькулятор (+ - / *)
     Ввод числа ->
     Ввод знака ->
     Ввод числа ->

 4.*(ДОПОЛНИТЕЛЬНАЯ) +Задано уравнение вида q + w = e, q, w, e >= 0.
     Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69 (пользователь).
     Требуется восстановить выражение до верного равенства.
     Предложить хотя бы одно решение или сообщить, что его нет.
     Ввод: 2? + ?5 = 69
     Вывод: 24 + 45 = 69
 */
public class HW1 {
    static Scanner iScanner = new Scanner(System.in);
    public static void main (String[] args) {
        System.out.println("Задание 1: ");
            int n = Integer.parseInt(requestArg("Введите число: "));
            System.out.printf("Треугольное число числа %d равно %d\n", n, findTriangular(n));
            System.out.printf("Факториал числа %d равен %d\n", n, findFactorial(n));

        System.out.println("Задание 2: ");
            System.out.println(findPrimeNumbers());

        System.out.println("Задание 3: ");
            double numb1 = Integer.parseInt(requestArg("Введите первое число: "));
            double numb2 = Integer.parseInt(requestArg("Введите второе число: "));
            String math = requestArg("Введите математическую операцию: ");
            System.out.println(calculate(numb1, numb2, math));


    }

    static String requestArg(String str) {
        System.out.println(str);
        String num = iScanner.nextLine();
        return num;
    }

    static int findTriangular(int num) {
        int trgl = 0;
        for (int i = trgl; i <= num; i++){
            trgl += i;
        }
        return trgl;
    }

    static int findFactorial(int num) {
        int fac = 1;
        for (int i = fac; i <= num; i++){
            fac *= i;
        }
        return fac;
    }

    static String findPrimeNumbers(){
        String primeNum = "";
        for (int i = 2; i <= 1000; i++){
            int count = 0;
            for (int j = 2; j <= i; j++){
                if (i%j==0) {
                count++;
                }
            }
            if (count == 1) {
                String newElem = Integer.toString(i);
                primeNum = String.join(",", newElem, primeNum);
            }
        }
        return primeNum;
    }

    static double calculate(double n1, double n2, String m) {
        double res = 0;
        if (Objects.equals(m, "+")) {res = n1 + n2;}
        else if (Objects.equals(m, "-")) {res = n1 - n2;}
        else if (Objects.equals(m, "*")) {res = n1 * n2;}
        else if (Objects.equals(m, "/")) {res = n1 / n2;}
        return res;
    }
}
