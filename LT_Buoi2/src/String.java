package Buoi2;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // Khai báo và nối chuỗi
        String firstName = "John";
        String lastName = "Doe";
        String fullName = firstName + " " +  lastName;
        String getFullNameConCat = firstName.concat(" ").concat(lastName);
//        System.out.println(getFullNameConCat);
//        System.out.println(fullName);
        // So sánh chuỗi
        String str1 = "Hello";
        String str2 = "World";
        String str3 = "Hello";
        boolean areEqual1  = str1.equals(str2);
        boolean areEqual2 = str1.equals(str3);
//        System.out.println(areEqual1 + " " + areEqual2);
        // Độ dài chuỗi
        String text = "Hello World";
        int length  = text.length();
//        System.out.println(length);

        // trích xuất và tìm kiếm chuỗi con
        String sensence = "Arigato Konichigoa";
        String sub = sensence.substring(10,13);
//        System.out.println(sub);
        int indexOfKo = sensence.indexOf("Ko");
//        System.out.println(indexOfKo);

        // thay thế chuyển đổi chuỗi
        String originText = "I wanna listen to music";
        String replacedText = originText.replace("music", "piano");
//        System.out.println(replacedText);
//        System.out.println(replacedText.toUpperCase());
//        System.out.println(replacedText.toLowerCase());

        // kiểm tra có chứa kí thự, chuỗi con
        String example = "I wish i was a cat";
        boolean b = example.startsWith("I");
        boolean bb = example.endsWith("cat");
        boolean bbb = example.contains("was");
//        System.out.println(b + " " + bb + " " + bbb);

        String example2 = "I wanna no school";
        String example3 = "I wanna no school";
        boolean check = example2.intern() == example3.intern();
//        System.out.println(check);

        double randomValue = Math.random() * (100);
//        System.out.println(randomValue);

        // Array
        int[] a = new int[10];
        Scanner sn = new Scanner(System.in);
        for(int i = 0 ; i < 10; i++){
            a[i] = sn.nextInt();
        }
        for(int index : a){
            System.out.print(index + " ");
        }
    }
}
