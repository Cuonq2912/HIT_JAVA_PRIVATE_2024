import model.User;
import model.Role;
import service.IUserservice;
import service.impl.IUserserviceImpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IUserservice usersevice = new IUserserviceImpl();
        User hi = new User("002", "nguyen", "df@mgail.com", "0111", 12, "2005-01-01", Role.USER);
        while(true){
            System.out.println("1.login\n" +
                    "2.displayMember\n" +
                    "3.addMember(Admin only)\n" +
                    "4.deleteMember(Admin only)\n" +
                    "5.Logout\n" +
                    "6.Exit\n");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    usersevice.login(scanner);
                    break;
                case 2:
                    usersevice.display();
                    break;
                case 3:
                    if(usersevice.addMember(hi)){
                        System.out.println("Success add");
                    }
                    else{
                        System.out.println("Successn't add");
                    }
                    break;
                case 4:
                    System.out.print("Nhap id muon xoa: ");
                    String id = scanner.nextLine();
                    if(usersevice.deleteMember(id)){
                        System.out.println("Delete successfully");
                    }
                    else{
                        System.out.println("Delete Unsuccessfully!");
                    }
                    break;
                case 5:
                    usersevice.logout();
                    System.out.println("Log out successfully");
                    break;
                case 6:
                    System.exit(0);
                    System.out.println("Exit!");
                default:
                    System.out.println("Invalid choice");
                    
            }
        }
    }
}