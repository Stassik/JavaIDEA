package org.example;

import java.util.*;

/**
 * Написать программу, в которую заноситчя ФИО возраст, пол
 * После завершения ввода выводится полный список внесенных данных.
 * Предлагается на выбор сортировка (по возрасту, по полу)
 */
public class Seminar4 {
    static Scanner iScanner = new Scanner(System.in);

    public static void main(String[] args) {

        int lengthList = 1_0;
        ArrayList<Object[]> persons = new ArrayList<>();

        controller(persons);

/**
        long begin1 = System.currentTimeMillis();
        persons = bigData(persons, lengthList);
        long end1 = System.currentTimeMillis();

        long begin2 = System.currentTimeMillis();
        printList(persons);
        long end2 = System.currentTimeMillis();
        System.out.println("*************");
        //selectSorting();
        System.out.println();
        long begin = System.currentTimeMillis();
        persons = sortAge(persons);
        long end = System.currentTimeMillis();
        printList(persons);
        System.out.println("*************");
        long begin3 = System.currentTimeMillis();
        persons = sortGender(persons);
        long end3 = System.currentTimeMillis();
        printList(persons);

        System.out.println("Затрачено времени на генерацию списка " + (end1 - begin1));
        System.out.println("Затрачено времени на печать списка: " + (end2 - begin2));
        System.out.println("Затрачено времени на сортировку по возрасту: " + (end - begin));
        System.out.println("Затрачено времени на сортировку по полу: " + (end3 - begin3));
*/


    }

    static void controller(ArrayList<Object[]> persons) {
        int ans = -1;
        while ((ans != 1 )&(ans != 2)&(ans != 0)) {
            System.out.println("Выберите режим работы: ");
            System.out.println("1 - Ввод данных вручную");
            System.out.println("2 - Автоматическая генерация списка");
            System.out.println("0 - Выход");
            ans = iScanner.nextInt();
        }
        newList(persons, ans);
        System.out.println();
        selectSorting(persons);

    }

    static void newList (ArrayList<Object[]> persons, int ans) {
        if (ans == 1) {
            fillingList(persons);
            printList(persons);
        } else if (ans == 2) {
            System.out.print("Введите длину списка: ");
            int len = iScanner.nextInt();
            long begin = System.currentTimeMillis();
            bigData(persons, len);
            long end = System.currentTimeMillis();
            printList(persons);

            System.out.println("Затрачено времени на генерацию списка " + (end - begin));
        } else {
            System.exit (1);
        }
    }

    static Object[] insertInfo (Integer size) {
        Object[] personInfo = new Object[6];
        personInfo[0] = size+1;
        System.out.print("Фамилия: ");
        StringBuilder lastname = new StringBuilder(iScanner.next());
        personInfo[1] = lastname.substring(0, 1).toUpperCase() + lastname.substring(1);

        System.out.print("Имя: ");
        StringBuilder name = new StringBuilder(iScanner.next());
        personInfo[2] = name.substring(0, 1).toUpperCase() + name.substring(1);

        System.out.print("Отчество: ");
        StringBuilder surname = new StringBuilder(iScanner.next());
        personInfo[3] = surname.substring(0, 1).toUpperCase() + surname.substring(1);

        System.out.print("Возраст: ");
        personInfo[4] = iScanner.nextInt();

        System.out.print("Пол (м / ж): ");
        StringBuilder gender = new StringBuilder(iScanner.next());
        personInfo[5] = gender.substring(0, 1).toUpperCase();

        return personInfo;
    }

    static void fillingList(ArrayList<Object[]> persons) {
        String answ = "д";

        while (answ.equals("д")) {
            System.out.printf("Запись %d \n", persons.size()+1);
            persons.add(insertInfo(persons.size()));
            System.out.println("Добавить новую запись? (д/н)");
            answ = iScanner.next();
        }
    }

    static void printList (ArrayList<Object[]> persons) {
        for (int i = 0; i < persons.size(); i++) {
            System.out.print((persons.get(i)[0]) + " ");
            System.out.print((persons.get(i)[1]) + " ");
            System.out.print((persons.get(i)[2]).toString().charAt(0) + ". ");
            System.out.print((persons.get(i)[3]).toString().charAt(0) + ". ");
            System.out.print((persons.get(i)[4]) + " ");
            System.out.println((persons.get(i)[5]).toString().charAt(0) + " ");
        }
    }
    static void action(Integer index) {
        String[] action= new String[]{"1 - По возрасту", "2 - По полу", "3 - По ID", "0 - Выход"};
        System.out.println("Выберете сортировку: ");
        for(int i = 0; i < action.length; i++){
            if (i == index) {continue;}
            else {
                System.out.println(action[index]);
            }
        }
    }

