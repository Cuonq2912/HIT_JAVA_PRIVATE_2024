package service.impl;

import model.Account;
import model.Address;
import model.Role;
import model.Status;
import service.IAccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class IAccountServiceImpl implements IAccountService {
    Scanner sn = new Scanner(System.in);
    List<Account> accountList = new ArrayList<>();
    Account currentAccount = null;


    public IAccountServiceImpl() {
    }

    @Override
    public List<Account> getAllAccount() {
        return this.accountList;
    }

    @Override
    public void createNewAccount(Account account) {
        account = new Account();
        String newID;
        while(true){
            try{
                System.out.println("Enter id: ");
                newID = sn.nextLine();
                if(isDuplicateID(newID)){
                    throw new IllegalArgumentException("ID is duplicate!!!");
                }
                else{
                    account.setId(newID);
                    break;
                }
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("An unexpected error has occurred.");
            }
        }
        account.setId(newID);
        System.out.println("Enter name: ");
        account.setFullName(sn.nextLine());

        System.out.println("Enter age: ");
        int newAge = 0;
        try{
            newAge = sn.nextInt();
        } catch (IllegalArgumentException e){
            System.out.println("Age is invalid!!!");
        }
        account.setAge(newAge);

        System.out.println("Enter address: ");
        account.setAddress(new Address(sn.nextLine(), sn.nextLine()));

        System.out.println("Enter birthday: ");
        account.setBirthday(sn.nextLine());

        System.out.println("Enter username: ");
        account.setUsername(sn.nextLine());

        System.out.println("Enter password: ");
        account.setPassword(sn.nextLine());

        try{
            System.out.println("Enter role(ADMIN or USER): ");
            account.setRole(Role.valueOf(sn.nextLine().toUpperCase()));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid role!!!");
            return;
        }

        try{
            System.out.println("Enter status(ACTIVE or INACTIVE): ");
            account.setStatus(Status.valueOf(sn.nextLine().toUpperCase()));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid status!!!");
            return;
        }
    }

    private boolean isDuplicateID(String id){
        for(Account account : accountList){
            if(account.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Account getAccountByUsername(String username) {
        for(Account account : accountList){
            if(account.getUsername().equals(username)){
                return account;
            }
        }
        return null;
    }

    @Override
    public void deleteAccount(String username) {
        for(Account account : accountList){
            if(account.getUsername().equals(username)){
                accountList.remove(account);
                System.out.println("Delete successfully");
                return;
            }
        }
    }

    @Override
    public void changeStatus(String username, Status status) {
        for(Account account : accountList){
            if(account.getUsername().equals(username)){
                account.setStatus(status);
                System.out.println("Change status successfully");
                return;
            }
        }
    }



}
