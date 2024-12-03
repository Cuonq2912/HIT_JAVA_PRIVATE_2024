package service;

import model.Account;
import model.Status;
import java.util.List;

public interface IAccountService {
    List<Account> getAllAccount();
    void createNewAccount(Account account);
    Account getAccountByUsername(String username);
    void deleteAccount(String username);
    void changeStatus(String username, Status status);
}
