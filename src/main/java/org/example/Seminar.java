package org.example;
import java.util.Arrays;
import java.util.Scanner;

public class Seminar {
    static Scanner iScanner = new Scanner(System.in);
    public static void main(String[] args) {
        //getName();                                            //Задача 1
        //int[] arr = new int[]{1, 1, 1, 1, 0, 1, 1, 1};        // Задача 2
        //System.out.println(countNum(arr));
        int[] nums = new int[]{1,3,3,3,2,3,4,5,3};                  // Задача 3
        int val = 3;
        System.out.println(Arrays.toString(correctArr(nums, val)));
    }

    static String scanName() {
        String name = iScanner.nextLine();
        return name;
    }

    static void getName(){
        System.out.println("Введите свое имя: ");
        System.out.printf("Добрый день, %s!", scanName());
    }

    /**
     * Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное количество подряд идущих 1.
     */
    static short countNum(int[] arr) {
        short count = 0;
        short max = 0;
        for (int item: arr) {
            if (item == 1) {
                count++;
                if (count > max) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }
        return max;
    }

    /**
     * Дан массив nums = [3,2,2,3,4,5,3] и число val = 3.
     * Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
     * Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.
     * Вывод:
     * [2,2,4,5,3,3,3]
     */

    static int[] correctArr(int [] arr, int num){
//        int temp = 0;
//        for(int i = 0; i < arr.length; i++){
//            for (int j = 0; j < arr.length-1; j++) {
//                if (arr[j] == num) {
//                    temp = arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = temp;
//                }
//            }
//        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != num) {
                arr[count++] = arr[i];
            }
        }
        while (count < arr.length) {
            arr[count++] = num;
        }
        return arr;
    }

}