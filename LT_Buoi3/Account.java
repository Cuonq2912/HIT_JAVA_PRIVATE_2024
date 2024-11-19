package LT_Buoi3;

public class Account {
    private int id;
    private String name;
    private int balance;

    public Account(int id, String name){
        this.id = id;
        this.name = name;
    }
    public Account(int id, String name, int balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBalance() {
        return balance;
    }
    public void deposit(int amount){
        if(amount > 0) {
            this.balance += amount;
        }
    }
    public void withdraw(int amount){
        if(this.balance < amount){
            System.out.println("That amount exceeds your current balance.");
        }else{
            this.balance -= amount;
        }
    }
    public void display() {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }
}
