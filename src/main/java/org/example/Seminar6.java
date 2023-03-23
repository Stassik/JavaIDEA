package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Seminar6 {
    static Scanner iScanner = new Scanner(System.in);
    public static void main(String[] args) {
        MySet mySet = new MySet();
//        String answ = "y";
//        while (answ.contains("y")) {
//            System.out.print("Введите число: ");
//            mySet.add(Integer.parseInt(iScanner.nextLine()));
//
//            System.out.println("Хотите добавить еще элемент? (y / n)");
//            answ = iScanner.nextLine();
//        }
        mySet.myAdd(21);
        mySet.myAdd(1);
        mySet.myAdd(7);
        mySet.myAdd(31);
        mySet.myAdd(12);

        mySet.myPrint();
//        System.out.print("Введите число, которое необходимо удалить: ");
//        mySet.myRemove(Integer.parseInt(iScanner.nextLine()));
//        mySet.myPrint();

        MySet newSet = new MySet();
        newSet.myAdd(21);
        newSet.myAdd(11);
        newSet.myAdd(31);
        newSet.myAdd(41);
        newSet.myAdd(1);
        newSet.myPrint();

        mySet.myUnity(newSet);
        mySet.myPrint();

        System.out.println(mySet.myLength());
        System.out.println(mySet.returnKey(6));

        System.out.println(mySet.myToList());
        System.out.println(mySet.returnElem(7));





    }
}

class MySet {
       private  HashMap<Integer, Object> keys;
       private static final Object OBJECT = new Object();

    public MySet() {
        this.keys = new HashMap<>();
    }
     public void myAdd (int key) {
        this.keys.putIfAbsent(key, OBJECT);
     }

     public void myPrint() {
        keys.forEach((k, v) -> System.out.print(k + " "));
        System.out.println();
     }

     public int myLength () {
        return this.keys.size();
     }

     public ArrayList<Integer> myToList() {
        return new ArrayList<>(this.keys.keySet());
     }

     public void myRemove(int key) {
        this.keys.remove(key);
     }

     public void myUnity (MySet other) {
        other.keys.forEach((k, v) -> this.myAdd(k));
     }

     public int returnKey (int index) {
        return (int) this.keys.keySet().toArray()[index];
     }

     public ArrayList<Integer> returnElem(int maxKey) {
        if (!this.keys.containsKey(maxKey)) return null;
        ArrayList<Integer> output = new ArrayList<>();
        for (int k: keys.keySet()) {
            output.add(k);
            if (k == maxKey) {
                break;
            }
        }
        return output;
     }



}
