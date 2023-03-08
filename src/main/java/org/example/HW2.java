package org.example;

import java.util.Scanner;

public class HW2 {
    static Scanner iScanner = new Scanner(System.in);
    public static void main(String[] args){
        /**
         *
         1. Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).
         2. Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).
         3.* Напишите программу, чтобы перевернуть строку с помощью рекурсии.
         4. Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
         5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
         6. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
         7.* Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.
         */

        //1. Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).
        text("Введите строку 1: ");
        String str1 = iScanner.nextLine().toLowerCase();
        text("Введите строку 2: ");
        String str2 = iScanner.nextLine().toLowerCase();
        compare(str1, str2);

        // 2. Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).
        compareReverse(str1, str2);

    }
    static void text(String qwt){
        System.out.println(qwt);
    }
    static void compare(String str1, String str2){
        if ((str1.contains(str2) || str2.contains(str1))) {
            text("Есть вхождение в строке");
        } else {
            text("Вхождение  отсутствует");
        }
    }

    static void compareReverse(String str1, String str2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (sb1.append(str1).reverse().toString().contains(str2) || sb2.append(str2).reverse().toString().contains(str1)) {
            text("Cтроки являются вращением друг друга");
        } else {
            text("Не являются вращением.");
        }
    }

}
