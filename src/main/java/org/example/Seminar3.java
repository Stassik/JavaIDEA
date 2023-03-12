package org.example;

import java.util.*;

public class Seminar3 {
    public static void main(String[] args) {
        Object[] i;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> strings = new ArrayList<>(list); // новый список содержащий в себе элементы старого списка
        strings.addAll(list);  // заполнить новый список значениями из другого списка
        strings.clear(); // в ячейках записывает null и оставляет длину списка
        //strings = list // здесь strings является ссылкой на список list

        list.add(25);
        list.add(1);
        list.add(4);
        list.add(5);
        list.remove(1);
        list.get(1);
        list.forEach(n -> System.out.print(n+",")); // указывает что необходимо сделать с переменной n  в цикле
        //if (list.get(1) instanceof  String) ((String) list.get(1)).toUpperCase(); //медленно работает


        list.add(list.size()/2, 35); // добавляем элемент на определенное место(индекс), двигая остальные элементы списка
        list.set(2, 2); // замена значения элемента по индексу
        System.out.println();

        //Collections.sort(list);
        list.forEach(n -> System.out.print(n+","));
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
                /**if ((o2-o1)%2 !=0) return 1;
                else if ((o2-o1)%2 == 0) return -1;
                return 0;*/

            }
        });
        System.out.println();
        list.forEach(n -> System.out.print(n+","));
        for (int j = 0; j<10; j++) {
            list.add(new Random().nextInt(10));
            strings.add(new Random().nextInt(10));
        }
        System.out.println(list);
        System.out.println(strings);
       // list.retainAll(strings); //пересечение множеств
        //System.out.println(list);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            System.out.println(n);
        }

        for (int j = 0; j < list.size(); j++) {
            System.out.print(list.get(j));
        }

        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(4);
        list1.get(3);
        list1.getFirst();


    }
}
