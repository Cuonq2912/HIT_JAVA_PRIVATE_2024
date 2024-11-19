package LT_Buoi4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sn  = new Scanner(System.in);
        Person p1 = new Person("0523436576", "Nguyen", (byte)23, "Ha Noi", "095425443");
        Person p2 = new Person("054253", "Trong", (byte)42, "Ha Nam", "052354554");
        Person p3 = new Person("570450", "Cuong", (byte)53, "Ha Bac", "05324636");
        Person p4 = new Person("5324635476", "Cuong", (byte) 24, "Ha Tay", "0646262");
        Person[] persons = new Person[4];
        persons[0] = p1;
        persons[1] = p1;
        persons[2] = p3;
        persons[3] = p4;

//        System.out.println("Nhap ten muon tim: ");
//        String name = sn.nextLine();
//        findByName(persons, name);
//
//        System.out.println("Nhap ma cccd: ");
//        String idenCode = sn.nextLine();
//        searchByIdenCode(persons, idenCode);

        System.out.println("Sap xep: ");
        mergeSort(persons, 0, 3);
        for(Person person: persons){
            person.Display();
        }
    }

    public static void findByName(Person[] persons, String name){
        for(int i = 0; i < 4; i++){
            if(name.equals(persons[i].getName())){
                persons[i].Display();
            }
        }
    }

    public static void searchByIdenCode(Person[] persons, String name){
        for(int i = 0; i < 4; i++){
            if(name.equals(persons[i].getIdenCode())){
                persons[i].Display();
            }
        }
    }

    public static void merge(Person[] p, int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
        Person[] L = new Person[n1];
        Person[] R = new Person[n2];
        int i = 0, j = 0, cnt = l;
        while(i < n1 && j < n2){
            if(L[i].getAge() <= R[j].getAge()){
                p[cnt++] = L[i++];
            }
            else{
                p[cnt++] = R[j++];
            }
        }
        while(i < n1) p[cnt++] = L[i++];
        while(j < n2) p[cnt++] = R[j++];
    }

    public static void mergeSort(Person[] p, int l, int r){
        if(l < r){
            int m = l + (r - l)/2;
            mergeSort(p, l, m);
            mergeSort(p, m + 1, r);
            merge(p, l, m, r);
        }
    }
}
