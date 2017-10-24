package person;

import bank.BankAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Person {
    private String name;
    private int age;
    private List<BankAccount> accounts;

    public Person(String name, int age) {
        this(name, age, new ArrayList<>());
    }

    public Person(String name, int age, List<BankAccount> accounts) {
        this.name = name;
        this.age = age;
        this.accounts = accounts;
    }

    double getBalance() {
        return this.accounts.stream().mapToDouble(BankAccount::getBalance).sum();
    }
}
