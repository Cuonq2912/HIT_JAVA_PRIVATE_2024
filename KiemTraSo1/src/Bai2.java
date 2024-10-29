import java.util.Scanner;
import java.lang.String;
import java.lang.Character;


public class Bai2 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String s = sn.nextLine();
        String s1 = "", s2 = "";
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))) {
                s1.concat(String.valueOf(s.charAt(i)));
            }
            else s2.concat(String.valueOf(s.charAt(i)));
        }
        System.out.println(s1);
        System.out.println(s2);
    }

}
