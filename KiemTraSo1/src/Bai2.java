import java.util.Scanner;
public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                s2.append(s.charAt(i));
            } else {
                s1.append(s.charAt(i));
            }
        }
        System.out.println(s1);
        System.out.println(s2);

        sc.close();
    }
}
