package service.impl;

import model.Role;
import model.User;
import service.IUserservice;

import java.util.ArrayList;
import java.util.Scanner;

public class IUserserviceIMPL implements IUserservice {
    Scanner sn = new Scanner(System.in);
    private final ArrayList<User> users = new ArrayList<>();
    private User currentUser;

    public IUserserviceIMPL() {
        users.add(new User("U001", "Admin", "admin", "admin123", Role.ADMIN));
        users.add(new User("U002", "User", "user", "user123", Role.USER));
    }

    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public void login() {
        System.out.println("Enter username: ");
        String username = sn.nextLine();
        System.out.println("Enter password: ");
        String password = sn.nextLine();

        for(User user: users){
            if(user.getUserName().equals(username) && user.getPassWord().equals(password)){
                currentUser = user;
                System.out.println("Login successfully!!!");
                return;
            }
        }
        System.out.println("Invalid username or password!!!");
    }

    @Override
    public void logout() {
        if(currentUser != null){
            System.out.println("log out successfully!");
            currentUser = null;
        }
        System.out.println("No user is currenly log in!");
    }
}
