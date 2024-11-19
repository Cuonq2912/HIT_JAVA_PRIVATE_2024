package LT_Buoi3;

public class Main {
    public static void main(String[] args){
        Car car = new Car();
        Student stu1 = new Student("Nguyen Cuong", 18);
        stu1.display();
        System.out.println("Name: " + stu1.getName());
        System.out.println("Age: " + stu1.getAge());

        Person p1 = new Person("alice");
        p1.printName();

        Account a1 = new Account(001, "cuong", 100);
        a1.display();
        a1.deposit(50);
        a1.display();
        a1.withdraw(1000);
        System.out.println(a1);
        System.out.println("Balance: " + a1.getBalance());

        Time t1 = new Time(23, 59, 59);
        t1.display();
        t1.nextSecond();
        t1.display();
        t1.previousSecond();
        t1.display();
    }
}