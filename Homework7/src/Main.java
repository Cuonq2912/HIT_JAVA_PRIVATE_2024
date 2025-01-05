import model.Role;
import service.impl.IProductserviceIMPL;
import service.impl.IUserserviceIMPL;

import java.util.InputMismatchException;
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
                int choice = 0;
                try{
                    choice = sn.nextInt();
                } catch (InputMismatchException e){
                    System.out.println(e.getMessage());
                }
                sn.nextLine();
                switch (choice){
                    case 1:
                        if(productManagement.addProduct(sn)) System.out.println("Add product successfully!!!");
                        else System.out.println("Add product unsuccessfully!!!");
                        break;
                    case 2:
                        System.out.println("Nhap id san pham muon xoa: ");
                        String id = sn.nextLine();
                        if(productManagement.deleteByID(id)) System.out.println("Delete product successfully!!!");
                        else System.out.println("Delete product unsuccessfully!!!");
                        break;
                    case 3:
                        System.out.println("Nhap id san pham muon cap nhat: ");
                        String id2 = sn.nextLine();
                        if(productManagement.updateByID(id2)) System.out.println("Update product successfully!!!");
                        else System.out.println("Update product unsuccessfully!!!");
                        break;
                    case 4:
                        searchProduct();
                        break;
                    case 5:
                        displayAllProduct();
                        break;
                    case 6:
                        isRunning = false;
                        exit();
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            }
        }
        else{
            while(isRunning){
                userMenu();
                int choice = 0;
                try{
                    choice = sn.nextInt();
                }catch (InputMismatchException e){
                    System.out.println(e.getMessage());
                }
                sn.nextLine();
                switch (choice){
                    case 1:
                        searchProduct();
                        break;
                    case 2:
                        displayAllProduct();
                        break;
                    case 3:
                        isRunning = false;
                        exit();
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                }
            }
        }

    }

    public static void adminMenu(){
        System.out.println("------------------------ADMIN-----------------------");
        System.out.println("1. Add Product");
        System.out.println("2. Delete Product");
        System.out.println("3. Update Product");
        System.out.println("4. Search Product");
        System.out.println("5. Display All Products");
        System.out.println("6. Exit");
        System.out.println("Enter your choice");
    }

    public static void userMenu(){
        System.out.println("----------------------USER---------------------------");
        System.out.println("1. Search Product");
        System.out.println("2. Display All Products");
        System.out.println("3. Exit");
        System.out.println("Enter your choice");
    }

    public static void searchProduct(){
        System.out.println("Nhap ten san pham muon tim: ");
        String name = sn.nextLine();
        if(productManagement.searchByName(name)) System.out.println("Search product successfully!!!");
        else System.out.println("Search product unsuccessfully!!!");
    }

    public static void displayAllProduct(){
        productManagement.display();
        System.out.println("Display product successfully!!!");
    }

    public static void exit(){
        System.out.println("Existing program....");
        System.exit(0);
    }
}