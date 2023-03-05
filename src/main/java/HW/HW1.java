package HW;

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
        int n = requestArg();
        System.out.printf("Факториал числа %d равен %d", n, findFactorial(n));



    }

    static int requestArg() {
        System.out.println("Введите число: ");
        int num = iScanner.nextInt();
        return num;
    }

    static int findFactorial(int num) {
        int fac = 1;
        for (int i = fac; i <= num; i++){
            fac *= i;
        }
        return fac;
    }
}
