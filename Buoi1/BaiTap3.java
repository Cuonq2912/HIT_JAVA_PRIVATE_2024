package Buoi1;
import java.util.Scanner;

public class BaiTap3 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.print("Nhap so luong pt: n = ");
        int n = sn.nextInt();
        int maxValue1 = 0, maxValue2 = 0;
        int[] a = new int[n];
        System.out.print("Nhap mang: ");
        for(int i = 0; i < n; i++) {
            a[i] = sn.nextInt();
            if(a[i] >= maxValue1){
                maxValue2 = maxValue1;
                maxValue1 = a[i];
            }
        }
        System.out.println("Phan tu lon nhat va lon thu 2 trong mang la: " + maxValue1 + " " + maxValue2);
    }
}
/*
Bài 3: Viết chương trình tìm 2 số lớn nhất trong 5 số nguyên nhập từ bàn phím.
Ví dụ:
Input: 10 5 16 8 4
Output: 10 16

Input: 2 5 3 5 2
Output: 5 5
 */