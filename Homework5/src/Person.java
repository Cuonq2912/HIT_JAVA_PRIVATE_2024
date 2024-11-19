import java.util.Scanner;

public class Person {
    protected String name;
    protected int age;
    protected Address address;

    public Person() {
    }

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void input(){
        Scanner sn = new Scanner(System.in);
        System.out.print("Name: ");
        this.name = sn.nextLine();
        System.out.print("Age: ");
        this.age = sn.nextInt();
        System.out.println("Address: ");
        Address a = new Address();
        a.input();
        this.address = a;
    }

    public void output(){
        System.out.printf("%-15s %-15s", name, age);
        address.output();
    }

}
