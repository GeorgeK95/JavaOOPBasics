package pizzaCalories;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Pizza {
    private String name;
    private Ingredient dough;
    private List<Ingredient> toppings;
    private int toppingsCount;

    Pizza(String name, int toppingsCount) {
        this.setName(name);
        this.setToppingsCount(toppingsCount);
        this.toppings = new ArrayList<>(toppingsCount);
    }

    int getToppingsCount() {
        return toppingsCount;
    }

    void addTopping(Ingredient topping) {
        this.toppings.add(topping);
    }

    private void setToppingsCount(int toppingsCount) {
        if (toppingsCount < 0 || toppingsCount > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppingsCount = toppingsCount;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.equals("") || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private Ingredient getDough() {
        return dough;
    }

    void setDough(Ingredient dough) {
        this.dough = dough;
    }

    private List<Ingredient> getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        double totalCalories = this.calculateTotalCalories();
        return String.format("%s - %.2f", this.getName(), totalCalories);
    }

    private double calculateTotalCalories() {
        double opa = this.getDough().calculateCalories();
        double opa2 = 0D;
        for (Ingredient topping : this.getToppings()) {
            opa2 += topping.calculateCalories();
        }
        return opa + opa2;
    }
}
