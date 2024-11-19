package Homework2;

import java.util.Scanner;

public class BaiTap1 {
    private static int binarySearch(int[] a, int l, int r, int k){
        while(l <= r){
            int m = l + (r - l)/2;
            if(a[m] == k) return m;
            if(a[m] < k) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n: ");
        int n;
        do{
            n = sc.nextInt();
        }while(n < 1 || n > 104);
        System.out.print("Nhap k: ");
        int k = sc.nextInt();

        System.out.print("Nhap mang: ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        int pos = binarySearch(a,0, n - 1, k);
        if(pos != -1) System.out.println("Vi tri cua so nguyen k trong mang la: " + pos);
        else System.out.println(-1);
    }
}

/*
Bài 1: Cho một mảng số nguyên nums sắp xếp theo thứ tự tăng dần
và một số nguyên k. Hãy tìm số nguyên k trong mảng nums
rồi trả về index của k, nếu không tìm thấy thì trả về -1.
 */
