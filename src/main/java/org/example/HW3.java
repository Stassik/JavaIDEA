package org.example;

import java.util.*;

public class HW3 {
    /**
     *
     1. Реализовать алгоритм сортировки списков слиянием
     2. Пусть дан произвольный список целых чисел, удалить из него чётные числа
     3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
     4. Дано два целочисленных списка, объеденить их не допуская элементы второго списка уже встречающиеся в первом.
     5. Создать ArrayList<Integer> и добавить нулевым эллементом ноль 10000 раз.
     6. Повторить пятый пункт но с LinkedList.
     7. Сравнить время работы пятого и шестого пунктов.

     */
    static Scanner iScanner = new Scanner(System.in);
    public static void main(String[] args) {
        //1. Реализовать алгоритм сортировки списков слиянием
        System.out.println("Введите длину списка: ");
        Integer lenList = iScanner.nextInt();
        ArrayList<Integer> mainList = generateArrayList(lenList);
        System.out.println("Задание 1: ");
        System.out.print("           MainList: ");
        mainList.forEach(n -> System.out.print(n+", "));

        System.out.println();
        System.out.print("           SortedList: ");
        sortMerge(mainList).forEach(n -> System.out.print(n+", "));
        System.out.println();

        //2. Пусть дан произвольный список целых чисел, удалить из него чётные числа
        System.out.print("Задание 2: ");
        mainList = deleteEvenNum(mainList);
        mainList.forEach(n -> System.out.print(n+", "));

        System.out.println();


        // 3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
        System.out.println("Задание 3: ");
        System.out.print("           Max: ");
        int maxNum = findMaxNum(mainList);
        System.out.println(maxNum);

        int minNum = findMinNum(mainList);
        System.out.print("           Min: ");
        System.out.println(minNum);

        int midNum = findMidNum(maxNum, minNum, mainList);
        System.out.print("           Middle: ");
        System.out.println(midNum);


        //4. Дано два целочисленных списка, объеденить их не допуская элементы второго списка уже встречающиеся в первом.
        System.out.println("Задание 4: ");
        System.out.print("           MainList: ");
        mainList.forEach(n -> System.out.print(n+", "));
        System.out.println();
        System.out.print("           SecondList: ");
        ArrayList<Integer> secondList = generateArrayList(lenList);
        secondList.forEach(n -> System.out.print(n+", "));
        System.out.println();
        mainList = unionList(mainList, secondList);
        System.out.print("           UnionList: ");
        mainList.forEach(n -> System.out.print(n+", "));
        System.out.println();


        //5. Создать ArrayList<Integer> и добавить нулевым эллементом ноль 10000 раз.

        ArrayList<Integer> nullList = new ArrayList<>();
        int index = 0;
        long begin1 = System.currentTimeMillis();
        while (index <= 10_000) {
            nullList.add(0, 0);
            index++;
        }
        long end1 = System.currentTimeMillis();
        System.out.print("Задание 5: ");
        nullList.forEach(n -> System.out.print(n+", "));

        System.out.println();
        // 6. Повторить пятый пункт но с LinkedList.

        LinkedList<Integer> nullLinkList = new LinkedList<>();
        int index1 = 0;
        long begin2 = System.currentTimeMillis();
        while (index1 <= 10_000) {
            nullLinkList.add(0, 0);
            index1++;
        }
        long end2 = System.currentTimeMillis();
        System.out.print("Задание 6: ");
        nullLinkList.forEach(n -> System.out.print(n+", "));
        System.out.println();
        //7. Сравнить время работы пятого и шестого пунктов.
        System.out.println("Задание 7 - ArrayList: " + (end1 - begin1) );
        System.out.print("          - LinkedList: " + (end2 - begin2) );

    }

    static ArrayList generateArrayList(Integer len) {
        ArrayList<Integer> list = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            list.add(i, new Random().nextInt(10));
        }
        return list;
    }


    static ArrayList sortMerge (ArrayList<Integer> list) {
        if (list.size()>1) {
            ArrayList <Integer> leftList = new ArrayList<>(list.subList(0, list.size()/2));
            ArrayList <Integer> rightList = new ArrayList<>(list.subList(list.size()/2, list.size()));
            sortMerge(leftList);
            sortMerge(rightList);

            int i = 0; // left
            int j = 0; // right
            int k = 0; // list

            while ((i < leftList.size()) & (j < rightList.size())) {
                if (leftList.get(i) < rightList.get(j)) {
                    list.set(k, leftList.get(i));
                    i++;
                } else {
                    list.set(k, rightList.get(j));
                    j++;
                }
                k++;
            }

            while (i < leftList.size()) {
                list.set(k, leftList.get(i));
                i++;
                k++;
            }
            while (j < rightList.size()) {
                list.set(k, rightList.get(j));
                j++;
                k++;
            }
        }
        return list;
    }


    static ArrayList deleteEvenNum (ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)%2 == 0) {
                list.remove(i);
                i -= 1;
            }
        }
        return list;
    }

    static Integer findMaxNum (ArrayList<Integer> list) {
        int max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

    static Integer findMinNum (ArrayList<Integer> list) {
        int min = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) < min) {
                min = list.get(i);
            }
        }
        return min;
    }
    static Integer findMidNum (Integer max, Integer min, ArrayList<Integer> list) {
        int mid = list.get(0);
        int average = (max + min)/2;
        int temp = max - min;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) >= average) {
                if ((list.get(i) - average) < temp) {
                    temp = list.get(i) - average;
                    mid = list.get(i);
                }

            }
            if(list.get(i) < average) {
                if ((average - list.get(i))< temp) {
                    temp = average -list.get(i);
                    mid = list.get(i);
                }

            }

        }
        return mid;
    }

    static ArrayList unionList (ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> unionList = new ArrayList<>();
        unionList.addAll(list1);
        for (int i = 0; i < list2.size(); i++) {
            if (list1.contains(list2.get(i)) == false) {
                unionList.add(list2.get(i));
            }
        }
        return unionList;
    }



}
