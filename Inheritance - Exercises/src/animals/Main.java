package animals;

import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            if ("Beast!".equals(line)) {
                break;
            }
            try {
                writeData(line, in.nextLine().split("\\s+"));
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    private static void writeData(String animalType, String[] animalData) throws IllegalArgumentException {
        Animal animal;
        String name = animalData[0];
        int age = Integer.parseInt(animalData[1]);
        String gender = animalData[2];
        switch (animalType.toLowerCase()) {
            case "dog":
                animal = new Dog(name, age, gender);
                break;
            case "cat":
                animal = new Cat(name, age, gender);
                break;
            case "frog":
                animal = new Frog(name, age, gender);
                break;
            case "kitten":
                animal = new Kitten(name, age, gender);
                break;
            case "tomcat":
                animal = new Tomcat(name, age, gender);
                break;
            default:
                throw new IllegalArgumentException("Invalid input!");
        }
        System.out.println(animal);
        animal.produceSound();
    }

}
