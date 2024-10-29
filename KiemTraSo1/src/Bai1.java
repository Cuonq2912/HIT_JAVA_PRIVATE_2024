import java.util.Scanner;
public class Bai1 {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        int cnt = 0;
        while(n != 0){
            cnt++;
            n /= 10;
        }

    }
}
