package Homework2;
import java.util.Scanner;

public class BaiTap2 {
    public static long solve(long[] a, int n, int k){
        long curSum = 0;
        for (int i = 0; i < k; i++) {
            curSum += a[i];
        }
        long maxSum = curSum;
        long[] prefixSum = new long[n + 1];
        for(int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + a[i];
        }

        for(int i = k; i <= n; i++) {
            for(int j = 0; j <= i - k; j++) {
                long sum = prefixSum[i] - prefixSum[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n va k: ");
        int n = sc.nextInt();
        int k = sc.nextInt();

        long[] a = new long[n];
        System.out.print("Nhap mang: ");
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        System.out.println("Tong lon nhat cua day con co it nhat " + k + " phan tu la: " + solve(a, n, k));
    }
}

/*
 Cho một mảng số nguyên arr có n phần tử và một số nguyên k,
 hãy tìm tổng lớn nhất của bất kỳ dãy con liên tiếp nào chứa ít nhất k phần tử.
 */