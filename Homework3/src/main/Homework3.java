package main;

import src.Student;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Homework3 {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        Student s1;
        s1 = new Student("H001", "Nguyen van a", (byte) 12, "Nam", "9342536", "nguyenvuhsdo@gmail.com");
        s1.display();
        
        List<Student> students;
        students = new ArrayList<>();
        
        System.out.print("Nhap so hs: ");
        int n = sn.nextInt();
        sn.nextLine();
        for(int i = 0; i < n; i++){
            System.out.println("Nhap tt cho hs thu " + (i + 1));
            students.add(inputStudent(sn));
        }

        for(Student student : students){
            student.display();
        }
    }

    public static Student inputStudent(Scanner sn){
        System.out.print("Nhap ma: ");
        String studentCode = sn.nextLine();
        
        System.out.print("Nhap ten: ");
        String fullName = sn.nextLine();
        
        System.out.print("Nhap tuoi: ");
        byte age = sn.nextByte();

        sn.nextLine();
        System.out.print("Nhap gioi tinh: ");
        String gender = sn.nextLine();
        
        System.out.print("Nhap sdt: ");
        String phoneNumber = sn.nextLine();
        
        System.out.print("Nhap email: ");
        String email = sn.nextLine();
        
        return new Student(studentCode, fullName, age, gender, phoneNumber, email);
    }
        
    
}