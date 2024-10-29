public class Person {
    private String name;
    //từ khóa "this" tham chiếu đến thể hiện của lớp đang thực thi,
    // cho phép truy cập vào các thành viên (biến và phương thức) của thể hiện đó.
    public Person(String name){
        this.name = name;
    }
    public void printName(){
        System.out.println("Name: " + this.name);
    }

}
