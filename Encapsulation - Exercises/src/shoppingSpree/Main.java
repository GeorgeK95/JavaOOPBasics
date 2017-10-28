package shoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    private static Map<String, Person> people = new LinkedHashMap<>();
    private static Map<String, Product> products = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        try {
            readPeople();
            readProducts();
            buyProducts();
            print();
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void print() {
        people.values().forEach(System.out::println);
    }

    private static void buyProducts() throws IOException {
        String purchase;
        while (!"END".equals(purchase = reader.readLine())) {
            String[] purchaseArgs = purchase.split(" ");
            String personName = purchaseArgs[0];
            String productName = purchaseArgs[1];
            Person person = people.get(personName);
            Product product = products.get(productName);

            try {
                person.buyProduct(product);
                System.out.println(personName + " bought " + productName);
            } catch (IllegalStateException ise) {
                System.out.println(ise.getMessage());
            }
        }
    }

    private static void readProducts() throws IOException, IllegalArgumentException {
        String[] productArgs = reader.readLine().split(";");
        for (String productString : productArgs) {
            String[] productInfo = productString.split("=");
            String name = productInfo[0];
            int price = Integer.parseInt(productInfo[1]);
            Product product = new Product(name, price);
            products.put(name, product);
        }
    }

    private static void readPeople() throws IOException, IllegalArgumentException {

        String[] peopleArgs = reader.readLine().split(";");
        for (String personString : peopleArgs) {
            String[] personInfo = personString.split("=");
            String name = personInfo[0];
            int money = Integer.parseInt(personInfo[1]);
            Person person = new Person(name, money);
            people.put(name, person);
        }
    }
}
