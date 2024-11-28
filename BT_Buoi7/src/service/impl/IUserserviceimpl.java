package service.impl;

import model.Product;
import model.User;
import java.util.ArrayList;
import java.util.Scanner;
import static model.Role.*;

public class IUserserviceimpl implements service.IUserservice {
    private  ArrayList<User> userList = new ArrayList<>();
    private User currentUser;

    public IUserserviceimpl() {
        userList.add(new User("U001", "Nguyen Van A", "nva", "12345678", ADMIN));
        this.currentUser = null;
    }

    @Override
    public boolean login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String pw = scanner.nextLine();
        for(User user : userList){
            if(username.equals(user.getUserName()) && pw.equals(user.getPassWord())){
                currentUser = user;
                System.out.println("Login Successfully!");
                return true;
            }
        }
        System.out.println("Try Again!!!");
        return false;
    }

    @Override
    public boolean logout() {
        if(currentUser != null){
            System.out.println("Log out successfully!");
            currentUser = null;
            return true;
        }
        System.out.println("No user is current log in !!!");
        return false;
    }




}
