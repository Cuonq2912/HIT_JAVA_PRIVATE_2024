package model;

import service.IProductservice;
import service.IUserservice;
import service.impl.IProductserviceimpl;
import service.impl.IUserserviceimpl;
import model.Role;
import java.util.Scanner;

public class ProductManager {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        IUserservice userservice = new IUserserviceimpl();
        IProductservice productservice = new IProductserviceimpl();
        User hi = new User("U002", "Nguyễn Thị B", "ntb", "123455679", Role.CUSTOMER);

        while(true){
            System.out.println(
                            "1. Thêm sản phẩm\n"  +
                            "2. Hiển thị danh sách sản phẩm\n" +
                            "3. Tìm kiếm sản phẩm theo tên \n" +
                            "4. Xóa sản phẩm theo mã\n" +
                            "5. Cập nhật thông tin sản phẩm\n" +
                            "6. login\n" +
                            "7. logout\n"
            );
            System.out.print("Enter your choice: ");
            int choice = sn.nextInt();
            switch (choice){
                case 1:
                    Product product =
                    productservice.addProduct()

            }
        }
    }
}
