package service;

import model.Product;

import java.util.Scanner;

public interface IUserservice {
    public boolean login(Scanner scanner);
    public boolean logout();

}
