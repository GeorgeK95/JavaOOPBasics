package bankExtended;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    private static HashMap<Integer, BankAccount> accountsBook = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while (!"End".equals(line)) {
            String[] data = line.split("\\s+");
            String command = data[0];
            switch (command) {
                case "Create":
                    createAccount();
                    break;
                case "Deposit":
                    deposit(Integer.parseInt(data[1]), Double.parseDouble(data[2]));
                    break;
                case "SetInterest":
                    setInterest(Double.parseDouble(data[1]));
                    break;
                case "GetInterest":
                    getInterest(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                    break;
                default:
                    break;
            }
            line = in.nextLine();
        }
    }

    private static void getInterest(int id, int years) {
        BankAccount account = accountsBook.get(id);
        if (accountExists(account)) {
            System.out.printf("%.2f%n", account.getInterest(years));
        }
    }

    private static void deposit(int id, double amount) {
        BankAccount account = accountsBook.get(id);
        if (accountExists(account)) {
            account.deposit(amount);
            System.out.printf("Deposited %.0f to %s%n", amount, account);
        }


    }

    private static boolean accountExists(BankAccount account) {
        if (account == null) {
            System.out.println("Account does not exist");
            return false;
        }
        return true;
    }

    private static void createAccount() {
        BankAccount account = new BankAccount();
        accountsBook.put(account.getId(), account);
        System.out.printf("Account %s created%n", account);
    }

    public static void setInterest(double interest) {
        BankAccount.setInterestRate(interest);
    }
}
