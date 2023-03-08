package org.example;

import java.util.Arrays;

public class Seminar2 {
    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();
        String str = "Привет мир!";
        builder.append(str);
        System.out.println(builder);
        System.out.println(str.toLowerCase());
        System.out.println("+".repeat(15));
        System.out.println(str.contains("П"));
        System.out.println(str.charAt(4));
        String[] strings = str.split(" ");
        System.out.println(Arrays.toString(strings));
    }
}
