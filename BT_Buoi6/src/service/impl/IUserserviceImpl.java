package service.impl;

import model.Role;
import model.User;
import service.IUserservice;

import java.util.ArrayList;
import java.util.Scanner;

public class IUserserviceImpl implements IUserservice {
    private ArrayList<User> userList = new ArrayList<>();
    private User currentUser;


    public IUserserviceImpl() {
        userList.add(new User("001", "Nguyen van A", "nguyen@gmail.com", "01234567", 18, "12/12/2012", Role.ADMIN));
        currentUser = null;
    }

    @Override
    public void login(Scanner scanner){
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter pw: ");
        String passWord = scanner.nextLine();

        for(User user : userList){
            if(user.getEmail().equals(email) && user.getPassWord().equals(passWord)){
                currentUser = user;
                System.out.println("Login successfully!!!");
                return;
            }
        }
        System.out.println("Invalid Email or Password!!!");
    }

    public IUserserviceImpl(ArrayList<User> listUser) {
        this.userList = listUser;
    }


    public void logout(){
        if(currentUser != null){
            System.out.println("Log out successfully!");
            currentUser = null;
        }
        else{
            System.out.println("No user is currently logged in!!!");
        }
    }


    @Override
    public boolean addMember(User user) {
        if(isAdmin()){
            userList.add(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteMember(String id) {
        if (isAdmin()) {
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getId().equals(id)) {
                    userList.remove(i);
                    System.out.println("Member with ID " + id + " has been removed.");
                    return true;
                }
            }
            System.out.println("Member with ID " + id + " not found.");
        } else {
            System.out.println("Only ADMIN can delete members!");
        }
        return false;
    }

    @Override
    public void display() {
        if(userList.isEmpty()){
            System.out.println("No member found!");
        }
        else {
            System.out.println("Member List: ");
            for(User user : userList){
                user.display();
            }
        }
    }
    private boolean isAdmin(){
//        if(currentUser != null && currentUser.getRole() == Role.ADMIN){
//            return true;
//        }
//        return false;
        return currentUser != null && currentUser.getRole() == Role.ADMIN;
    }


}
