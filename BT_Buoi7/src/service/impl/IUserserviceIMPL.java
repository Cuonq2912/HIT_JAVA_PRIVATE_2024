package service.impl;
import model.Role;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class IUserserviceIMPL implements service.IUserservice {
    Scanner sn = new Scanner(System.in);

    private final ArrayList<User> userList = new ArrayList<User>();
    private User currentUser;

    public IUserserviceIMPL() {
        userList.add(new User("u001", "Admin", "admin", "admin123", Role.ADMIN));
        userList.add(new User("u002", "User", "user", "user123", Role.USER));
    }

    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public void login() {
        System.out.println("Enter username: ");
        String userName = sn.nextLine();
        System.out.println("Enter password: ");
        String passWord = sn.nextLine();

        for(User user : userList){
            if(user.getUserName().equals(userName) && user.getPassWord().equals(passWord)){
                System.out.println("Login successfully!!");
                currentUser = user;
                return;
            }
        }
        System.out.println("Invalid name or password!!!");
    }

    @Override
    public void logout() {
        if(currentUser != null){
            System.out.println("Logout successfully!");
            currentUser = null;
        }
        else System.out.println("No user is currently logged in!!");
    }

}
