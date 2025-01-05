import model.Account;
import model.Address;
import model.Role;
import model.Status;
import service.impl.IAccountServiceImpl;
import service.impl.IAuthServiceImpl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sn = new Scanner(System.in);
    private static final IAccountServiceImpl accountService = new IAccountServiceImpl();
    private static final IAuthServiceImpl authService = new IAuthServiceImpl();

    public static void main(String[] args) {
        accountService.addAccount(new Account("U001", "Nguyen Admin", 20, new Address("Minh Khai", "Bac Tu Liem"),
                "10/10/2010", "admin", "admin123", Role.ADMIN, Status.ACTIVE));
        Account ac1 = new Account("U002", "Tran User", 22, new Address("Cau Dien", "Bac Tu Liem"), "9/9/2009", "user",
                "user123", Role.USER, Status.ACTIVE);
        accountService.addAccount(ac1);
        accountService.getAllAccount();
        // authService.login(sn);
        // boolean isRunning = true;
        // List<Account> accountList = accountService.getAllAccount();
        // if (authService.getCurrentAccount().getRole().equals(Role.ADMIN)) {
        // while (isRunning) {
        // System.out.println("=====HỆ THỐNG QUẢN LÝ TÀI KHOẢN=======");
        // System.out.println("Xin chào ADMIN: " +
        // authService.getCurrentAccount().getUsername());
        // adminMenu();

        // int choice = 0;
        // System.out.print("Enter your choice: ");
        // try {
        // choice = sn.nextInt();
        // } catch (InputMismatchException e) {
        // System.out.println(e.getMessage());
        // }
        // sn.nextLine();

        // switch (choice) {
        // case 1:
        // System.out.println("The list of account: ");
        // accountService.getAllAccount();
        // break;
        // case 2:
        // System.out.println("Create new account: ");
        // Account account = new Account();
        // accountService.createNewAccount(account);
        // System.out.println("Create account successfully!");
        // break;
        // case 3:
        // System.out.println("Enter username want find: ");
        // String username = sn.nextLine();
        // accountService.getAccountByUsername(username);
        // break;
        // case 4:
        // System.out.println("Enter username want delete: ");
        // String username2 = sn.nextLine();
        // accountService.deleteAccount(username2);
        // break;
        // case 5:
        // System.out.println("Enter username want change status: ");
        // String username3 = sn.nextLine();
        // for (Account ac : accountList) {
        // if (ac.getUsername().equals(username3)) {
        // if (ac.getStatus().equals(Status.ACTIVE)) {
        // ac.setStatus(Status.BAN);
        // } else
        // ac.setStatus(Status.ACTIVE);
        // } else {
        // System.out.println("Account not found!");
        // break;
        // }
        // System.out.println("Change status successfully!");
        // }
        // break;
        // case 6:
        // System.out.println("The list of account: ");
        // for (Account ac : accountList) {
        // System.out.println(ac.toString());
        // }
        // break;
        // case 0:
        // System.out.println("Existing Program....");
        // System.exit(0);
        // isRunning = false;
        // break;
        // default:
        // System.out.println("Invalid choice!");
        // }
        // }
        // } else {
        // while (isRunning) {
        // System.out.println("====HỆ THỐNG NGƯỜI DÙNG=====");
        // System.out.println("Xin chào USER: " +
        // authService.getCurrentAccount().getUsername());
        // userMenu();

        // System.out.println("Enter your choice: ");
        // int choice = 0;
        // try {
        // choice = sn.nextInt();
        // } catch (InputMismatchException e) {
        // System.out.println(e.getMessage());
        // }
        // sn.nextLine();

        // switch (choice) {
        // case 1:
        // System.out.println("Enter username and password in account want to change
        // password: ");
        // String username = sn.nextLine();
        // String password = sn.nextLine();
        // for (Account ac : accountList) {
        // if (ac.getUsername().equals(username)) {
        // if (ac.getPassword().equals(password)) {
        // System.out.println("Enter new password:");
        // String newPassword = sn.nextLine();
        // authService.changePassword(username, password, newPassword);
        // System.out.println("Change password successfully!");
        // } else {
        // System.out.println("Password is wrong!");
        // }
        // break;
        // } else {
        // System.out.println("Account not found!");
        // }
        // }
        // break;
        // case 2:
        // System.out.println("Display information: ");
        // System.out.println(authService.getCurrentAccount().toString());
        // System.out.println("Display information successfully!");
        // case 3:
        // System.out.println("Existing Program....");
        // System.exit(0);
        // isRunning = false;
        // default:
        // System.out.println("Invalid choice!");
        // }
        // }
        // }
    }

    public static void adminMenu() {
        System.out.println("Chọn 1 trong các chức năng sau: ");
        System.out.println("1. Get All Account");
        System.out.println("2. Creat Account");
        System.out.println("3. Get account by user name");
        System.out.println("4. Delete account");
        System.out.println("5. Change status");
        System.out.println("6. Display account");
        System.out.println("0. Log out");
        System.out.println("----------------------------------------");
    }

    public static void userMenu() {
        System.out.println("Chọn 1 trong các chức năng sau: ");
        System.out.println("1. Change the password");
        System.out.println("2. Display information");
        System.out.println("0. Log out");
        System.out.println("----------------------------------------");
    }
}