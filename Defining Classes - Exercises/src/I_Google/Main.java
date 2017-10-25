package I_Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    private static Map<String, Person> map = new HashMap<>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        readData();
        print();
    }

    private static void print() {
        String wantedName = in.nextLine();
        Person foundPerson = map.get(wantedName);
        System.out.println(foundPerson);
    }

    private static void readData() {
        while (true) {
            String[] data = in.nextLine().split("\\s+");
            if ("End".equals(data[0])) {
                break;
            }
            String personName = data[0];
            Company company = null;
            Pokemon pokemon = null;
            Parent parent = null;
            Parent children = null;
            Car car = null;

            switch (data[1]) {
                case "company":
                    company = new Company(data[2], data[3], Double.parseDouble(data[4]));
                    break;
                case "pokemon":
                    pokemon = new Pokemon(data[2], data[3]);
                    break;
                case "parents":
                    parent = new Parent(data[2], data[3]);
                    break;
                case "children":
                    children = new Parent(data[2], data[3]);
                    break;
                case "car":
                    car = new Car(data[2], Integer.parseInt(data[3]));
                    break;
            }

            writeData(personName,company,car,children,parent,pokemon);
        }
    }

    private static void writeData(String personName, Company company, Car car, Parent children, Parent parent, Pokemon pokemon) {
        if (!map.containsKey(personName)) {
            Person person = new Person(personName, company, car);
            person.addChildren(children);
            person.addParent(parent);
            person.addPokemon(pokemon);
            map.put(personName, person);
        } else {
            Person found = map.get(personName);
            found.setCompany(company);
            found.setCar(car);
            found.addChildren(children);
            found.addParent(parent);
            found.addPokemon(pokemon);
            map.put(personName, found);
        }
    }
}
