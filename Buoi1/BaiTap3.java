package Buoi1;
import java.util.Scanner;

public class BaiTap3 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
//        int n = sn.nextInt();
        long maxValue1 = 0, maxValue2 = 0;
        Long[] a = new Long[5];

        for(int i = 0; i < 5; ++i) {
            a[i] = sn.nextLong();
            if (a[i] >= maxValue1) {
                maxValue2 = maxValue1;
                maxValue1 = a[i];
            }
            else if(a[i] < maxValue1 && a[i] >= maxValue2){
                maxValue2 = a[i];
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