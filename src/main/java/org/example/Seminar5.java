package org.example;

import java.util.*;

public class Seminar5 {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i=0; i <10; i++) {
            hashMap.put(i, String.valueOf(i));
            hashMap.putIfAbsent(i, String.valueOf(i) + "!");
        }
        //System.out.println(hashMap);
        //hashMap.forEach((k, v) -> System.out.print(v + " "));
        Set<Integer> keys = hashMap.keySet(); // возвращает список из неповторяющхся элементов
        for (Integer k: keys) {
            System.out.print(hashMap.get(k) + " ");
        }

//        Iterator<Integer> iterator = keys.iterator();
//
//        while(iterator.hasNext()){
//            String v = hashMap.get(iterator.next());
//            System.out.println(v + ", ");
//        }
        Collection<String> vl = hashMap.values();
        Set<Map.Entry<Integer, String>> e = hashMap.entrySet();
        hashMap.compute(1, (k, va) -> v += "!");

        hashMap.getOrDefault(21, "Key is not found");
        hashMap.computeIfPresent(3, (k, v) -> v += 1);
        hashMap.computeIfAbsent(78, v -> "1");
        hashMap.containsKey(31);
    }
}
