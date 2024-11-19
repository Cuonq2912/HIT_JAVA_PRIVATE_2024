package Homework;
import java.util.Scanner;

public class BaiTap1 {
    static char[] kitu = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};
    public static String Solve(long a, int b) {
        String ans = "";
        while(a != 0) {
            long soDu = a % b;
            if(soDu >= 10) ans += kitu[(int)(soDu - 10)];
            else ans = ans + soDu;
            a /= b;
        }

        String revAns = "";
        for(int i = ans.length() - 1; i >= 0; --i) {
            revAns += ans.charAt(i);
        }
        return revAns;
    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.print("Nhap so tu nhien n va co so b (2 <= b <= 16): ");
        long n = sn.nextLong();
        int b;
        do {
            b = sn.nextInt();
            if (b < 2 || b > 16) {
                System.out.print("Nhap lai co so b: ");
            }
        } while(b < 2 || b > 16);

        String result = Solve(n, b);
        System.out.println("Ket qua: " + result);
    }
}

/*
Bài 1: Viết chương trình chuyển đổi một số tự nhiên ở hệ cơ số 10 thành số ở hệ cơ số b bất kì (2 ≤ b ≤ 16).
Ví dụ:
Input: 55 2
Output: 110111

Input: 254 8
Output: 376

Input: 26 16
Output: 1A

 */
