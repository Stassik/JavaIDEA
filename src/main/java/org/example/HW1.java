package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class HW1 {
    /**
     1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
     2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
     3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
     4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

     Пункты реализовать в методе main
     *Пункты реализовать в разных методах

     int i = new Random().nextInt(k); //это кидалка случайных чисел!)
     */
    static Scanner iScanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Задание 1");
        int i = getRandomInt();                // 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
        System.out.printf("Случайное целое число: %d\n", i);
        int n = getMaxBinaryNum(i);            // 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        System.out.printf("Старший значащий бит: %d\n", n);
        int arrLenMul = findMultiplesArrLength(i, n);
        int[] m1 = findMultiples(i, n, arrLenMul); // 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
        System.out.printf("Числу %d кратны %d чисел\n", n, arrLenMul);
        //System.out.println(Arrays.toString(m1));     // Можно разкомментировать для наглядности
        int arrLen = findNonMultiplesArrLength(i, n);
        int[] m2 = findNonMultiples(i, n, arrLen); // 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
        System.out.printf("Числу %d некратны %d чисел\n", n, arrLen);
        //System.out.println(Arrays.toString(m2));     // Можно разкомментировать для наглядности

    }

    static int getValue() {
        System.out.println("Введите максимальное число диапазона: ");
        return Integer.parseInt(iScanner.nextLine());
    }
    static int getRandomInt(){
        return new Random().nextInt(getValue());
    }

    static int getMaxBinaryNum(int i){
        System.out.printf("Число %d  в битовом представлении: %s\n", i, Integer.toBinaryString(i));
        return Integer.toBinaryString(i).length();
    }
    static int findMultiplesArrLength(int i, int n){
        int len = 0;
        for(int j = i; j < Short.MAX_VALUE; j++ ) {
            if (j % n == 0) {
                len++;
            }
        }
        return len;
    }
    static int[] findMultiples(int i, int n, int len) {
        int[] arr = new int[len];
        int k = 0;
        for(int j = i; j < Short.MAX_VALUE; j++ ) {
            if (j % n == 0) {
                arr[k] = j;
                k++;
            }
        }
        return arr;
    }

    static int findNonMultiplesArrLength(int i, int n){
        int len = 0;
        for(int j = Short.MIN_VALUE; j < i; j++ ) {
            if (j % n != 0) {
                len++;
            }
        }
        return len;
    }
    static int[] findNonMultiples(int i, int n, int len) {
        int[] arr = new int[len];
        int k = 0;
        for(int j = Short.MIN_VALUE; j < i; j++ ) {
            if (j % n != 0) {
                arr[k] = j;
                k++;
            }
        }
        return arr;
    }




}
