import java.util.Scanner;

public class Seminar {
    static Scanner iScanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Введите свое имя: ");
        static String name = iScanner.nextline();
        System.out.printf("Добрый день %s", name);
    }
}