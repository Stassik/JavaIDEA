package org.example;

import java.util.*;

public class HW4 {
    static Random random = new Random();

    public static void main(String[] args) {
        HashMap<String[], HashMap<String, Integer>> contacts = new HashMap<>();

        ArrayList<String[]> name = new ArrayList<>();
        name.add(new String[]{"Иванов", "Иван"});
        name.add(new String[]{"Петрова", "Светлана"});
        name.add(new String[]{"Белова", "Кристина"});
        name.add(new String[]{"Мусина", "Анна"});
        name.add(new String[]{"Крутова", "Анна"});
        name.add(new String[]{"Лыков", "Петр"});
        name.add(new String[]{"Чернов", "Павел"});
        name.add(new String[]{"Чернышов", "Петр"});
        name.add(new String[]{"Федорова", "Мария"});
        name.add(new String[]{"Светлова", "Марина"});
        name.add(new String[]{"Савина", "Мария"});
        name.add(new String[]{"Рыкова", "Мария"});
        name.add(new String[]{"Лугова", "Марина"});
        name.add(new String[]{"Владимирова", "Анна"});
        name.add(new String[]{"Мечников", "Иван"});
        name.add(new String[]{"Петин", "Петр"});
        name.add(new String[]{"Ежов", "Иван"});

        generatePhoneBook(name, contacts);
        print(name, contacts);
    }


    static String generatePhoneNumbers() {
        StringBuilder phone = new StringBuilder();
        phone.append("+")
                .append(random.nextInt(0, 10))
                .append("(")
                .append(random.nextInt(0, 10))
                .append(random.nextInt(0, 10))
                .append(random.nextInt(0, 10))
                .append(")")
                .append("-")
                .append(random.nextInt(0, 10))
                .append(random.nextInt(0, 10))
                .append(random.nextInt(0, 10))
                .append("-")
                .append(random.nextInt(0, 10))
                .append(random.nextInt(0, 10))
                .append("-")
                .append(random.nextInt(0, 10))
                .append(random.nextInt(0, 10));
        String phoneNumber = phone.toString();
        return phoneNumber;
    }

    static HashMap<String[], HashMap<String, Integer>> generatePhoneBook(ArrayList<String[]> name, HashMap<String[], HashMap<String, Integer>> contacts) {
        for (String[] id : name) {
            HashMap<String, Integer> contactPhone = new HashMap<>();
            for (int i = 1; i < random.nextInt(2, 5); i++) {
                contactPhone.put(generatePhoneNumbers(), random.nextInt(0, 100));
                contacts.put(id, contactPhone);
            }
        }
        return  contacts;
    }

    static void print(ArrayList<String[]> name, HashMap<String[], HashMap<String, Integer>> contacts) {
        for (int i = 0; i < name.size(); i++) {
            System.out.print(String.join(" ", name.get(i)) + "\n");
            int finalI = i;
            contacts.get(name.get(i)).forEach((k, v) -> System.out.printf(k+" с этого номера %s звонил(а) "+ v + " раз(а)\n", name.get(finalI)[1]));
            System.out.println();
            //System.out.println(contacts.get(name.get(i)));
        }
        countPopularName(name, contacts);
    }

    static void countPopularName(ArrayList<String[]> name, HashMap<String[], HashMap<String, Integer>> contacts) {
        TreeMap<String, Integer> countName = new TreeMap<>();
        int count = 0;
        for (int i = 0; i < name.size(); i++) {
            countName.putIfAbsent(name.get(i)[1], 0);
            countName.computeIfPresent(name.get(i)[1], (k, v) -> v += 1);
        }

        countName.forEach((k, v) -> System.out.print(k+" встречается "+ v + " раз(а)\n"));
    }
}
