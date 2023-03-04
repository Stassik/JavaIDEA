package org.example;

public class Lection1 {
    int i = 6;
    char aChar = 65;
    String string = new String("Привет мир!"); //правильное обьявление переменной ссылочного тип

    static int[] ints = new int[10];

    static int getInt(String str){
        return Integer.parseInt(str);
    }
    public static void main(String[] args) {
        System.out.println(getInt("5"));

        for (int i = 0; i < ints.length; i++) {
           // ints[i] = i;
            //System.out.println(ints[i]);
        }
       for (int i: ints){
           //System.out.println(i);
       }

       System.out.println(Integer.toBinaryString(12));
       System.out.println(Integer.toBinaryString(12).length()); // ночер старшего бита

    }
}