package shoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Person {
    private String name;
    private double money;
    private List<Product> bag;

    Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.bag = new ArrayList<>();
    }

    void buyProduct(Product product) {
        if (this.getMoney() - product.getCost() < 0) {
            throw new IllegalStateException(String.format("%s can't afford %s", this.getName(), product.getName()));
        }
        this.bag.add(product);
        this.money -= product.getCost();
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        if (this.getBag().size() == 0) {
            return this.getName() + " - Nothing bought";
        }
        return this.getName() + " - " + String.join(", ", this.getBag().stream().map(Object::toString).collect(Collectors.toList()));
    }

    private void setName(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private double getMoney() {
        return money;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    List<Product> getBag() {
        return bag;
    }
}
