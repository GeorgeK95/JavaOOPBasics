package bank;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class BankAccount {
    private int id;
    private double balance;

    BankAccount(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ID" + this.getId();
    }

    void withdraw(double amount) {
        if (amount < 0 || balance - amount < 0) {
            System.out.println("Insufficient balance");
            return;
        }
        this.balance -= amount;
    }

    void deposit(double amount) {
        if (amount < 0) {
            return;
        }
        this.balance += amount;
    }

    private int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

}
