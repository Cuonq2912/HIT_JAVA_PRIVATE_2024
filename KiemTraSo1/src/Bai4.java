<<<<<<< HEAD
import java.util.Scanner;
import java.util.Scanner;

public class Bai4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        long[] prefixSum = new long[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            if(i == 0) prefixSum[i] = a[i];
            else prefixSum[i] = prefixSum[i - 1] + a[i];
        }
        int q = sc.nextInt();
        for(int i = 0; i < q; i++){
            int l = sc.nextInt(), r = sc.nextInt();
            System.out.println(prefixSum[r] - prefixSum[l - 1]);
        }
    }
}
=======
import java.util.Scanner;
import java.util.Scanner;

public class Bai4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        long[] prefixSum = new long[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            if(i == 0) prefixSum[i] = a[i];
            else prefixSum[i] = prefixSum[i - 1] + a[i];
        }
        int q = sc.nextInt();
        for(int i = 0; i < q; i++){
            int l = sc.nextInt(), r = sc.nextInt();
            System.out.println(prefixSum[r] - prefixSum[l - 1]);
        }
    }
}
>>>>>>> f5b7b7054d31b9c5a5dc0edc6929e2a668bd7806
