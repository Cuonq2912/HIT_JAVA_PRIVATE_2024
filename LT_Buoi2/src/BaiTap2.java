package LT_Buoi2;
import java.util.Scanner;

public class BaiTap2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int q = sc.nextInt(), l = sc.nextInt(), r = sc.nextInt();
        int[] sumArr = new int[n];
        sumArr[0] = arr[0];
        for(int i = 1; i < n; i++){
            sumArr[i] = sumArr[i - 1] + arr[i];
        }
        System.out.println(sumArr[r] - sumArr[l - 1]);
    }
}
