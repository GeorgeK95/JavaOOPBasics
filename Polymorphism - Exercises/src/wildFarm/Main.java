package wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    private static List<Animal> animals = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String animal = in.nextLine();
            if (animal.equals("End")) {
                print();
                break;
            }
            String[] animalData = animal.split("\\s+");
            String[] vegetableData = in.nextLine().split("\\s+");

            processAnimal(animalData, vegetableData);
        }
    }

    private static void print() {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    private static void processAnimal(String[] animalData, String[] vegetableData) {
        String animalType = animalData[0];
        String name = animalData[1];
        double weight = Double.parseDouble(animalData[2]);
        String livingRegion = animalData[3];
        try {
            Animal animal;
            switch (animalType) {
                case "Mouse":
                    animal = new Mouse(name, animalType, weight, livingRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(name, animalType, weight, livingRegion);
                    break;
                case "Cat":
                    animal = new Cat(name, animalType, weight, livingRegion, animalData[4]);
                    break;
                case "Tiger":
                    animal = new Tiger(name, animalType, weight, livingRegion);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid animal type!");
            }

            String vegetableType = vegetableData[0];
            int calories = Integer.parseInt(vegetableData[1]);
            Food food;
            switch (vegetableType) {
                case "Vegetable":
                    food = new Vegetable(calories);
                    break;
                case "Meat":
                    food = new Meat(calories);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid food type!");
            }

            animal.makeSound();
            try {
                animal.eat(food);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
            animals.add(animal);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }


    }
}