    static void selectSorting (ArrayList<Object[]> persons) {
        int ans = -1;
        while (ans != 0) {
            System.out.println("1 - По возрасту");
            System.out.println("2 - По полу");
            System.out.println("3 - По ID");
            System.out.println("0 - Выход");
            ans = iScanner.nextInt();
            if (ans == 1) {
                System.out.println("Вы выбрали сортировку по возрасту.");
                System.out.println("Сортируем...");
                long begin = System.currentTimeMillis();
                persons = sort(persons, 4);
                long end = System.currentTimeMillis();
                printList(persons);
                System.out.println("Затрачено времени на сортировку по возрасту: " + (end - begin));

            } else if (ans == 2){
                System.out.println("Вы выбрали сортировку по полу.");
                System.out.println("Сортируем...");
                long begin1 = System.currentTimeMillis();
                persons = sortGender(persons);
                long end1 = System.currentTimeMillis();
                printList(persons);
                System.out.println("Затрачено времени на сортировку по полу: " + (end1 - begin1));

            } else if (ans == 3) {
                System.out.println("Вы выбрали сортировку по ID.");
                System.out.println("Сортируем...");
                long begin2 = System.currentTimeMillis();
                persons = sort(persons, 0);
                long end2 = System.currentTimeMillis();
                printList(persons);
                System.out.println("Затрачено времени на сортировку по ID: " + (end2 - begin2));

            } else {
                System.exit(1);
            }
        }
    }

    static ArrayList<Object[]> sort (ArrayList<Object[]> persons, Integer index) {
        if (persons.size() > 1) {
            ArrayList<Object[]> leftList = new ArrayList<>(persons.subList(0, persons.size()/2));
            ArrayList<Object[]> rightList = new ArrayList<>(persons.subList(persons.size()/2, persons.size()));
            sort(leftList, index);
            sort(rightList, index);

            int i = 0; // left
            int j = 0; // right
            int k = 0; // list

            while ((i < leftList.size()) & (j < rightList.size())) {
                if (Integer.parseInt(leftList.get(i)[index].toString()) < Integer.parseInt(rightList.get(j)[index].toString())) {
                    persons.set(k, leftList.get(i));
                    i++;
                } else {
                    persons.set(k, rightList.get(j));
                    j++;
                }
                k++;
            }

            while (i < leftList.size()) {
                persons.set(k, leftList.get(i));
                i++;
                k++;
            }
            while (j < rightList.size()) {
                persons.set(k, rightList.get(j));
                j++;
                k++;
            }

        }
        return persons;
    }

    static ArrayList<Object[]> sortGender(ArrayList<Object[]> persons) {
        ArrayList<Object[]> sortIdList = new ArrayList<>();
        ArrayList<Object[]> idList = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i)[5].equals("ж")) {
                sortIdList.add(persons.get(i));
            } else {
                idList.add(persons.get(i));
            }
        }
        sortIdList.addAll(idList);
        return  sortIdList;
    }





    //                 !!!!!!! ДЛЯ ГЕНЕРАЦИИ СТРОК и ТЕСТИРОВКИ СОРТИРОВКИ !!!!!!
    static Object[] generateString() {
        Object[] personInfo = new Object[6];
        char[] ru = new char[]{'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ы', 'ъ', 'э', 'ю', 'я'};
        Random random = new Random();
            for (int i = 1; i < 4; i++) {
                StringBuilder generatedString = new StringBuilder();
                for (int j = 0; j < 8; j++) {
                    generatedString.append(ru[random.nextInt(0, 33)]);
                }
                personInfo[i] = generatedString.substring(0, 1).toUpperCase() + generatedString.substring(1);
            }
            int age = random.nextInt(0, 100);
            personInfo[4] = age;
            String[] gender = new String[]{"м", "ж"};
            int index = random.nextInt(0, 2);
            personInfo[5] = gender[index];

        return personInfo;
    }

    static ArrayList<Object[]> bigData (ArrayList<Object[]> persons, int lengthList) {
        for (int i = 0; i < lengthList; i++) {
            persons.add(i, generateString());
            persons.get(i)[0] = persons.size();

        }
        return persons;
    }


}
