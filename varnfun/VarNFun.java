package varnfun;

import java.util.Scanner; // include < stdio.h>

public class VarNFun {
    
    public static void main(String[] args) {
//        int x = getAnInteger();
//        System.out.println("x from keyboard: " + x);
//        
//        // in từ 1 đến x
//        printIntegerlist(x); // pass by value, tham tri, lay value co
        // trong x day xuong ham goc, dua 79 cho x, x day cho n trong ham
//        inputFromKeyboard();
//        playWithVariables();
//        playWithIntegers();
//        playWithDoubles();
//        playWithCharactors();
//        playWithBooleans();
//        printIntegerlist();
//        printIntegerlist(20); // hard code, code cung gia tri
//        testMathFunctions();
    }
    
    public static void testMathFunctions() {
        double result = Math.sqrt(25);
        System.out.println("result: " + result);
        System.out.println(Math.sqrt(100));
    }
    
    public static int getAnInteger() {
        int n; // C gan rac, on-of hiện nay của ram
        
        Scanner banPhimCuaToi = new Scanner(System.in);
        
        System.out.print("Please input a positive: ");
        n = banPhimCuaToi.nextInt(); // float r = sqrt(4);
        
        return n;
    }   
    
    
    public static void inputFromKeyboard() {
        int yob; // C gan rac, on-of hiện nay của ram
        
        Scanner banPhimCuaToi = new Scanner(System.in);
        
        System.out.println("Please input your year of birth: ");
        yob = banPhimCuaToi.nextInt(); // float r = sqrt(4);
        
        System.out.println("yob: " + yob);
    }
    
    // in cac so tu 1 den n
    // hien tuong trong 1 class bat ki nao do, ma co nhieu ham trung
    // ten nhau va khac phan tham so dau vao, nhung khac tren data type
    // chus khong phai khac tren ten bien
    // thi duoc goi la : OVERLOADING : qua tai ham
    // 1 đám giống nhau ở cùng 1 chỗ - quá tải
    public static void printIntegerlist(int n) {
        System.out.println("The list of " + n + " first integers");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }
    // in cac so tu 1 -> 100
    public static void printIntegerlist(){
        System.out.println("The list os first of 100 first intergers");
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + " ");
        }
    }
    // Java uu tien double hon float
    public static void playWithDoubles(){
        double pi = 3.14;
        System.out.println("pi : " + pi);
        
        float vat = 0.1F;
        System.out.println("vat : " + vat);
    }
    
    public static void playWithBooleans(){
        // C : dung 1, > 0; sai 0
        // Java Dung -> true, sai -> false, -> boolean
        boolean marriedStatus = false;
        if(marriedStatus == true)
            System.out.println("Danh don co dich moi vui");
        else
            System.out.println("vuon hon co loi nhung chua ai vao");
    }
    
    public static void playWithCharactors(){
        //2 byte cho kieu char, luu bang Unicode
        char m = '$';
        System.out.println("unit : " + m);
        // ten -> C++ : mang cac ki tu, ko primitive, phuc tap  
        // C++ : char name[] = "asdfg";
        String name = "Nguyen Trong Cuong"; // loai data type moi hoan toan
                                            // phuc tap, do gom n thu khac
                                            // object data type, hoc sau
        System.out.println("My name is : " + name);
        System.out.println("1st letter of my name : " + name.charAt(0));
        System.out.println("my name as in a lowercase : " + name.toLowerCase());
        //string C++ -> strlwr...
        

    }
    
    public static void playWithIntegers(){
        int n = 39; // 4 moi so, ki tu xuat hien duoc goi la literal value
                    // so nguyen xuat hien trong code mac dinh la int
        System.out.println("n : " + n);
        
        long m = 3_000_000_000L; // phan cach literal trong code cho de hoc
        System.out.println("m : " + m);
        
        int status = 0xFA; // hệ 16
        System.out.println("status : " + status);
        int phone = 010; // 0 hệ 8 octal
        System.out.println("phone : " + phone);
    }
    
    public static void playWithVariables() {
        // biến là một vùng Ram được đặt tên, chiếm 1 số byte nhất định tùy loại
        // data mà nó chứa bên trong - số, chữ, ảnh
        // biến là cách đặt tên cho một đại lượng, 1 giá trị - đơn, phức(hđt)
        int age = 20;
        int a = 10, b;
        b = 100;
        // tốn 12 byte trong RAM 
        System.out.println("age: " + age);
        int yob = 2001;
        age = 2024 - yob;
        System.out.println("age again : " + age);
        System.out.println("age by using transitive tech: " + (2024 - yob));
        System.out.printf("age  printed by using %% as in C: %d\n", (2024 - yob));
        System.out.println("a is : " + a);
        System.out.println("b is : " + b);
    }


    
}

