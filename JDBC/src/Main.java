import dao.ProductDAO;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        try {
            while (true) {
                System.out.println("\n=== QUẢN LÝ SẢN PHẨM ===");
                System.out.println("1. Thêm sản phẩm");
                System.out.println("2. Sửa thông tin sản phẩm");
                System.out.println("3. Xóa sản phẩm");
                System.out.println("4. Tìm sản phẩm");
                System.out.println("5. Xem danh sách sản phẩm");
                System.out.println("6. Thoát");
                System.out.print("Chọn thao tác (1-6): ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        productDAO.insertProduct();
                        break;
                    case 2:
                        productDAO.updateProduct();
                        break;
                    case 3:
                        productDAO.deleteProduct();
                        break;
                    case 4:
                        Product productGetById = productDAO.getById();
                        System.out.println(productGetById.toString());
                        break;
                    case 5:
                        ArrayList<Product> listProduct = productDAO.viewAllProducts();
                        for (Product product : listProduct)
                            System.out.println(product.toString());
                        break;
                    case 6:
                        System.out.println("Đã thoát chương trình.");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}