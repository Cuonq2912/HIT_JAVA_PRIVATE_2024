
import java.util.Scanner;

import java.util.Scanner;

public class Bai3 {
    static double solve(double x, int y){
        if(y == 0) return 1;
        if(y % 2 == 0) return solve(x, y/2) * solve(x, y/2);
        else return x * solve(x, y/2) * solve(x, y/2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        int y = sc.nextInt();
        System.out.println(solve(x, y));
    }
}
