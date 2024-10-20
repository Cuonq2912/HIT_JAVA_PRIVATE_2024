package Buoi1;
import java.util.Scanner;

public class BaiTap2 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.print("Nhap so nguyen n: n = ");
        long n = sn.nextLong();
        long ans = 1;
        while(n != 0){
            ans *= n % 10;
            n /= 10;
        }
        System.out.print("Tich cac chu so cua n la: " + ans);
    }
}

/*
Bài 2: Viết chương trình tính tích các chữ số của một số nguyên bất kỳ.
Ví dụ:
Input: 64226
Output: 576

 */