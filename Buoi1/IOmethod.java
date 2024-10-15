package SourseCode.Buoi1;

import java.util.Scanner;

public class IOmethod {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten: ");
        String name = scanner.nextLine();
        int age = scanner.nextInt();
        System.out.println(name);
    }
}
