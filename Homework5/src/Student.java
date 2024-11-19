import java.util.Scanner;

public class Student extends Person{
    private int id;
    private String nameClass;
    private float gpa;

    final float criteria = 2;

    public Student() {
    }

    public Student(int id, String nameClass, float gpa) {
        this.id = id;
        this.nameClass = nameClass;
        this.gpa = gpa;
    }

    public Student(String name, int age, Address address, int id, String nameClass, float gpa) {
        super(name, age, address);
        this.id = id;
        this.nameClass = nameClass;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        if(gpa >= 0 || gpa <= 4) {
            this.gpa = gpa;
        }
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    @Override
    public void input() {
        Scanner sn = new Scanner(System.in);
        super.input();
        System.out.print("id: ");
        this.id = sn.nextInt();
        sn.nextLine();
        System.out.print("nameClass: ");
        this.nameClass = sn.nextLine();
        System.out.print("gpa: ");
        this.gpa = sn.nextFloat();
    }

    @Override
    public void output() {
        super.output();
        System.out.printf("%-15s %-15s %-15s \n", id, nameClass, gpa);
    }

    public boolean checkFall(){
        return getGpa() < criteria;
    }


}
