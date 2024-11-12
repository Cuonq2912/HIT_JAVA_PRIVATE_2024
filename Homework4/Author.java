import java.util.Scanner;

public class Author {
    private String name;
    private int age;

    public Author() {
    }

    public Author(String name, int age) {
        this.name = name;
        this.age = age;
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
        if (age > 0)
            this.age = age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static Author NewAuthor(){
        Scanner sn = new Scanner(System.in);
        System.out.println("Nhập tên tác giả: ");
        String name = sn.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = sn.nextInt();
        return new Author(name, age);
    }
}
