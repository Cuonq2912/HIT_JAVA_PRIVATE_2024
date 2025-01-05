package service;

import model.User;

import java.util.Scanner;

public interface IUserservice {
    public void login(Scanner scanner);
    public void logout();
    public boolean addMember(User user);
    public boolean deleteMember(String id); // only admin
    public void display(); // only admin
}
