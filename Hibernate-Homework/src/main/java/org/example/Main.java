package org.example;

import javax.swing.text.html.parser.Entity;

import jakarta.persistence.EntityManager;
import org.example.model.Category;
import org.example.model.EntityManagerUtil;
import org.example.model.Product;
import org.example.service.EntityService;
import org.example.service.Impl.ICategoryServiceImpl;
import org.example.service.Impl.IProductServiceImpl;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityService<Category> categoryService = new ICategoryServiceImpl();
        EntityService<Product> productService = new IProductServiceImpl();

        Scanner sn = new Scanner(System.in);
        boolean status = true;
        while(status){
            System.out.println("1. Add category");
            System.out.println("2. Delete category");
            System.out.println("3. Update category");
            System.out.println("4. Display all categories");
            System.out.println("5. Add product");
            System.out.println("6. Delete product");
            System.out.println("7. Update product");
            System.out.println("8. Display all products");
            System.out.println("9. Exit");
            System.out.println("Enter your choice: ");
            int choice = sn.nextInt();
            sn.nextLine();
            switch (choice) {
                case 1:
                    Category category = new Category();
                    categoryService.add(category);
                    break;
                case 2:
                    System.out.println("Enter id: ");
                    UUID id = UUID.fromString(sn.nextLine());
                    categoryService.delete(id);
                    break;
                case 3:
                    System.out.println("Enter id: ");
                    id = UUID.fromString(sn.nextLine());
                    categoryService.update(id);
                    break;
                case 4:
                    categoryService.display();
                    break;
                case 5:
                    Product product = new Product();
                    productService.add(product);
                    break;
                case 6:
                    System.out.println("Enter id: ");
                    id = UUID.fromString(sn.nextLine());
                    productService.delete(id);
                    break;
                case 7:
                    System.out.println("Enter id: ");
                    id = UUID.fromString(sn.nextLine());
                    productService.update(id);
                    break;
                case 8:
                    productService.display();
                    break;
                case 9:
                    entityManager.close();
                    sn.close();
                    status = false;
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!. Try again");
            }
        }
    }
}