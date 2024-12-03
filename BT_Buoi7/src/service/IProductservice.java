package service;
import java.util.Scanner;

public interface IProductservice {
    boolean addProduct(Scanner sn) throws Exception;
    boolean deleteByID(String id);
    boolean updateByID(String id);
    boolean searchByName(String name);
    void display();

}
