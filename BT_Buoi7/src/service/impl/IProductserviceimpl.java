package service.impl;

import model.Product;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;
import static model.Role.ADMIN;

public class IProductserviceimpl implements service.IProductservice {
    private static ArrayList<Product> productList = new ArrayList<>();
    private User currentUser = null;

    @Override
    public boolean addProduct(Product product) {
        if(isAdmin()){
            productList.add(product);
            System.out.println("Add product successfully!!!");
            return true;
        }
        System.out.println("Only admin can add product");
        return false;
    }

    @Override
    public boolean display() {
        System.out.println("List product: ");
        for(Product product : productList){
            product.display();
        }
        return false;
    }

    @Override
    public boolean findWithNameProduct(String name) {
        for(Product product : productList){
            if(product.getName() == name){
                product.display();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteProduct(String id) {
        if(isAdmin()){
            productList.remove(id);
            System.out.println("Remove product successfully!!!");
            return true;
        }
        return false;
    }

    @Override
    public boolean updateProduct(String id) {
        Scanner sn = new Scanner(System.in);
        if(isAdmin()){
            System.out.print("Nhập tên sản phẩm mới: ");
            String newName = sn.nextLine();
            System.out.print("Nhập giá sản phẩm mới: ");
            Double newPrice = sn.nextDouble();
            System.out.print("Nhập số lượng sản phẩm: ");
            int newQuantity = sn.nextInt();
            for(Product product : productList){
                if(product.getId() == id){
                    product.setName(newName);
                    product.setPrice(newPrice);
                    product.setQuantity(newQuantity);
                }
                return true;
            }
        }
        return false;
    }

    private boolean isAdmin(){
        return currentUser != null && currentUser.getRole() == ADMIN;
    }
}
