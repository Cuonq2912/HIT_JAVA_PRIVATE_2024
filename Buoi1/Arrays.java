package Buoi1;

import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sn.nextInt();
        }
        sn.close();
        for(int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
    }
}
