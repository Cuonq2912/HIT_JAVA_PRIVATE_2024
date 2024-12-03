package service.impl;

import model.PhysicalProduct;
import model.Product;
import service.IProductservice;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IProductserviceIMPL implements IProductservice {
    Scanner sn = new Scanner(System.in);
    private final ArrayList<Product> products = new ArrayList<>();

    @Override
    public boolean addProduct(Scanner sn) throws Exception {
        PhysicalProduct newProduct = new PhysicalProduct();
        String newID;
        while(true){
            try{
                System.out.println("Nhap id: ");
                newID = sn.nextLine();
                if(isDuplicateID(newID)){
                    throw new IllegalArgumentException("ID is duplicate");
                }
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace();
            }
            System.out.println("Enter again:");
        }
        newProduct.setId(newID);
        System.out.println("Nhap ten: ");
        newProduct.setName(sn.nextLine());

        newProduct.setPrice(getValidValue("Nhap gia: "));
        newProduct.setQuantity((int)getValidValue("Nhap so luong: "));
        products.add(newProduct);
        return true;
    }

    private Boolean isDuplicateID(String id){
        for(Product product : products){
            if(product.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
    private double getValidValue(String prompt){
        while(true){
            try{
                System.out.println(prompt);
                double value = sn.nextDouble();
                if(value < 0 || value > Double.MAX_VALUE){
                    throw new IllegalArgumentException("Gia tri khong hop le!!");
                }
                return value;
            } catch (InputMismatchException e){
                System.out.println("Vui long nhap so hop le!!!");
            }
        }
    }

    @Override
    public boolean deleteByID(String id) {
        for(Product product : products){
            if(product.getId().equals(id)){
                products.remove(product);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateByID(String id) {
        for(Product product : products){
            if(product.getId().equals(id)){
                System.out.println("Nhap ten: ");
                sn.nextLine();
                product.setName(sn.nextLine());
                product.setPrice(getValidValue("Nhap gia: "));
                product.setQuantity((int)getValidValue("Nhap so luong: "));
                return true;
            }
        } return false;
    }

    @Override
    public boolean searchByName(String name) {
        for(Product product : products){
            if(product.getName().equals(name)){
                System.out.println("Thong tin cua san pham la: ");
                System.out.println(product);
                return true;
            }
        }
        return false;
    }

    @Override
    public void display() {
        System.out.println("Danh sach san pham hien tai: ");
        for(Product product : products){
            System.out.println(product.toString());
        }
    }
}
