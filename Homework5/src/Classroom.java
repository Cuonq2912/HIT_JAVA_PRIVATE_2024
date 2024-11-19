import java.util.*;

public class Classroom {
    static Scanner sn = new Scanner(System.in);
    public static ArrayList<Student> li = new ArrayList<>();

    public static void sortByGpa(){
        for(int i = 0; i < li.size(); i++){
            for(int j = 0; j < li.size() - i - 1; j++){
                if(li.get(j).getGpa() > li.get(j + 1).getGpa()){
                    Student temp = li.get(j);
                    li.set(j, li.get(j + 1));
                    li.set(j + 1, temp);
                }
            }
        }
        System.out.println("Sort success!!!");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void inputList(){
        while(true){
            Student s = new Student();
            s.input();
            li.add(s);
            if(s.getId() == 555){
                System.out.println("End of input because id's student is 555!!!");
                System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                break;
            }
        }
    }

    public static void outputList(){
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-13s %-15s %-15s\n", "Name", "Age", "Commune", "District", "City", "Id", "Classroom", "Gpa");
        for (Student s : li) {
            s.output();
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
    }

    public static boolean removeById(){
        System.out.print("Id want remove: ");
        int id = sn.nextInt();
        for(int i = 0; i < li.size(); i++){
            if(li.get(i).getId() == id){
                li.remove(i);
                System.out.println("remove success!!!");
                return true;
            }
        }
        return false;
    }

    public static void menu(){
        while(true){
            System.out.println("1. Nhập thông tin các sinh viên(nhập đến khi nào mã sinh viên là 555 thì dừng không nhập nữa)");
            System.out.println("2. In ra thông tin các Sinh Viên theo dạng bảng");
            System.out.println("3. Sắp xếp danh sách sinh viên theo điểm gpa");
            System.out.println("4. Xóa sinh viên theo id(nhập id từ bàn phím)");
            System.out.println("5. Thoát chương trình");
            System.out.print("Enter your choice: ");
            int choice = sn.nextInt();
            switch (choice){
                case 1:
                    Classroom.inputList();
                    break;
                case 2:
                    Classroom.outputList();
                    break;
                case 3:
                    Classroom.sortByGpa();
                    break;
                case 4:
                    Classroom.removeById();
                    break;
                case 5:
                    System.out.println("Existing the program!!!");
                    break;
            }


        }
    }

    public static void inputData(){
        li.add(new Student("Nguyen Van A", 18, new Address("Minh Khai", "Bac Tu Liem", "Ha Noi"), 111, "CNTT01", 3.2f));
        li.add(new Student("Tran Thi B", 19, new Address("Nguyen Trai", "Ha Dong", "Ha Noi"), 112, "CNTT02", 3.8f));
        li.add(new Student("Le Van C", 20, new Address("Le Duan", "Dong Da", "Ha Noi"), 113, "CNTT03", 2.9f));
        li.add(new Student("Pham Thi D", 21, new Address("Giai Phong", "Hoang Mai", "Ha Noi"), 114, "CNTT04", 3.5f));
        li.add(new Student("Nguyen Van E", 22, new Address("Tran Phu", "Ha Dong", "Ha Noi"), 115, "CNTT05", 3.1f));
        li.add(new Student("Hoang Thi F", 23, new Address("Doi Can", "Ba Dinh", "Ha Noi"), 116, "CNTT06", 3.7f));
    }
}
