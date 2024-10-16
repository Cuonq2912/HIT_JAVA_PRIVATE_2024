package Buoi1;
import java.util.Scanner;

public class Array2D {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        int[][] a = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                a[i][j] = sn.nextInt();
            }
        }
        sn.close();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
