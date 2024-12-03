package service;
import java.util.Scanner;

public interface IProductservice {
    boolean addProduct(Scanner sn) throws Exception;
    boolean deleteById(String id);
    boolean updateProductByID(String id);
    void display();
    boolean searchByName(String name);
}
