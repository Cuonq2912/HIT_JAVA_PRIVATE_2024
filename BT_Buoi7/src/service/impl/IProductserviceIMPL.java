package service.impl;

import model.PhysicalProduct;
import model.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IProductserviceIMPL implements service.IProductservice {
    Scanner sn = new Scanner(System.in);
    private final ArrayList<Product> productList = new ArrayList<>();

    @Override
    public boolean addProduct(Scanner sn) throws Exception {
        PhysicalProduct newProduct = new PhysicalProduct();
        String newID;
        while (true) {
            try {
                System.out.println("Nhập id mới: ");
                newID = sn.nextLine();
                if(isDuplicateID(newID)){
                    throw new IllegalArgumentException("ID đã tồn tại!!");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        newProduct.setId(newID);
        System.out.println("Nhập tên: ");
        newProduct.setName(sn.nextLine());
        newProduct.setPrice(getValidValue("Nhập giá"));
        newProduct.setQuantity((int)getValidValue("Nhập số lượng"));

        productList.add(newProduct);
        return true;
    }

    private boolean isDuplicateID(String id) {
        for (Product pr : productList) {
            if (pr.getId().equals(id)) return true;
        }
        return false;
    }

    private double getValidValue(String promt){
        while(true){
            try{
                System.out.println(promt);
                double value = sn.nextDouble();
                if(value < 0 || value > Double.MAX_VALUE){
                    System.out.println("Gia tri khong hop le");
                }
                return value;
            } catch(InputMismatchException e){
                System.out.println("Vui lòng nhập sô hợp lệ!");
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public boolean deleteById(String id) {
        for(Product pr : productList){
            if(pr.getId().equals(id)){
                productList.remove(pr);
                return true;
            }
        } return false;
    }

    @Override
    public boolean updateProductByID(String id) {
        for(Product pr : productList){
            if(pr.getId().equals(id)){
                //update
                System.out.println("Nhập tên: ");
                sn.nextLine();
                pr.setName(sn.nextLine());
                pr.setPrice(getValidValue("Nhập giá"));
                pr.setQuantity((int)getValidValue("Nhập số lượng"));
                return true;
            }
        }
        return false;
    }

    @Override
    public void display() {
        System.out.println("Danh sach hien tai: ");
        for(Product pr : productList){
            System.out.println(pr.toString());
        }
    }

    @Override
    public boolean searchByName(String name) {
        for(Product pr : productList){
            if(pr.getName().equals(name)){
                System.out.println("thong tin cua sp: ");
                System.out.println(pr);
                return true;
            }
        }
        return false;
    }
}
