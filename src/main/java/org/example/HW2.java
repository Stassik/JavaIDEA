package org.example;

import java.util.Objects;
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
        text("Задание 1: ");
        text("Введите строку 1: ");
        String str1 = iScanner.nextLine().toLowerCase();
        text("Введите строку 2: ");
        String str2 = iScanner.nextLine().toLowerCase();
        compare(str1, str2);

        // 2. Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).
        text("Задание 2: ");
        compareReverse(str1, str2);

        //4. Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
        text("Задание 3: ");
        text("Введите первое число: ");
        int num1 = iScanner.nextInt();
        text("Введите второе число: ");
        int num2 = iScanner.nextInt();
        long begin = System.currentTimeMillis();                // Первый вариант
        text(generateString(num1, num2).toString());
        long end = System.currentTimeMillis();
        System.out.println("generateString: " + (end - begin) );

        begin = System.currentTimeMillis();                     // Второй вариант
        text(generateString_2(num1, num2).toString());
        end = System.currentTimeMillis();
        System.out.println("generateString_2: " + (end - begin) );

        //5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
        text("Задание 5: ");
        text(changeChar(generateString_2(num1, num2)).toString());

        //6. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
        text("Задание 6: ");
        text(changeCharReplace(generateString_2(num1, num2)).toString());

        //7.* Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.
        StringBuilder strSB = new StringBuilder("=".repeat(10_000));
        begin = System.currentTimeMillis();
        changeCharReplace(strSB);
        end = System.currentTimeMillis();
        System.out.println("Задание 7, StringBuilder: " + (end - begin) );
        //text(changeCharReplace(strSB).toString());

        begin = System.currentTimeMillis();
        changeCharReplace(strSB.toString());
        //text(changeCharReplace(strSB.toString()));
        end = System.currentTimeMillis();
        System.out.println("Задание 7, String: " + (end - begin) );

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
        if (sb1.append(str1).reverse().toString().equals(str2) || sb2.append(str2).reverse().toString().equals(str1)) {
            text("Cтроки являются вращением друг друга");
        } else {
            text("Не являются вращением друг друга.");
        }
    }

    static StringBuilder generateString(int num1, int num2) {
        StringBuilder sb1 = new StringBuilder();
        sb1.append(num1).append(" + ").append(num2).append(" = ").append(num1+num2+"\n")
                        .append(num1).append(" - ").append(num2).append(" = ").append(num1-num2+"\n")
                        .append(num1).append(" * ").append(num2).append(" = ").append(num1*num2+"\n");
        return sb1;
    }

    static StringBuilder generateString_2(int num1, int num2) {
        StringBuilder sb2 = new StringBuilder();
        String [] arrStrings = new String[] {(Integer.toString(num1+num2)), " + ", (Integer.toString(num1-num2)), " - ", (Integer.toString(num1*num2)), " * "};
        for (int i = 0; i < arrStrings.length; i += 2) {
            sb2.append(num1).append(arrStrings[i+1]).append(num2).append(" = ").append(arrStrings[i]+"\n");
        }
        return sb2;
    }

    static StringBuilder changeChar (StringBuilder sb){
        int index = sb.indexOf("=");
        while(index >= 0) {
            sb.insert(index, "равно").deleteCharAt(sb.indexOf("="));
            index = sb.indexOf("=", index + 1);
        }
       return sb;
    }

    static StringBuilder changeCharReplace (StringBuilder sb) {
        int index = sb.indexOf("=");
        while(index >= 0) {
            sb.replace(index, index+1, "равно");
            index = sb.indexOf("=", index + 1);
        }
        return sb;
    }

    static String changeCharReplace (String sb) {
        sb = sb.replace("=", "равно");
        return sb;
    }

}
