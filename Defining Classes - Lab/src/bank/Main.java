package bank;

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
                    createAccount(Integer.parseInt(data[1]));
                    break;
                case "Deposit":
                    deposit(Integer.parseInt(data[1]), Double.parseDouble(data[2]));
                    break;
                case "Withdraw":
                    withdraw(Integer.parseInt(data[1]), Double.parseDouble(data[2]));
                    break;
                case "Print":
                    print(Integer.parseInt(data[1]));
                    break;
                default:
                    break;
            }
            line = in.nextLine();
        }
    }

    private static void print(int id) {
        if (accountExists(id)) {
            BankAccount acc = accountsBook.get(id);
            System.out.printf("Account %s, balance %.2f%n", acc, acc.getBalance());
        }
    }

    private static boolean accountExists(int id) {
        if (!accountsBook.containsKey(id)) {
            System.out.println("Account does not exist");
            return false;
        }
        return true;
    }

    private static void withdraw(int id, double amount) {
        if (accountExists(id)) {
            BankAccount bankAccount = accountsBook.get(id);
            bankAccount.withdraw(amount);
            accountsBook.put(id, bankAccount);
        }
    }

    private static void deposit(int id, double amount) {
        if (accountExists(id)) {
            BankAccount bankAccount = accountsBook.get(id);
            bankAccount.deposit(amount);
            accountsBook.put(id, bankAccount);
        }
    }

    private static void createAccount(int id) {
        if (accountsBook.containsKey(id)) {
            System.out.println("Account already exists");
            return;
        }
        accountsBook.put(id, new BankAccount(id));
    }

}
