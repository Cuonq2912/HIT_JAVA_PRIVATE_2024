public class Student {
    // Attributes object should be private
    private String name;
    private int age;

    // Method should be public
    public void display(){
        System.out.println("Name: " + name);
        System.out.println("Age" + age);
    }
    //Contructor: khởi tạo đối tượng của lớp = new
    public Student(String n1, int a1){
        name = n1;
        age = a1;
    }

    // Getter Setter: tt với các tt 1 cách  gián tiếp,
    // đảm bảo tính đóng gói của đối tượng

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
