package SourseCode.Buoi1;

import java.util.Scanner;

public class checkRectangle {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Nhap 3 canh cua tam giac: ");
        int a = sn.nextInt();
        int b = sn.nextInt();
        int c = sn.nextInt();
        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("ko la tam giac");
        } else if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("ko la tam giac");
        } else System.out.println("la tam giac");
    }
}
