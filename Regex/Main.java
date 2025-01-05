package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String regexPhonenumber = "^0\\d{9}$"; // vd: 0912345678
        String regexMail =  "^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,}$"; // bki + @  + bki + . + (bki > 2 ktu)
        String regexPassword =  "^.{8,}$"; // bki (it nhat 8 ktu)
        String regexUsername = "^[a-z]{4,}$";

        String phoneNumber = "0968670575";

        Pattern pattern = Pattern.compile(regexPhonenumber);
        Matcher matcher = pattern.matcher(phoneNumber);

        if(matcher.find()){
            System.out.println("Valid");
        } else System.out.println("Invalid");

        String string = "   Hi      how are     you?";
        String result = string.replaceAll("\\s+", " ").trim();
        System.out.println(result);
    }
}
