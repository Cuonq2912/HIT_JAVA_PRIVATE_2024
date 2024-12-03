package service.impl;

import model.Account;
import model.Address;
import model.Role;
import model.Status;
import service.IAuthService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IAuthServiceImpl implements IAuthService {
    List<Account> accountList = new ArrayList<>();
    Account currentAccount = null;

    public IAuthServiceImpl() {
        accountList.add(new Account("U001", "Nguyen Admin", 20, new Address("Minh Khai", "Bac Tu Liem"), "10/10/2010", "admin", "admin123", Role.ADMIN, Status.ACTIVE));
        accountList.add(new Account("U002", "Tran User", 22, new Address("Cau Dien", "Bac Tu Liem"), "9/9/2009", "user", "user123", Role.USER, Status.ACTIVE));
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    @Override
    public void login(Scanner scanner) {
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        for(Account account : accountList){
            if(account.getUsername().equals(username) && account.getPassword().equals(password)){
                currentAccount = account;
                System.out.println("Login successful");
                break;
            }
            else{
                System.out.println("Wrong username or password");
            }
        }
    }

    @Override
    public void logout() {
        if(currentAccount != null){
            System.out.println("Logout successful");
            currentAccount = null;
        }
    }

    @Override
    public void changePassword(String username, String oldPassword, String newPassword) {
        for(Account account : accountList){
            if(account.getUsername().equals(username) && account.getPassword().equals(oldPassword)){
                account.setPassword(newPassword);
                System.out.println("change password successful");
                return;
            }
        }
        System.out.println("Wrong username or password");
        return;
    }
}
