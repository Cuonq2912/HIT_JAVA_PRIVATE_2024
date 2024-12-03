import model.Role;
import service.impl.IProductserviceIMPL;
import service.impl.IUserserviceIMPL;
import java.util.Scanner;

public class Main {

    private static final Scanner sn = new Scanner(System.in);
    private static final IProductserviceIMPL productManagement = new IProductserviceIMPL();
    private static final IUserserviceIMPL user = new IUserserviceIMPL();

    public static void main(String[] args) throws Exception {
        user.login();
        boolean isRunning = true;
        if(user.getCurrentUser().getRole().equals(Role.ADMIN)){
            while(isRunning){
                adminMenu();
                int choice = sn.nextInt();
                sn.nextLine();

                switch (choice){
                    case 1:
                        if(productManagement.addProduct(sn)) System.out.println("Add product successfully!!");
                        else System.out.println("Add product unsuccessfully");
                        break;
                    case 2:
                        productManagement.display();
                        System.out.println("Display successfully!");
                        break;
                    case 3:
                        SearchProductByName();
                        break;
                    case 4:
                        System.out.println("Nhap id cua san pham muon xoa: ");
                        String id = sn.nextLine();
                        if(productManagement.deleteById(id)) System.out.println("Xoa thanh cong!!!");
                        else System.out.println("Khong tim thay san pham co id " + id);
                        break;
                    case 5:
                        System.out.println("Nhap id san pham muon cap nhat: ");
                        String idUpdate = sn.nextLine();
                        if(productManagement.updateProductByID(idUpdate)) System.out.println("Cap nhat thanh cong");
                        else System.out.println("Khong tim thay san pham co id " + idUpdate);
                        break;
                    case 6:
                        ExitProgram();
                        isRunning = false;
                        break;
                    default:
                        System.out.println("lua chon khong hop le!. Nhap lai");
                }
            }
        }
        else{
            while(isRunning){
                userMenu();
                int choice = sn.nextInt();
                sn.nextLine();
                switch (choice){
                    case 1:
                        productManagement.display();
                        System.out.println("Display successfully!");
                        break;
                    case 2:
                        SearchProductByName();
                        break;
                    case 3:
                        ExitProgram();
                        isRunning = false;
                        break;
                    default:
                        System.out.println("lua chon khong hop le!. Nhap lai");
                }
            }
        }
    }

    public static void adminMenu(){
        System.out.println("===================QUẢN LÝ SẢN PHẨM===================");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Hiển thị danh sách");
        System.out.println("3. Tìm kiếm sản phẩm bằng tên");
        System.out.println("4. Xóa sản phẩm bằng id");
        System.out.println("5. Cập nhập sản phẩm bằng id");
        System.out.println("6. Thoát chương trình");
    }
    public static void userMenu(){
        System.out.println("=================USER OPERATIONS================");
        System.out.println("1. Hiển thị danh sách sản phẩm");
        System.out.println("2. Tìm sản phẩm bằng tên");
        System.out.println("3. Thoát chương trình");
    }

    public static void SearchProductByName(){
        System.out.println("Nhập tên sản phẩm muốn tìm kiếm!");
        String name = sn.nextLine();
        if(productManagement.searchByName(name)) System.out.println("Da tim thay");
        else System.out.println("Khong tim thay san pham co ten " + name);
    }

    public static void ExitProgram(){
        System.out.println("Da thoat chuong trinh");
        System.exit(0);
    }
}