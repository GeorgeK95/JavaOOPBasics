package bankExtended;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class BankAccount {
    private static int accountsCount = 0;
    private static double INTEREST_RATE = 0.02;

    private int id;
    private double balance;

    @Override
    public String toString() {
        return "ID" + this.getId();
    }

    int getId() {
        return id;
    }

    BankAccount() {
        accountsCount++;
        this.id = accountsCount;
    }

    static void setInterestRate(double interest) {
        BankAccount.INTEREST_RATE = interest;
    }

    double getInterest(int years) {
        return this.balance * INTEREST_RATE * years;
    }

    void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }
}
