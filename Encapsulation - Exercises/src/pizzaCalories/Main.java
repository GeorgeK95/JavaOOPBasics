package pizzaCalories;

import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    private static Scanner in = new Scanner(System.in);
    private static Pizza pizza;

    public static void main(String[] args) {
        try {
            readPizza();
            readDough(null);
            readToppings();
            print();
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void print() {
        System.out.println(pizza);
    }

    private static void readToppings() {
        while (true) {
            String line = in.nextLine();
            if ("END".equals(line)) {
                break;
            }
            String[] data = line.split("\\s+");
            Ingredient topping = new Topping(data[1], Double.parseDouble(data[2]));
            pizza.addTopping(topping);
        }
    }

    private static void readDough(String[] dataParam) throws IllegalArgumentException {
        Dough dough;
        if (dataParam != null) {
            dough = new Dough(dataParam[1], dataParam[2], Double.parseDouble(dataParam[3]));
        }
        String[] data = in.nextLine().split("\\s+");
        dough = new Dough(data[1], data[2], Double.parseDouble(data[3]));
        pizza.setDough(dough);
    }

    private static void readPizza() throws IllegalArgumentException {
        String[] data = in.nextLine().split("\\s+");
        if (data[0].equals("Dough")) {
            readDough(data);
            return;
        }
        pizza = new Pizza(data[1], Integer.parseInt(data[2]));
    }
}
